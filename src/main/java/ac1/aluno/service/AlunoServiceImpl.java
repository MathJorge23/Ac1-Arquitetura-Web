package ac1.aluno.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ac1.aluno.model.Aluno;
import ac1.aluno.repository.AlunoRepository;

@Service
public class AlunoServiceImpl  implements AlunoService{

    private final AlunoRepository alunoRepository ;

    public AlunoServiceImpl (AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }

    @Override
    public List<Aluno> getAllAlunos() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno getAlunoById(Long id) {
        return alunoRepository.findById(id);
    }

    @Override
    public Aluno CreateAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Override
    public void deleteById(Long id) {
         alunoRepository.delete(id);
    }

    @Override
    public Aluno updateAluno(Aluno aluno, Long id) {
        return alunoRepository.update(aluno, id);
    }  
    
}
