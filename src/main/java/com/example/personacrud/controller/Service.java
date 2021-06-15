package com.example.personacrud.controller;

import com.example.personacrud.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private IPersonRepository personRepository;


}
