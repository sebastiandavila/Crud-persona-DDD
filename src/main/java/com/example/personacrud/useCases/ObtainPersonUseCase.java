package com.example.personacrud.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.example.personacrud.domain.Person;
import com.example.personacrud.domain.commands.ObtainPerson;

public class ObtainPersonUseCase extends UseCase<RequestCommand<ObtainPerson>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ObtainPerson> obtainPersonRequestCommand) {
        var command = obtainPersonRequestCommand.getCommand();
        //var person = Person.obtainPerson(command.personId());
    }
}
