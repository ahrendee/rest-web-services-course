package com.ahrendee.in28minutes.rest.webservices.rest_web_services.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping(path = "/helloworld")
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping(path = "/helloworld-i18n")
    public String sayHelloi18n() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
        // return "Hello World V2";
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