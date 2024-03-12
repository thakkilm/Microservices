package com.Mahesh.microservices.restfulwebservices.filter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class FilterController {

    @GetMapping("/filtering")
    public Filter getSomeFields(){
        return new Filter("field1","filed2","filed3");
    }

    @GetMapping("/filtering-list")
    public List<Filter> getSomeFieldsList(){
//        ArrayList<Filter> al=new ArrayList<>();
       return Arrays.asList(new Filter("A", "B", "C"), new Filter("D", "E", "F"));
    }
}
