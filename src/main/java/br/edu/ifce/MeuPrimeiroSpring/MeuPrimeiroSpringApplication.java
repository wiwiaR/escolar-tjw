package br.edu.ifce.MeuPrimeiroSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ifce.MeuPrimeiroSpring.repository.EstudanteRepository;
import br.edu.ifce.MeuPrimeiroSpring.repository.ProfessorRepository;
import br.edu.ifce.MeuPrimeiroSpring.repository.TurmaRepository;

@SpringBootApplication
public class MeuPrimeiroSpringApplication implements CommandLineRunner{
	
	@Autowired
	private EstudanteRepository estudante;
	
	@Autowired
	private ProfessorRepository professor;
	
	@Autowired
	private TurmaRepository turma;

	public static void main(String[] args) {
		SpringApplication.run(MeuPrimeiroSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
