package ru.test.freebie_coffee2.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.test.freebie_coffee2.models.Person;
import ru.test.freebie_coffee2.services.PersonDetailsService;

@Component
public class PersonValidator implements Validator {
    private final PersonDetailsService service;

    @Autowired
    public PersonValidator(PersonDetailsService service) {
        this.service = service;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;
        try {
            service.loadUserByUsername(person.getEmail());
        } catch (UsernameNotFoundException ignored) {
            return;
        }
        errors.rejectValue("username", "", "Person with this name is already exist");
    }
}
