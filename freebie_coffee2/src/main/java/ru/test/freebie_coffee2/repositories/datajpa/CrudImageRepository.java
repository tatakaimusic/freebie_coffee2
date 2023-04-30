package ru.test.freebie_coffee2.repositories.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.test.freebie_coffee2.models.Image;

public interface CrudImageRepository extends JpaRepository<Image, Integer> {

}
