package ac1.aluno.controller;



import org.springframework.web.bind.annotation.*;
import ac1.aluno.model.Aluno;
import ac1.aluno.service.AlunoService;
import java.util.List;

@RestController
@RequestMapping("/alunos")

public class AlunoControler {
    
    private final AlunoService alunoService;


    public AlunoControler (AlunoService alunoService){
        this.alunoService =alunoService;
    }


     @GetMapping
    public List<Aluno> getAllAlunos() {
        return alunoService.getAllAlunos();
    }

    @GetMapping("/{id}")
    public Aluno getAlunoById(@PathVariable Long id) {
        return alunoService.getAlunoById(id);
    }

    @PostMapping("/add")
    public Aluno createAluno(@RequestBody Aluno aluno) {
        return alunoService.CreateAluno(aluno);
    }

    @DeleteMapping("/{id}")
    public void deleteAluno(@PathVariable Long id){
        alunoService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Aluno updateAluno(@PathVariable Long id, @RequestBody Aluno aluno) {
        return alunoService.updateAluno(aluno, id);
    }

    
}