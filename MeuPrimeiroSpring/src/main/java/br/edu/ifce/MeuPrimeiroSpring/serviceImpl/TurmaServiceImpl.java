package br.edu.ifce.MeuPrimeiroSpring.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifce.MeuPrimeiroSpring.model.Turma;
import br.edu.ifce.MeuPrimeiroSpring.repository.TurmaRepository;
import br.edu.ifce.MeuPrimeiroSpring.service.TurmaService;

@Service
public class TurmaServiceImpl implements TurmaService{

	@Autowired
	TurmaRepository turma;
	
	@Override
	public Turma buscarPorId(Long id) {
		return turma.findById(id).orElse(null);
	}

	@Override
	public List<Turma> buscarTodos() {
		return turma.findAll();
	}

	@Override
	public Turma salvar(Turma t) {
		return turma.save(t);
	}

	@Override
	public Turma editar(Turma t) {
		return turma.save(t);
	}

	@Override
	public void excluir(Long id) {
		turma.deleteById(id);
	}

}
