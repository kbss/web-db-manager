package org.juke.webdb.dto;

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
public class QueryDto {

    private ConnectionDto connection;
    private String query;
    private String token;

    public ConnectionDto getConnection() {
        return connection;
    }

    public String getQuery() {
        return query;
    }

    public String getToken() {
        return token;
    }

    public void setConnection(ConnectionDto connection) {
        this.connection = connection;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
