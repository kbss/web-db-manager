package org.kbss.webdb.api.manager;

import org.kbss.webdb.dto.ConnectionDto;
import org.kbss.webdb.dto.ConnectionInfoDto;
import org.kbss.webdb.dto.QueryDto;
import org.kbss.webdb.dto.QueryResultDto;

/**
 * 
 * @author Serhii Krivtsov
 *
 */
public interface ManagerService {
    ConnectionInfoDto connect(ConnectionDto connection);

    ConnectionInfoDto connect(String connectionId);

    void deleteConnection(String connectionId);

    QueryResultDto execute(QueryDto query);

    void saveConnection(ConnectionDto connection);
}
