package com.example.Atividade15.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AlunoDto {

	private Long aluno_id;
	
	private String nome;
	
	private String email;
}
