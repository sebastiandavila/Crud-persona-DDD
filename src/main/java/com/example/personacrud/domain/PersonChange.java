package com.example.personacrud.domain;

import co.com.sofka.domain.generic.EventChange;
import com.example.personacrud.domain.events.PersonCreated;

public class PersonChange extends EventChange {
    public PersonChange(Person person){
        apply((PersonCreated event)->{
            person.name = event.name();
            person.phone = event.phone();
            person.isProfessional = event.isProfessional();
        });
    }
}
