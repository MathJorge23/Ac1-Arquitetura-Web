package ac1.aluno.repository;

import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.config.Task;

import java.util.ArrayList;
import java.util.List;

import ac1.aluno.model.Aluno;


@Repository
public class AlunoRepositoryImpl implements AlunoRepository{
    private final JdbcTemplate jdbcTemplate;

    public AlunoRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Aluno> findAll() {
        return jdbcTemplate.query("SELECT * FROM task", (resultSet, rowNum) -> {
                    System.out.println("Numero da linha: " + rowNum);
                    return new Aluno(
                            resultSet.getLong("id"),
                            resultSet.getString("nome"),
                            resultSet.getString("email"),
                            resultSet.getString("curso"),
                            resultSet.getString("dataNascimento")

                    );
                }
        );
    }
    
    @Override
    public Aluno findById(Long id) {

        String query = "SELECT * FROM task WHERE id = ?";

        return jdbcTemplate.queryForObject(query, new Object[]{id}, (resultSet, rowNum) ->
                new Aluno(
                        /*
                        Para se recuperar os valores das colunas é preciso saber o tipo e o nome, pois os métodos são
                        especificos
                         */
                        resultSet.getLong("id"),
                            resultSet.getString("nome"),
                            resultSet.getString("email"),
                            resultSet.getString("curso"),
                            resultSet.getString("dataNascimento")

                )
        );
    }

    public Aluno save(Aluno aluno) {
        String query = "INSERT INTO aluno (nome, email, curso, dataNascimento) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(query, aluno.getNome(), aluno.getEmail(), aluno.getCurso(), aluno.getDataNascimento());
        return aluno;
    }

    public void delete(Long id) {
        String query = "DELETE FROM aluno WHERE id = ?";
        jdbcTemplate.update(query, id);
    }

    public Aluno update(Aluno aluno, Long id) {
        String query = "UPDATE aluno SET nome = ?, email = ?, curso = ?, dataNascimento = ? WHERE id = ?";
        jdbcTemplate.update(query, aluno.getNome(), aluno.getEmail(), aluno.getCurso(), aluno.getDataNascimento(), id);
        return aluno;
    }  
}
