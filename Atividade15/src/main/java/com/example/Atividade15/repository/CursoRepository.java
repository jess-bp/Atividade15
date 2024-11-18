package com.example.Atividade15.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Atividade15.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

}
