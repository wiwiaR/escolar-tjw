package br.edu.ifce.MeuPrimeiroSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifce.MeuPrimeiroSpring.model.Turma;
import br.edu.ifce.MeuPrimeiroSpring.serviceImpl.TurmaServiceImpl;

@Controller
@RequestMapping("/turmas")
public class TurmaController {
	
	@Autowired
	TurmaServiceImpl turma;

	@GetMapping("/cadastrar")
	public String cadastrar(ModelMap model) {
		model.addAttribute("tur", new Turma());
		return "/turmas/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(Turma tur) {
		turma.salvar(tur);
		return "redirect:/turmas/listar";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("turma", turma.buscarTodos());
		return "/turmas/lista";	
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("tur", turma.buscarPorId(id));
		return "/turmas/cadastro";
	}
	
	@PostMapping ("/editar")
	public String editar(Turma tur) {
		turma.editar(tur);
		return "redirect:/turmas/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		turma.excluir(id);
		return "redirect:/turmas/listar";
	}
}
