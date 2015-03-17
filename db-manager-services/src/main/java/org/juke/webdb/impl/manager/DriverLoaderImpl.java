package org.juke.webdb.impl.manager;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.juke.webdb.api.manager.DriverLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Serhii Krivtsov
 *
 */
@Service
public class DriverLoaderImpl implements DriverLoader {

    private static final String DRIVER_VERSION_TEMPLATE = "%s.%s";

    private static final String JAR_URL_TEMPLATE = "jar:file:%s!/";

    private static Logger logger = LoggerFactory.getLogger(DriverLoaderImpl.class);

    // TODO: move to utility class (db-manager-utils module)
    private static void closeQuietly(Closeable closable) {
        if (closable != null) {
            try {
                closable.close();
            } catch (IOException e) {
                // DO NOTNING
            }
        }
    }

    @Override
    public SqlDriver loadDriver(File file) {
        if (file == null) {
            return null;
        }
        if (isJarFile(file)) {
            logger.debug("Not a jar file: {}", file.getAbsolutePath());
            return null;
        }
        JarFile jarFile = null;
        try {
            logger.debug("Analyzing lib: {}", file.getAbsoluteFile());
            jarFile = new JarFile(file.getAbsoluteFile());

            URL[] urls = { new URL(String.format(JAR_URL_TEMPLATE, file.getAbsoluteFile())) };
            URLClassLoader classLoader = URLClassLoader.newInstance(urls);

            Enumeration<JarEntry> jarEntrys = jarFile.entries();
            while (jarEntrys.hasMoreElements()) {
                JarEntry jarEntry = (JarEntry) jarEntrys.nextElement();
                if (jarEntry.isDirectory() || !jarEntry.getName().endsWith(".class") || jarEntry.getName().contains("$")) {
                    continue;
                }

                String className = getClassName(jarEntry);

                Class<?> clazz = classLoader.loadClass(className);
                for (Class<?> interf : clazz.getInterfaces()) {
                    if (java.sql.Driver.class.equals(interf)) {
                        Driver driver = (Driver) clazz.newInstance();
                        String version = String.format(DRIVER_VERSION_TEMPLATE, driver.getMajorVersion(), driver.getMinorVersion());
                        logger.debug("Found driver: {} version: {}", className, version);
                        return new SqlDriver(driver, file, version);
                    }
                }
            }
        } catch (IOException e) {
            logger.trace(e.getMessage(), e.getMessage());
        } catch (LinkageError e) {
            logger.trace(e.getMessage(), e.getMessage());
        } catch (ReflectiveOperationException e) {
            logger.trace(e.getMessage(), e.getMessage());
        } finally {
            closeQuietly(jarFile);
        }
        return null;
    }

    // -6 because of .class
    private boolean isJarFile(File file) {
        return file != null && file.getAbsolutePath().toLowerCase().endsWith(".jar");
    }

    private String getClassName(JarEntry jarEntry) {
        String className = jarEntry.getName().substring(0, jarEntry.getName().length() - 6);
        className = className.replace('/', '.');
        return className;
    }

    @Override
    public Collection<SqlDriver> loadDrivers(File dir) {
        Collection<SqlDriver> drivers = new ArrayList<SqlDriver>();
        if (dir == null || !dir.isDirectory() || !dir.exists()) {
            return drivers;
        }
        logger.debug("Loading drivers from: {}", dir);
        for (File file : dir.listFiles()) {
            if (!isJarFile(file)) {
                continue;
            }
            SqlDriver driver = loadDriver(file);
            if (driver != null) {
                drivers.add(driver);
            } else {
                logger.debug("SQL Driver not found: {}", file.getAbsoluteFile());
            }
        }
        return drivers;
    }
}