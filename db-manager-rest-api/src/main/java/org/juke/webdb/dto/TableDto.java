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
public class TableDto {

    private Collection<ColumnDto> columns;

    private String name;
    private String category;
    private String schema;
    public String getCategory() {
        return category;
    }

    public Collection<ColumnDto> getColumns() {
        if (columns == null) {
            columns = new ArrayList<ColumnDto>();
        }
        return columns;
    }

    public String getName() {
        return name;
    }

    public String getSchema() {
        return schema;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setColumns(Collection<ColumnDto> columns) {
        this.columns = columns;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    @Override
    public String toString() {
        return "TableDto [columns=" + columns + ", name=" + name + ", category=" + category + ", schema=" + schema + "]";
    }
}