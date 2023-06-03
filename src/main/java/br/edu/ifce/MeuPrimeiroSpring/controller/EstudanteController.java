package br.edu.ifce.MeuPrimeiroSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifce.MeuPrimeiroSpring.model.Estudante;
import br.edu.ifce.MeuPrimeiroSpring.serviceImpl.EstudanteServiceImpl;

@Controller
@RequestMapping("/estudantes")
public class EstudanteController {

	@Autowired
	EstudanteServiceImpl estudante;
	
	@GetMapping("/cadastrar")
	public String cadastrar(ModelMap model) {
		model.addAttribute("est", new Estudante());
		return "/estudantes/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(Estudante est) {
		estudante.salvar(est);
		return "redirect:/estudantes/listar";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("estudante", estudante.buscarTodos());
		return "/estudantes/lista";	
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("est", estudante.buscarPorId(id));
		return "/estudantes/cadastro";
	}
	
	@PostMapping ("/editar")
	public String editar(Estudante est) {
		estudante.editar(est);
		return "redirect:/estudantes/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		estudante.excluir(id);
		return "redirect:/estudantes/listar";
	}
}
