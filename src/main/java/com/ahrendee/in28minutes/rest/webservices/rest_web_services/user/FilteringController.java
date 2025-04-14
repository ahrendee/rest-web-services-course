package com.ahrendee.in28minutes.rest.webservices.rest_web_services.user;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

/*
 * This controller shows how to filter fields from one specific API call object, an keep it in another.
 */

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue filtering() {
        SomeBean bean = new SomeBean("value1", "value2", "value3");

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(bean);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> filteringList() {
        return Arrays.asList(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value4", "value5", "value6"));
    }

    // @GetMapping("/filtering-list")
    // public MappingJacksonValue filteringList() {
    // List<SomeBean> beansList = Arrays.asList(new SomeBean("value1", "value2",
    // "value3"),
    // new SomeBean("value4", "value5", "value6"));

    // MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(beansList);
    // SimpleBeanPropertyFilter filter =
    // SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
    // FilterProvider filters = new
    // SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
    // mappingJacksonValue.setFilters(filters);

    // return mappingJacksonValue;
    // }
}
