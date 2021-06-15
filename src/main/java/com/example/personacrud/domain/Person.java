package com.example.personacrud.domain;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.example.personacrud.domain.events.PersonCreated;
import com.example.personacrud.domain.values.IsProfessional;
import com.example.personacrud.domain.values.Name;
import com.example.personacrud.domain.values.PersonId;
import com.example.personacrud.domain.values.Phone;
import com.example.personacrud.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Person")
public class Person extends AggregateEvent<PersonId> {
    protected Name name;
    protected Phone phone;
    protected IsProfessional isProfessional;

    @Autowired
    private IPersonRepository iPersonRepository;

    public Person(PersonId entityId) {
        super(entityId);
        subscribe(new PersonChange(this));
    }

    public Person(PersonId entityId, Name name, Phone phone, IsProfessional isProfessional) {
        super(entityId);
        this.name = name;
        this.phone = phone;
        this.isProfessional = isProfessional;

        appendChange(new PersonCreated(entityId, name, phone, isProfessional)).apply();
    }
    public static Person from(PersonId personId, List<DomainEvent> events){
        var person = new Person(personId);

        events.forEach(person::applyEvent);
        return person;
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
