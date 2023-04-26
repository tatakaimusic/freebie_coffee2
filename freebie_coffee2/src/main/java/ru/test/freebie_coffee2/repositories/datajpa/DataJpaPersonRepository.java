package ru.test.freebie_coffee2.repositories.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.test.freebie_coffee2.models.Person;
import ru.test.freebie_coffee2.repositories.PersonRepository;

import java.util.List;

@Repository
public class DataJpaPersonRepository implements PersonRepository {
    private static final Sort SORT_NAME_EMAIL = Sort.by(Sort.Direction.ASC, "name", "email");

    private final CrudPersonRepository crudPersonRepository;

    @Autowired
    public DataJpaPersonRepository(CrudPersonRepository crudPersonRepository) {
        this.crudPersonRepository = crudPersonRepository;
    }

    @Override
    public Person save(Person person) {
        return crudPersonRepository.save(person);
    }

    @Override
    public boolean delete(int id) {
        return crudPersonRepository.delete(id) != 0;
    }

    @Override
    public Person get(int id) {
        return crudPersonRepository.findById(id).orElse(null);
    }

    @Override
    public List<Person> getAll() {
        return crudPersonRepository.findAll(SORT_NAME_EMAIL);
    }
}
