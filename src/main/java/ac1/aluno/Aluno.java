package ac1.aluno;

public class Aluno {

    private Long id;
    private String nome;
    private String email;
    private String curso;
    private String dataNascimento;

    public Aluno(long id, String nome, String email, String curso, String dataNascimento){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.curso = curso;
        this.dataNascimento = dataNascimento;
    }

    // Getter e Setter para o campo "id"
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter e Setter para o campo "nome"
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter e Setter para o campo "email"
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter e Setter para o campo "curso"
    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    // Getter e Setter para o campo "dataNascimento"
    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
}
    

