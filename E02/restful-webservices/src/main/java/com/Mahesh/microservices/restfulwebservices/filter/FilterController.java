package com.Mahesh.microservices.restfulwebservices.filter;

import com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class FilterController {

    @GetMapping("/filtering")
    public MappingJacksonValue getSomeFields(){

        Filter filter = new Filter("field1", "field2", "field3");
        MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(filter);
        SimpleBeanPropertyFilter simpleBeanPropertyFilter=
                SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
       FilterProvider filterProvider=
               new SimpleFilterProvider().addFilter("someBeanFilter", simpleBeanPropertyFilter);
       mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue getSomeFieldsList(){
//        ArrayList<Filter> al=new ArrayList<>();
        List<Filter> list = Arrays.asList(new Filter("A", "B", "C"), new Filter("D", "E", "F"));
        MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(list);
        SimpleBeanPropertyFilter simpleBeanPropertyFilter=
                SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
        FilterProvider filterProvider=
                new SimpleFilterProvider().addFilter("someBeanFilter", simpleBeanPropertyFilter);
        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
//        return list;
    }
}
