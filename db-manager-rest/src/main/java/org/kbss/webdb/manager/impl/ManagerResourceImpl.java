package org.kbss.webdb.manager.impl;

import org.kbss.webdb.api.manager.ManagerService;
import org.kbss.webdb.dto.ConnectionDto;
import org.kbss.webdb.dto.ConnectionInfoDto;
import org.kbss.webdb.dto.QueryDto;
import org.kbss.webdb.dto.QueryResultDto;
import org.kbss.webdb.resources.ManagerResource;

import javax.inject.Inject;

/**
 * 
 * @author Serhii Krivtsov
 *
 */
public class ManagerResourceImpl implements ManagerResource {

    @Inject
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
