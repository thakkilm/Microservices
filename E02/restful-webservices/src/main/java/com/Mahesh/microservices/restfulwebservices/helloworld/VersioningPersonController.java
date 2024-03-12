package com.Mahesh.microservices.restfulwebservices.helloworld;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {


    @GetMapping("/v1")
    public String check(){
        return "Hello Person";
    }

    @GetMapping("/v1/person")
    public Personv1 getV1Person(){
        return new Personv1("Mahesh Thakkilapati");
    }
    @GetMapping("/v2/person")
    public Personv2 getV2Person(){
        return new Personv2(new Name("Mahesh","Thakkilapati"));
    }

    @GetMapping(value = "/person",params = "version=1")
    public Personv1 getV1PersonURI(){
        return new Personv1("Mahesh Thakkilapati");
    }
    @GetMapping(value = "/person", params = "version=2")
    public Personv2 getV2PersonURI(){
        return new Personv2(new Name("Mahesh","Thakkilapati"));
    }


    @GetMapping(value = "/person",headers = "X-API-VERSION=1")
    public Personv1 getV1PersonHeaders(){
        return new Personv1("Mahesh Thakkilapati");
    }
    @GetMapping(value = "/person", headers = "X-API-VERSION=2")
    public Personv2 getV2PersonHeaders(){
        return new Personv2(new Name("Mahesh","Thakkilapati"));
    }
}
