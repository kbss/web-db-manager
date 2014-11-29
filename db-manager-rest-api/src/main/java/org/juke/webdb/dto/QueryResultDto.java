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
public class QueryResultDto {

    private String message;
    private QueryResultRowDto titles;

    private Collection<QueryResultRowDto> values;

    public String getMessage() {
        return message;
    }

    public QueryResultRowDto getTitles() {
        return titles;
    }

    public Collection<QueryResultRowDto> getValues() {
        if (values == null) {
            values = new ArrayList<QueryResultRowDto>();
        }
        return values;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTitles(QueryResultRowDto titles) {
        this.titles = titles;
    }
}
