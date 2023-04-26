package ru.test.freebie_coffee2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.test.freebie_coffee2.models.Person;
import ru.test.freebie_coffee2.repositories.PersonRepository;
import ru.test.freebie_coffee2.repositories.datajpa.CrudPersonRepository;
import ru.test.freebie_coffee2.security.PersonDetails;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {
    private final CrudPersonRepository repository;

    @Autowired
    public PersonDetailsService(CrudPersonRepository repository) {
        this.repository = repository;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Person> person = repository.findByEmail(s);
        if (person.isEmpty()) {
            throw new UsernameNotFoundException("User not found!");
        }
        return new PersonDetails(person.get());
    }
}
