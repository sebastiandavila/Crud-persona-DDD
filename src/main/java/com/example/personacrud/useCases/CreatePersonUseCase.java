package com.example.personacrud.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.example.personacrud.domain.Person;
import com.example.personacrud.domain.commands.CreatePerson;
import com.example.personacrud.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatePersonUseCase extends UseCase<RequestCommand<CreatePerson>, ResponseEvents> {

    @Autowired
    private IPersonRepository iPersonRepository;

    @Override
    public void executeUseCase(RequestCommand<CreatePerson> createPersonRequestCommand) {
        var command = createPersonRequestCommand.getCommand();
        var person = new Person(command.personId(),command.name(), command.phone(), command.isProfessional());
        iPersonRepository.save(person);
        emit().onResponse(new ResponseEvents(person.getUncommittedChanges()));
    }
}
