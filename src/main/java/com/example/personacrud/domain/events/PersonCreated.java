package com.example.personacrud.domain.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.personacrud.domain.values.IsProfessional;
import com.example.personacrud.domain.values.Name;
import com.example.personacrud.domain.values.PersonId;
import com.example.personacrud.domain.values.Phone;

public class PersonCreated extends DomainEvent {
    private final PersonId personId;
    private final Name name;
    private final Phone phone;
    private final IsProfessional isProfessional;

    public PersonCreated(PersonId personId, Name name, Phone phone, IsProfessional isProfessional) {
        super("person.created");
        this.personId = personId;
        this.name = name;
        this.phone = phone;
        this.isProfessional = isProfessional;
    }

    public Name name() {
        return name;
    }

    public Phone phone() {
        return phone;
    }

    public IsProfessional isProfessional() {
        return isProfessional;
    }

    public PersonId personId() {
        return personId;
    }
}
