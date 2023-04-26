package ru.test.freebie_coffee2.repositories.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.test.freebie_coffee2.models.Product;

@Transactional(readOnly = true)
public interface CrudProductRepository extends JpaRepository<Product, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Product p WHERE p.id=:id")
    int delete(@Param("id") int id);
}
