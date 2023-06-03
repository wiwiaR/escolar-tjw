package br.edu.ifce.MeuPrimeiroSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifce.MeuPrimeiroSpring.model.Professor;
import br.edu.ifce.MeuPrimeiroSpring.serviceImpl.ProfessorServiceImpl;

@Controller
@RequestMapping("/professores")
public class ProfessorController {

	@Autowired
	ProfessorServiceImpl professor;
	
	@GetMapping("/cadastrar")
	public String cadastrar(ModelMap model) {
		model.addAttribute("prof", new Professor());
		return "/professores/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(Professor prof) {
		professor.salvar(prof);
		return "redirect:/professores/listar";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("professor", professor.buscarTodos());
		return "/professores/lista";	
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("prof", professor.buscarPorId(id));
		return "/professores/cadastro";
	}
	
	@PostMapping ("/editar")
	public String editar(Professor prof) {
		professor.editar(prof);
		return "redirect:/professores/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		professor.excluir(id);
		return "redirect:/professores/listar";
	}
}
