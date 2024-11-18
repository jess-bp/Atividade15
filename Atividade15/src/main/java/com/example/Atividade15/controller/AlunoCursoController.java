package com.example.Atividade15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Atividade15.dto.AlunoDto;
import com.example.Atividade15.dto.CursoDto;
import com.example.Atividade15.model.Aluno;
import com.example.Atividade15.model.Curso;
import com.example.Atividade15.service.AlunoCursoService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AlunoCursoController {

    @Autowired
    private AlunoCursoService alunoCursoService;

    @PostMapping("/alunos")
    public ResponseEntity<Aluno> criarAluno(@RequestBody Aluno aluno) {
        return ResponseEntity.ok(alunoCursoService.criarAluno(aluno));
    }

    @PostMapping("/cursos")
    public ResponseEntity<Curso> criarCurso(@RequestBody Curso curso) {
        return ResponseEntity.ok(alunoCursoService.criarCurso(curso));
    }

    @PostMapping("/alunos/{id}/cursos/{cursoId}")
    public ResponseEntity<Void> matricularAlunoEmCurso(@PathVariable Long id, @PathVariable Long cursoId) {
        alunoCursoService.matricularAlunoEmCurso(id, cursoId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/alunos/{id}/cursos/{cursoId}")
    public ResponseEntity<Void> removerAlunoDeCurso(@PathVariable Long id, @PathVariable Long cursoId) {
        alunoCursoService.removerAlunoDeCurso(id, cursoId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/alunos/{id}/cursos")
    public ResponseEntity<List<CursoDto>> listarCursosDoAluno(@PathVariable Long id) {
        return ResponseEntity.ok(alunoCursoService.listarCursosDoAluno(id));
    }

    @GetMapping("/cursos/{id}/alunos")
    public ResponseEntity<List<AlunoDto>> listarAlunosDoCurso(@PathVariable Long id) {
        return ResponseEntity.ok(alunoCursoService.listarAlunosDoCurso(id));
    }
}

