package ru.test.freebie_coffee2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.test.freebie_coffee2.models.Person;
import ru.test.freebie_coffee2.repositories.PersonRepository;
import ru.test.freebie_coffee2.util.ValidationUtil;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PersonService(PersonRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public Person create(Person person) {
        Assert.notNull(person, "user must be not null");
        return repository.save(person);
    }

    public void update(Person person) {
        Assert.notNull(person, "user must be not null");
        String password = passwordEncoder.encode(person.getPassword());
        person.setPassword(password);
        ValidationUtil.checkNotFoundWithId(repository.save(person), person.getId());
    }

    public void delete(int id) {
        ValidationUtil.checkNotFoundWithId(repository.delete(id), id);
    }

    public Person get(int id) {
        return ValidationUtil.checkNotFoundWithId(repository.get(id), id);
    }

    public List<Person> getAll() {
        return repository.getAll();
    }
}
