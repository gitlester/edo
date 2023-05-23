package com.itmy.edo.model.dto;

import lombok.Data;

import java.util.Map;

@Data
public class UniteMetricData {
    private static final long serialVersionUID = 8968059029015805484L;

    private Map tags;

    private Map fields;

    private long timestamp;

    public UniteMetricData(Map tags, Map fields, long timestamp) {

        this.tags = tags;

        this.fields = fields;
        this.timestamp = timestamp;

    }

    public Map getTags() {

        return tags;

    }

    public void setTags(Map tags) {

        this.tags = tags;

    }

    public Map getFields() {

        return fields;

    }

    public void setFields(Map fields) {

        this.fields = fields;

    }

    public long getTimestamp() {

        return timestamp;

    }

    public void setTimestamp(long timestamp) {

        this.timestamp = timestamp;

    }
}
