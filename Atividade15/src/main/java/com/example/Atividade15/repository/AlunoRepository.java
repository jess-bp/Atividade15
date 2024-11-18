package com.example.Atividade15.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Atividade15.model.Aluno;
import com.example.Atividade15.service.AlunoCursoService;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{

	

}
