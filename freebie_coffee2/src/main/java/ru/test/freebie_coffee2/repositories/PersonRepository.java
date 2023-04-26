package ru.test.freebie_coffee2.repositories;


import ru.test.freebie_coffee2.models.Person;

import java.util.List;

public interface PersonRepository {
    Person save(Person person);

    boolean delete(int id);

    Person get(int id);

    List<Person> getAll();
}
