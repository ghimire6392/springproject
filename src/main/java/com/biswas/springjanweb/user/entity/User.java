package com.biswas.springjanweb.user.entity;

import com.biswas.springjanweb.common.enums.Occupation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int usArrivalYear;
    private String email;
    private String address;
    private Occupation occupation;
    private String password;

}
