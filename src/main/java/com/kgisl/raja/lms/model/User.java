package com.kgisl.raja.lms.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class User{
    @Id
    private Long id;
    private String name;

    User(){ }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}