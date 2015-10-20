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
public class QueryResultDto {

    private String message;
    private QueryResultRowDto titles;

    private Collection<QueryResultRowDto> values;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public QueryResultRowDto getTitles() {
        return titles;
    }

    public void setTitles(QueryResultRowDto titles) {
        this.titles = titles;
    }

    public Collection<QueryResultRowDto> getValues() {
        if (values == null) {
            values = new ArrayList<QueryResultRowDto>();
        }
        return values;
    }
}
