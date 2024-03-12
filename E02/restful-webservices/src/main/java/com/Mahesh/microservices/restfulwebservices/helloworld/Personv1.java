package com.Mahesh.microservices.restfulwebservices.helloworld;

public class Personv1 {


    public String getName() {
        return name;
    }

    private String name;
    public Personv1(String name) {
        super();
        this.name=name;
    }
    @Override
    public String toString() {
        return "Personv1{" +
                "name='" + name + '\'' +
                '}';
    }
}
