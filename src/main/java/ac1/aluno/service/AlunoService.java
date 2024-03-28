package ac1.aluno.service;

import java.util.List;

import ac1.aluno.model.Aluno;



public interface AlunoService {
    List<Aluno> getAllAlunos();
    Aluno getAlunoById(Long id);
    Aluno CreateAluno(Aluno aluno);
    void deleteById(Long id);
    Aluno updateAluno (Aluno aluno, Long id);
}
