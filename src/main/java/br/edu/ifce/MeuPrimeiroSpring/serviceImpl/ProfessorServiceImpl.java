package br.edu.ifce.MeuPrimeiroSpring.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifce.MeuPrimeiroSpring.model.Professor;
import br.edu.ifce.MeuPrimeiroSpring.repository.ProfessorRepository;
import br.edu.ifce.MeuPrimeiroSpring.service.ProfessorService;

@Service
public class ProfessorServiceImpl implements ProfessorService{
	
	@Autowired
	ProfessorRepository professor;

	@Override
	public Professor buscarPorId(Long id) {
		return professor.findById(id).orElse(null);
	}

	@Override
	public List<Professor> buscarTodos() {
		return professor.findAll();
	}

	@Override
	public Professor salvar(Professor p) {
		return professor.save(p);
	}

	@Override
	public Professor editar(Professor p) {
		return professor.save(p);
	}

	@Override
	public void excluir(Long id) {
		professor.deleteById(id);
	}

}
