package ru.test.freebie_coffee2.services;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.test.freebie_coffee2.PersonTestData;
import ru.test.freebie_coffee2.models.Person;
import ru.test.freebie_coffee2.util.exception.NotFoundException;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(scripts = "classpath:db/populate_db.sql", config = @SqlConfig(encoding = "UTF-8"))
class PersonServiceTest {
    @Autowired
    protected PersonService personService;

    @Autowired
    protected RegistrationService registrationService;

    @Test
    void update() {
        Person updated = PersonTestData.getUpdated();
        personService.update(updated);
        PersonTestData.USER_MATCHER.assertMatch(personService.get(PersonTestData.ADMIN_iD), PersonTestData.getUpdated());
    }

    @Test
    void register() {
        Person created = registrationService.register(PersonTestData.getNew());
        int newId = created.getId();
        Person newPerson = PersonTestData.getNew();
        newPerson.setId(newId);
        newPerson.setRole("ROLE_USER");
        PersonTestData.USER_MATCHER.assertMatch(personService.get(newId), newPerson);
    }

    @Test
    void registerExist() {
        Assert.assertThrows(DataAccessException.class, () -> registrationService.register(
                new Person(null, "duplicate", "nikitamasslennikov@mail.ru", "asdfg")));
    }

    @Test
    void delete() {
        personService.delete(PersonTestData.ADMIN_iD);
        Assert.assertThrows(NotFoundException.class, () -> personService.get(PersonTestData.ADMIN_iD));
    }

    @Test
    void deleteNotFound() {
        Assert.assertThrows(NotFoundException.class, () -> personService.delete(PersonTestData.NOT_FOUND));
    }

    @Test
    void getNotFound() {
        Assert.assertThrows(NotFoundException.class, () -> personService.get(PersonTestData.NOT_FOUND));
    }

    @Test
    void get() {
        Person person = personService.get(PersonTestData.ADMIN_iD);
        PersonTestData.USER_MATCHER.assertMatch(person, PersonTestData.ADMIN);
    }

    @Test
    void getAll() {
        List<Person> all = personService.getAll();
        PersonTestData.USER_MATCHER.assertMatch(all, PersonTestData.allPerson);
    }
}