package ac1.aluno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication

@RestController
@RequestMapping("/aluno")
public class AlunoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlunoApplication.class, args);
		
	}

}
