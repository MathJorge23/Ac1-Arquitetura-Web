package ac1.aluno.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import ac1.aluno.Aluno;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final List<Aluno> alunos = new ArrayList<>();

    private Long nextId = 1L;

    public AlunoController(){
         alunos.add(new Aluno(1L, "Matheus", "gmail", "ads", "23/04/1995"));
         alunos.add(new Aluno(2L, "Joao", "gmail", "ads", "23/04/1995"));
         alunos.add(new Aluno(3L, "Nicolas", "gmail", "ads", "23/04/1995"));
         alunos.add(new Aluno(4L, "Guilherme", "gmail", "ads", "23/04/1995"));
         nextId =4L;
    }

    

    @PostMapping("/add")
    public Aluno addNewAluno(@RequestBody Aluno aluno) {
        if (aluno.getId() == null) {
            aluno.setId(nextId++);
            alunos.add(aluno);
        } else {
            alunos.removeIf(t -> t.getId().equals(aluno.getId()));
            alunos.add(aluno);
        }
        return aluno;
    }

    @GetMapping()
    public List<Aluno> getAllAlunos() {
        return alunos;
    }


    
    @GetMapping("/{id}")
    public Aluno findById(@PathVariable Long id) {
        Aluno retorno  = alunos.stream()
                .filter(aluno -> aluno.getId().equals(id))
                .findFirst()
                .orElse(null);
    
        return retorno ;
    }

    @PutMapping("/{id}")
    public Aluno updateAluno(@PathVariable Long id, @RequestBody Aluno aluno) {
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

    @DeleteMapping("/{id}")
    public void deleteAluno(@PathVariable Long id) {
        int a = (int) (id -1 );
        alunos.remove(a);
    }
    


    
}
