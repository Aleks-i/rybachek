package com.aleksi.repository.clothes;

import com.aleksi.model.product.clothes.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface CrudClothesRepository extends JpaRepository<Clothes, Integer> {
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Clothes c WHERE c.id=:id")
    int delete(@Param("id") int id);
}