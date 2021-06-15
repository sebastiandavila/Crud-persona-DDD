package com.example.personacrud.domain.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.personacrud.domain.values.IsProfessional;
import com.example.personacrud.domain.values.Name;
import com.example.personacrud.domain.values.PersonId;
import com.example.personacrud.domain.values.Phone;

public class PersonObtained extends DomainEvent {
    private final PersonId personId;
    private final Name name;
    private final Phone phone;
    private final IsProfessional isProfessional;

    public PersonObtained(PersonId personId, Name name, Phone phone, IsProfessional isProfessional) {
        super("person.obtained");
        this.personId = personId;
        this.name = name;
        this.phone = phone;
        this.isProfessional = isProfessional;
    }

    public PersonId getPersonId() {
        return personId;
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public IsProfessional getIsProfessional() {
        return isProfessional;
    }
}
