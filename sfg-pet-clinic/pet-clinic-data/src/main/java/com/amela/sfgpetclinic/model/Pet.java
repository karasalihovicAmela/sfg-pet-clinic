package com.amela.sfgpetclinic.model;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Pet {

    private PetType petType;

    private Owner owner;

    private LocalDate birthDate;
}
