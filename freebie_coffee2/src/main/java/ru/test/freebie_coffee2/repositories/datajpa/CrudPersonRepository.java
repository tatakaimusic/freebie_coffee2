package ru.test.freebie_coffee2.repositories.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.test.freebie_coffee2.models.Person;

@Transactional(readOnly = true)
public interface CrudPersonRepository extends JpaRepository<Person, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Person p WHERE p.id=:id")
    int delete(@Param("id") int id);
}
