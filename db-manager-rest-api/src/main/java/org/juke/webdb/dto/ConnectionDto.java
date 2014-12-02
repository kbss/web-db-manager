package org.juke.webdb.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Serhii Krivtsov
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ConnectionDto {
    @XmlElementRef(required = false)
    private String dbName;
    
    @XmlElementRef(required = false)
    private String driverId;
    
    @XmlElementRef(required = false)
    private String password;
    
    @XmlElementRef(required = false)
    private String sid;
    
    @XmlElementRef(required = true)
    private String url;
    
    @XmlElementRef(required = false)
    private String userName;
    
    public String getDbName() {
        return dbName;
    }
    public String getDriverId() {
        return driverId;
    }

    public String getPassword() {
        return password;
    }

    public String getSid() {
        return sid;
    }

    public String getUrl() {
        return url;
    }

    public String getUserName() {
        return userName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
