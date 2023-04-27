package ru.test.freebie_coffee2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.test.freebie_coffee2.models.Person;
import ru.test.freebie_coffee2.repositories.datajpa.CrudPersonRepository;
import ru.test.freebie_coffee2.security.PersonDetails;

import java.util.Optional;

@Service
public class PeopleDetailsService {
    private final CrudPersonRepository repository;

    @Autowired
    public PeopleDetailsService(CrudPersonRepository repository) {
        this.repository = repository;
    }

    public Optional<Person> loadUserByEmail(String email) {
        return repository.findByEmail(email);
    }
}
