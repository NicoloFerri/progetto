package com.example.CineRecensore.repository;

import com.example.CineRecensore.entity.Recensione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecensioneRepository extends JpaRepository<Recensione, Long> {
    @Query("SELECT r FROM Recensione r WHERE r.film.id = :id")
    List<Recensione> findRecensioneByIdFilm(@Param("id") Long id);

}
