package com.example.Atividade15.utils;

import com.example.Atividade15.dto.AlunoDto;
import com.example.Atividade15.dto.CursoDto;
import com.example.Atividade15.model.Aluno;
import com.example.Atividade15.model.Curso;

public class DtoConverter {
	
	public static AlunoDto toAlunoDto(Aluno aluno) {
		AlunoDto alunoDto = new AlunoDto();
		
		alunoDto.setAluno_id(aluno.getAluno_id());
		alunoDto.setNome(aluno.getNome());
		alunoDto.setEmail(aluno.getEmail());
		return alunoDto;
	}
	
	public static CursoDto toCursoDto(Curso curso) {
		CursoDto cursoDto = new CursoDto();
		
		cursoDto.setCurso_id(curso.getCurso_id());
		cursoDto.setNome(curso.getNome());
		cursoDto.setDescricao(curso.getDescricao());
		
		return cursoDto;
	}

}
