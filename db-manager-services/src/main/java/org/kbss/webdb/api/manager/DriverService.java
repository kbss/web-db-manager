package org.kbss.webdb.api.manager;

import org.kbss.webdb.dto.DriverInfoDto;

import java.util.Collection;

/**
 * 
 * @author Serhii Krivtsov
 *
 */
public interface DriverService {

    Collection<DriverInfoDto> getDrivers();
    
    DriverInfoDto getDrver(String driverId);
}
