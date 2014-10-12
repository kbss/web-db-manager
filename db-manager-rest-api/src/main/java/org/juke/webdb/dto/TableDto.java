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
@XmlRootElement(name = "TableDto")
@XmlAccessorType(XmlAccessType.FIELD)
public class TableDto {

    private Collection<ColumnDto> columns;

    private String name;

    public Collection<ColumnDto> getColumns() {
        if (columns == null) {
            columns = new ArrayList<ColumnDto>();
        }
        return columns;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}