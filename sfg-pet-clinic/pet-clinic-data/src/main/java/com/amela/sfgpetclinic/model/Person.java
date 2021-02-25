package com.amela.sfgpetclinic.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person extends BaseEntity{

    private String firstName;

    private String lastName;
}
