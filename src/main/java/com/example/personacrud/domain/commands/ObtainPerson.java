package com.example.personacrud.domain.commands;

import co.com.sofka.domain.generic.Command;
import com.example.personacrud.domain.values.PersonId;

public class ObtainPerson implements Command {
    private final PersonId personId;

    public ObtainPerson(PersonId personId) {
        this.personId = personId;
    }

    public PersonId personId() {
        return personId;
    }
}
