package br.edu.ifce.MeuPrimeiroSpring.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifce.MeuPrimeiroSpring.model.Estudante;
import br.edu.ifce.MeuPrimeiroSpring.repository.EstudanteRepository;
import br.edu.ifce.MeuPrimeiroSpring.service.EstudanteService;

@Service
public class EstudanteServiceImpl implements EstudanteService{

	@Autowired
	EstudanteRepository estudante;

	@Override
	public Estudante buscarPorId(Long id) {
		return estudante.findById(id).orElse(null);
	}

	@Override
	public List<Estudante> buscarTodos() {
		return estudante.findAll();
	}

	@Override
	public Estudante salvar(Estudante e) {
		return estudante.save(e);
	}

	@Override
	public Estudante editar(Estudante e) {
		return estudante.save(e);
	}

	@Override
	public void excluir(Long id) {
		estudante.deleteById(id);
		
	}
	

}
