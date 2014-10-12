package org.juke.webdb.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Serhii Krivtsov
 *
 */
@XmlRootElement(name = "SqlQueryDto")
@XmlAccessorType(XmlAccessType.FIELD)
public class ErrorDto {
    private String errorCode;
    private String message;

    public ErrorDto() {
        // DO NOTHING
    }

    public ErrorDto(String message, String errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
