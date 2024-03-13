package com.Mahesh.microservices.restfulwebservices.filter;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties( "field3")
@JsonFilter("someBeanFilter")
public class Filter {

//    @JsonIgnore
    private String field1;
    private String field2;
    private String field3;
    public Filter(String field1, String filed2, String filed3) {
        this.field1=field1;
        this.field2=filed2;
        this.field3=filed3;
    }
    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }

    public String getField3() {
        return field3;
    }

    @Override
    public String toString() {
        return "Filter{" +
                "field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", field3='" + field3 + '\'' +
                '}';
    }
}
