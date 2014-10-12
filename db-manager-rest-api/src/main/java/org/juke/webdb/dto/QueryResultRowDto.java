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
@XmlRootElement(name = "SqlQueryDto")
@XmlAccessorType(XmlAccessType.FIELD)
public class QueryResultRowDto {

    private Collection<String> cells;

    public Collection<String> getCells() {
        if (cells == null) {
            cells = new ArrayList<String>();
        }
        return cells;
    }

}
