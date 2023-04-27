package ru.test.freebie_coffee2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.test.freebie_coffee2.models.Person;
import ru.test.freebie_coffee2.repositories.PersonRepository;

@Service
public class RegistrationService {
    private final PersonRepository repository;

    @Autowired
    public RegistrationService(PersonRepository repository) {
        this.repository = repository;
    }

    public Person registration(Person person) {
        Assert.notNull(person, "user must be not null");
        return repository.save(person);
    }
}
