package com.abdullahhegazy.rest.webservices.restful_web_services.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBean filtering() {

	  return new SomeBean("value1", "value2", "value3");
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> filteringList() {

	  return Arrays.asList(new SomeBean("value1", "value2", "value3"), new SomeBean("value3", "value4", "value5"));
    }

    //filter field1
    @GetMapping("/filtering-mappingJacksonValue")
    public MappingJacksonValue filteringMjv() {
	  SomeBean someBean = new SomeBean("value1", "value2", "value3");
	  MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
	  mappingJacksonValue.setFilters(getFilters("SomeBeanFilter", "field1", "field3"));
	  return mappingJacksonValue;
    }

    private FilterProvider getFilters(String filterName, String... propertyArray) {
	  SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(
				propertyArray);
	  FilterProvider filters = new SimpleFilterProvider().addFilter(filterName, filter);
	  return filters;
    }

  //filter field1
    @GetMapping("/filtering-list-mappingJacksonValue")
    public MappingJacksonValue filteringListMjv() {
	  List<SomeBean> list = Arrays.asList(new SomeBean("value1", "value2", "value3")
				, new SomeBean("value3", "value4", "value5"));
	  MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
	  mappingJacksonValue.setFilters(getFilters("SomeBeanFilter", "field2", "field3"));
	  return mappingJacksonValue;
    }
}
