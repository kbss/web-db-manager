package org.juke.webdb.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Serhii Krivtsov
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ConnectionInfoDto {

    private ConnectionDto connection;
    private Collection<TableDto> tables;
    private String token;

    public Collection<TableDto> getTables() {
        if (tables == null) {
            tables = new ArrayList<TableDto>();
        }
        return tables;
    }

    public ConnectionDto getConnection() {
        return connection;
    }

    public String getToken() {
        return token;
    }

    public void setConnection(ConnectionDto connection) {
        this.connection = connection;
    }

    public void setToken(String token) {
        this.token = token;
    }
}