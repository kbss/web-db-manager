package org.juke.webdb.api.manager;

import org.juke.webdb.dto.ConnectionDto;
import org.juke.webdb.dto.ConnectionInfoDto;
import org.juke.webdb.dto.QueryDto;
import org.juke.webdb.dto.QueryResultDto;

/**
 * 
 * @author Serhii Krivtsov
 *
 */
public interface ManagerService {
    ConnectionInfoDto connect(ConnectionDto connection);

    QueryResultDto execute(QueryDto query);
}
