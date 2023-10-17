package com.example.CineRecensore.repository;

import com.example.CineRecensore.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    @Query("SELECT f FROM Film f WHERE f.titolo LIKE %:partialTitle%")
    List<Film> findFilmByPartialTitolo(@Param("partialTitle") String partialTitle);
}
