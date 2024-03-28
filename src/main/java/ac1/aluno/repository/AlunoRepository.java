package ac1.aluno.repository;

import java.util.List;

import ac1.aluno.model.Aluno;

public interface AlunoRepository {
    List<Aluno> findAll();
    Aluno findById(Long id);
    Aluno save(Aluno aluno);
    void delete(Long id);
    Aluno update (Aluno aluno, Long id);
}
