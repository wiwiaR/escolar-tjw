package br.edu.ifce.MeuPrimeiroSpring.service;

import java.util.List;

import br.edu.ifce.MeuPrimeiroSpring.model.Turma;

public interface TurmaService {
	
	Turma buscarPorId(Long id);
	
	List<Turma> buscarTodos();
	
	Turma salvar(Turma t);
	
	Turma editar(Turma t);
	
	void excluir(Long id);

}
