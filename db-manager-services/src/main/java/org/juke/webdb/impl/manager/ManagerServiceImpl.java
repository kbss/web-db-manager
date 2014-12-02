package org.juke.webdb.impl.manager;

import org.juke.webdb.api.manager.ManagerService;
import org.juke.webdb.dto.ConnectionDto;
import org.juke.webdb.dto.ConnectionInfoDto;
import org.juke.webdb.dto.QueryDto;
import org.juke.webdb.dto.QueryResultDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Serhii Krivtsov
 *
 */
@Service
public class ManagerServiceImpl implements ManagerService {

    private Logger logger = LoggerFactory.getLogger(ManagerServiceImpl.class);

    @Override
    public ConnectionInfoDto connect(ConnectionDto connection) {
        logger.info("Connecting...");
        // TODO Implement
        return null;
    }

    @Override
    public QueryResultDto execute(QueryDto query) {
        logger.info("Executing query...");
        // TODO Implement
        return null;
    }

    @Override
    public ConnectionInfoDto connect(String connectionId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteConnection(String connectionId) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void saveConnection(ConnectionDto connection) {
        // TODO Auto-generated method stub
        
    }

}
