package org.juke.webdb.api.manager;

import java.util.Collection;

import org.juke.webdb.dto.DriverInfoDto;

/**
 * 
 * @author Serhii Krivtsov
 *
 */
public interface DriverService {

    Collection<DriverInfoDto> getDrivers();
    
    DriverInfoDto getDrver(String driverId);
}
