package org.kbss.webdb.api.manager;

import org.kbss.webdb.impl.manager.SqlDriver;

import java.io.File;
import java.util.Collection;

/**
 * 
 * @author Serhii Krivtsov
 *
 */
public interface DriverLoader {

    public SqlDriver loadDriver(File file);

    public Collection<SqlDriver> loadDrivers(File dir);
}
