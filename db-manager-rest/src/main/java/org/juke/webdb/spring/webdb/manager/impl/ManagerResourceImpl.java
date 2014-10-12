package org.juke.webdb.spring.webdb.manager.impl;

import org.juke.webdb.api.manager.ManagerService;
import org.juke.webdb.dto.ConnectionDto;
import org.juke.webdb.dto.ConnectionInfoDto;
import org.juke.webdb.dto.QueryDto;
import org.juke.webdb.dto.QueryResultDto;
import org.juke.webdb.resources.ManagerResource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author Serhii Krivtsov
 *
 */
public class ManagerResourceImpl implements ManagerResource {

    @Autowired
    private ManagerService managerService;

    @Override
    public ConnectionInfoDto connect(ConnectionDto connection) {
        return managerService.connect(connection);
    }

    @Override
    public QueryResultDto execute(QueryDto query) {
        return managerService.execute(query);
    }

}
