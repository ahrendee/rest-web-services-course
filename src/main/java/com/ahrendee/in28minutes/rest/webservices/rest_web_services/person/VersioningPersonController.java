package com.ahrendee.in28minutes.rest.webservices.rest_web_services.person;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    // URI Versioning
    @GetMapping("/v1/person")
    public Person getPersonV1() {
        return new Person("Ronald Pieterse");
    }

    @GetMapping("/v2/person")
    public PersonV2 getPersonV2() {
        return new PersonV2("Ronald", "Pieterse");
    }

    // Request Parameter Versioning
    @GetMapping(path = "/person", params = "version=1")
    public Person getPersonParamV1() {
        return getPersonV1();
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getPersonParamV2() {
        return getPersonV2();
    }

    // Custom Header Versioning
    @GetMapping(path = "/person", headers = "X-API-VERSION=1")
    public Person getPersonHeaderV1() {
        return getPersonV1();
    }

    @GetMapping(path = "/person", headers = "X-API-VERSION=2")
    public PersonV2 getPersonHeaderV2() {
        return getPersonV2();
    }

    // Accept Header Versioning
    @GetMapping(path = "/person", produces = "application/api.ahrendee.app-v1+json")
    public Person getPersonAcceptHeaderV1() {
        return getPersonV1();
    }

    @GetMapping(path = "/person", produces = "application/api.ahrendee.app-v2+xml")
    public PersonV2 getPersonAcceptHeaderV2() {
        return getPersonV2();
    }
}
