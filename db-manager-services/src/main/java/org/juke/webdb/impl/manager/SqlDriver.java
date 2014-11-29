package org.juke.webdb.impl.manager;

import java.io.File;
import java.sql.Driver;

/**
 * 
 * @author Serhii Krivtsov
 *
 */
public class SqlDriver {

    private Driver driver;
    private File jarFile;
    private String version;

    public SqlDriver(Driver driver, File jarFile, String version) {
        this.driver = driver;
        this.jarFile = jarFile;
        this.version = version;
    }

    public Driver getDriver() {
        return driver;
    }

    public File getJarFile() {
        return jarFile;
    }

    public String getVersion() {
        return version;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setJarFile(File jarFile) {
        this.jarFile = jarFile;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
