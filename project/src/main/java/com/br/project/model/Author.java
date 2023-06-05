package com.br.project.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Author {
    private String name;
    public Author(){

    }
    public Author(String name){
        this.name = name;
    }

}
