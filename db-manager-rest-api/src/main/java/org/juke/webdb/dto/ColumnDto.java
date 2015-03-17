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
public class ColumnDto {

    private Integer columnSize;
    private String name;
    // TODO: enum
    private String type;

    public Integer getColumnSize() {
        return columnSize;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setColumnSize(Integer columnSize) {
        this.columnSize = columnSize;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ColumnDto [columnSize=" + columnSize + ", name=" + name + ", type=" + type + "]";
    }
}
