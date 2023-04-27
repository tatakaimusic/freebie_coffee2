package ru.test.freebie_coffee2.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.test.freebie_coffee2.models.Person;
import ru.test.freebie_coffee2.services.PeopleDetailsService;

@Component
public class PersonValidator implements Validator {
    private final PeopleDetailsService peopleDetailsService;

    @Autowired
    public PersonValidator(PeopleDetailsService peopleDetailsService) {
        this.peopleDetailsService = peopleDetailsService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = peopleDetailsService.loadUserByEmail(((Person) o).getEmail()).orElse(null);
        if(person.isNew()){
            return;
        }

        errors.rejectValue("email", "", "Человек с такой почтой уже существует");

    }
}
