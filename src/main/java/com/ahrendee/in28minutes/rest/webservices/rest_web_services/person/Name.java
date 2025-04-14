package com.ahrendee.in28minutes.rest.webservices.rest_web_services.person;

import lombok.Getter;

@Getter
public class Name {

    private String firstName;
    private String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
