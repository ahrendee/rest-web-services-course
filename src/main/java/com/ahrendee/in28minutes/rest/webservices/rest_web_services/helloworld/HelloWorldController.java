package com.ahrendee.in28minutes.rest.webservices.rest_web_services.helloworld;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/helloworld")
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping(path = "/helloworld-bean")
    public HelloWorldBean sayHelloBean() {
        return new HelloWorldBean("Hello from the bean!");
    }

    @GetMapping(path = "/helloworld-bean/path/{name}")
    public HelloWorldBean sayHelloBeanPath(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello from the bean, %s!!", StringUtils.capitalize(name)));
    }
}