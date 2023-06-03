package br.edu.ifce.MeuPrimeiroSpring.service;

import java.util.List;

import br.edu.ifce.MeuPrimeiroSpring.model.Estudante;

public interface EstudanteService {
	
	Estudante buscarPorId(Long id);
	
	List<Estudante> buscarTodos();
	
	Estudante salvar(Estudante e);
	
	Estudante editar(Estudante e);
	
	void excluir(Long id);
	

}
