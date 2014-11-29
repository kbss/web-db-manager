package org.juke.webdb.api.manager;

import java.io.File;
import java.util.Collection;

import org.juke.webdb.impl.manager.SqlDriver;

/**
 * 
 * @author Serhii Krivtsov
 *
 */
public interface DriverLoader {

    public SqlDriver loadDriver(File file);

    public Collection<SqlDriver> loadDrivers(File dir);
}
