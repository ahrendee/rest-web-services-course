package com.ahrendee.in28minutes.rest.webservices.rest_web_services.person;

import lombok.Getter;

@Getter
public class PersonV2 {

    private Name name;

    public PersonV2(String firstName, String lastName) {
        name = new Name(firstName, lastName);
    }
}
