package com.example.personacrud.controller;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.example.personacrud.domain.Person;
import com.example.personacrud.domain.commands.CreatePerson;
import com.example.personacrud.domain.events.PersonCreated;
import com.example.personacrud.domain.values.IsProfessional;
import com.example.personacrud.domain.values.Name;
import com.example.personacrud.domain.values.PersonId;
import com.example.personacrud.domain.values.Phone;
import com.example.personacrud.repository.IPersonRepository;
import com.example.personacrud.useCases.CreatePersonUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PersonController {

    @Autowired
    private CreatePersonUseCase usecase;

    @PostMapping(value = "api/{id}/{name}/{phone}/{professional}")
    public void save(@PathVariable("id")String id,
                     @PathVariable("name")String name,
                     @PathVariable("phone")String phone,
                     @PathVariable("professional")Boolean professional){
        var command = new CreatePerson(PersonId.of(id), new Name(name), new Phone(phone), new IsProfessional(professional));
        PersonCreated personCreated = executedUseCase(command);

    }

    private PersonCreated executedUseCase(CreatePerson command){
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var PersonCreated = (PersonCreated) events.get(0);
        return PersonCreated;
    }
}
