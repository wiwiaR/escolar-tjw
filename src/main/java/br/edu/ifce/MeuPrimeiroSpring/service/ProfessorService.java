package br.edu.ifce.MeuPrimeiroSpring.service;

import java.util.List;

import br.edu.ifce.MeuPrimeiroSpring.model.Professor;

public interface ProfessorService {
	
	Professor buscarPorId(Long id);
	
	List<Professor> buscarTodos();
	
	Professor salvar(Professor p);
	
	Professor editar(Professor p);
	
	void excluir(Long id);

}
