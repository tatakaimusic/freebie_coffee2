package ru.test.freebie_coffee2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.test.freebie_coffee2.models.Person;
import ru.test.freebie_coffee2.repositories.PersonRepository;

@Service
public class RegistrationService {
    private final PersonRepository repository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationService(PersonRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void register(Person person) {
        String encodedPassword = passwordEncoder.encode(person.getPassword());
        person.setPassword(encodedPassword);
        person.setRole("ROLE_USER");
        repository.save(person);
    }
}
