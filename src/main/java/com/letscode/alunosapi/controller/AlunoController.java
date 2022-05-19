package com.letscode.alunosapi.controller;

import com.letscode.alunosapi.domain.Aluno;
import com.letscode.alunosapi.repository.AlunoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/aluno")
public class AlunoController {

    private final AlunoRepository alunoRepository;

    public AlunoController(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewAluno(@RequestParam String nome, @RequestParam String email) {
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setEmail(email);
        alunoRepository.save(aluno);
        return "Salvo";
    }

//    @GetMapping(path = "/all")
//    public @ResponseBody
//    Iterable<Aluno> getAllAlunos() {
//        return alunoRepository.findAll();
//    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Aluno> getAluno(@PathVariable String id) {
        Optional<Aluno> aluno = alunoRepository.findById(Integer.valueOf(id));

        if (aluno.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(aluno.get());
    }
}
