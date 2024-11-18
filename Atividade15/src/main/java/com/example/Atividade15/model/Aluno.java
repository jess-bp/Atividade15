package com.example.Atividade15.model;

import java.util.List;
import java.util.Set;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "alunos")
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long aluno_id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String email;
	
	@ManyToMany
	@JoinTable(
			name = "alunos_cursos",
			joinColumns= @JoinColumn(name = "aluno_id"),
			inverseJoinColumns= @JoinColumn(name = "curso_id")
			)
	private List<Curso> cursos;
	
	public void addCurso(Curso curso) {
        cursos.add(curso);
        curso.getAlunos().add(this);
    }

    public void removeCurso(Curso curso) {
        cursos.remove(curso);
        curso.getAlunos().remove(this);
    }
	
	
	

}
