package com.ahrendee.in28minutes.rest.webservices.rest_web_services.user;

import com.fasterxml.jackson.annotation.JsonFilter;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
// @JsonIgnoreProperties({ "field1", "field3" })
@JsonFilter("SomeBeanFilter")
public class SomeBean {

    private static final long serialVersionUID = 1L;

    private String field1;

    // @JsonIgnore
    private String field2;

    private String field3;

    public SomeBean(String field1, String field2, String field3) {
        super();
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }
}
