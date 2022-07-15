package com.aleksi.repository.boat;

import com.aleksi.model.product.boat.Boat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface CrudBoatRepository extends JpaRepository<Boat, Integer> {
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Boat b WHERE b.id=:id")
    int delete(@Param("id") int id);
}