package org.juke.webdb.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Serhii Krivtsov
 *
 */
@XmlRootElement(name = "TableDto")
@XmlAccessorType(XmlAccessType.FIELD)
public class ColumnDto {

    private Integer length;
    private String name;
    // TODO: enum
    private String type;

    public Integer getLength() {
        return length;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
}
