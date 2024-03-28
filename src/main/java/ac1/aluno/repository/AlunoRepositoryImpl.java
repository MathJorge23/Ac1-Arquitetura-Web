package ac1.aluno.repository;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

import ac1.aluno.model.Aluno;


@Repository
public class AlunoRepositoryImpl implements AlunoRepository{
    private final List<Aluno> alunos = new ArrayList<>();
    private Long nextId = 1L;

    public AlunoRepositoryImpl() {
        // Inicialização da lista de alunos
        alunos.add(new Aluno(1L, "Matheus", "gmail", "ads", "23/04/1995"));
        alunos.add(new Aluno(2L, "Joao", "gmail", "ads", "23/04/1995"));
        alunos.add(new Aluno(3L, "Nicolas", "gmail", "ads", "23/04/1995"));
        alunos.add(new Aluno(4L, "Guilherme", "gmail", "ads", "23/04/1995"));
        nextId =4L;
    }

    @Override
    public List<Aluno> findAll() {
        return alunos;
    }
    
    @Override
    public Aluno findById(Long id) {
        return alunos.stream()
                .filter(alunos -> alunos.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Aluno save(Aluno aluno) {
        if (aluno.getId() == null) {
            aluno.setId(nextId++);
            alunos.add(aluno);
        } else {
            alunos.removeIf(t -> t.getId().equals(aluno.getId()));
            alunos.add(aluno);
        }
        return aluno;
    }

    @Override
    public void delete(Long id) {
        int a = (int) (id -1 );
        alunos.remove(a);
    }

    @Override
    public Aluno update(Aluno aluno, Long id) {
        for (Aluno a : alunos) {
            if (a.getId().equals(id)) {
                a.setNome(aluno.getNome());
                a.setEmail(aluno.getEmail());
                a.setDataNascimento(aluno.getDataNascimento());
                a.setCurso(aluno.getCurso());
                return a;
            }
        }
        return null;
    }

    

    

   
}
