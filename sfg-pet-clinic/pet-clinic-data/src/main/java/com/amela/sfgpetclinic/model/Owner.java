package com.amela.sfgpetclinic.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Owner extends Person {

    private String adress;

    private String city;

    private String telephone;

    private Set<Pet> pets = new HashSet<>();

}
