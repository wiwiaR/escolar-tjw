package br.edu.ifce.MeuPrimeiroSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifce.MeuPrimeiroSpring.model.Professor;
import br.edu.ifce.MeuPrimeiroSpring.serviceImpl.ProfessorServiceImpl;

@Controller
@RequestMapping("/professores")
public class ProfessorController {

	@Autowired
	ProfessorServiceImpl professor;
	
	@GetMapping
	public ModelAndView professores(ModelMap model) {
		model.addAttribute("prof", professor.buscarTodos());
		return new ModelAndView("professor/lista.html");
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar(Professor prof) {
		return new ModelAndView("professor/cadastro.html");
	}
	
	@PostMapping("/salvar")
	public String salvar(Professor prof) {
		professor.salvar(prof);
		return "redirect:/professores/listar";
	}
	
	@GetMapping("/listar")
	public ModelAndView listar(ModelMap model) {
		model.addAttribute("prof", professor.buscarTodos());
		return new ModelAndView("professor/lista.html");
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("prof", professor.buscarPorId(id));
		return new ModelAndView("professor/edicao.html");
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
