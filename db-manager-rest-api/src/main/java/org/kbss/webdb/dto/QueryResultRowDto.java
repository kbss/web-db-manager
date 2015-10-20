package org.kbss.webdb.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 
 * @author Serhii Krivtsov
 *
 */
@XmlRootElement
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
