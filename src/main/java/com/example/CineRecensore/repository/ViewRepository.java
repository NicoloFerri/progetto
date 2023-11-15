package com.example.CineRecensore.repository;

import com.example.CineRecensore.entity.View;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ViewRepository extends JpaRepository<View,Long> {


    @Query("SELECT v FROM View v WHERE v.data = :date")
    List<View> printDaysView(@Param("date") LocalDate date);



}
