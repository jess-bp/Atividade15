package com.example.Atividade15.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Atividade15.dto.AlunoDto;
import com.example.Atividade15.dto.CursoDto;
import com.example.Atividade15.model.Aluno;
import com.example.Atividade15.model.Curso;
import com.example.Atividade15.repository.AlunoRepository;
import com.example.Atividade15.repository.CursoRepository;
import com.example.Atividade15.utils.DtoConverter;

import jakarta.transaction.Transactional;

@Service
public class AlunoCursoService {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	@Autowired
	CursoRepository cursoRepository;
	
	public Aluno criarAluno(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	public Curso criarCurso(Curso curso) {
		return cursoRepository.save(curso);
	}
	
	@Transactional
    public void matricularAlunoEmCurso(Long alunoId, Long cursoId) {
        Optional<Aluno> alunoOpt = alunoRepository.findById(alunoId);
        Optional<Curso> cursoOpt = cursoRepository.findById(cursoId);
        if (alunoOpt.isPresent() && cursoOpt.isPresent()) {
            Aluno aluno = alunoOpt.get();
            Curso curso = cursoOpt.get();
            aluno.addCurso(curso);
            alunoRepository.save(aluno);
        }
    }

    @Transactional
    public void removerAlunoDeCurso(Long alunoId, Long cursoId) {
        Optional<Aluno> alunoOpt = alunoRepository.findById(alunoId);
        Optional<Curso> cursoOpt = cursoRepository.findById(cursoId);
        if (alunoOpt.isPresent() && cursoOpt.isPresent()) {
            Aluno aluno = alunoOpt.get();
            Curso curso = cursoOpt.get();
            aluno.removeCurso(curso);
            alunoRepository.save(aluno);
        }
    }

    public List<CursoDto> listarCursosDoAluno(Long alunoId) {
        Optional<Aluno> optionalAluno = alunoRepository.findById(alunoId);
        
        if(optionalAluno.isPresent()) {
        	Aluno aluno = optionalAluno.get();
        	List<CursoDto> cursoDtos = aluno.getCursos().stream()
        			.map(curso -> DtoConverter.toCursoDto(curso)).collect(Collectors.toList());
        	return cursoDtos;
        }else {
        	return List.of();
        }
    }

    public List<AlunoDto> listarAlunosDoCurso(Long cursoId) {
    	Optional<Curso> optionalCurso = cursoRepository.findById(cursoId);
        
        if (optionalCurso.isPresent()) {
            Curso curso = optionalCurso.get();
           List<AlunoDto> alunosDtos =  curso.getAlunos().stream()
        		   .map(aluno->DtoConverter.toAlunoDto(aluno)).collect(Collectors.toList()); // Retorna o conjunto de alunos do curso
           return alunosDtos;
        } else {
            return List.of(); // Retorna um conjunto vazio se o curso não existir
        }
    }

}
