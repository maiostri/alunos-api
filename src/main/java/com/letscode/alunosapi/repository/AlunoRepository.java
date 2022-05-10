package com.letscode.alunosapi.repository;

import com.letscode.alunosapi.domain.Aluno;
import org.springframework.data.repository.CrudRepository;

public interface AlunoRepository extends CrudRepository<Aluno, Integer> {
}
