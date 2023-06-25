package br.edu.ifce.MeuPrimeiroSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifce.MeuPrimeiroSpring.model.Estudante;
import br.edu.ifce.MeuPrimeiroSpring.serviceImpl.EstudanteServiceImpl;

@Controller
@RequestMapping("/estudantes")
public class EstudanteController {
	
	@Autowired
	EstudanteServiceImpl estudante;

	@GetMapping
	public ModelAndView estudantes(ModelMap model) {
		model.addAttribute("est", estudante.buscarTodos());
		return new ModelAndView("estudante/lista.html");
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar(Estudante est) {
		return new ModelAndView("estudante/cadastro.html");
	}
	
	@PostMapping("/salvar")
	public String salvar(Estudante est) {
		estudante.salvar(est);
		return "redirect:/estudantes/listar";
	}
	
	@GetMapping("/listar")
	public ModelAndView listar(ModelMap model) {
		model.addAttribute("est", estudante.buscarTodos());
		return new ModelAndView("estudante/lista.html");
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("est", estudante.buscarPorId(id));
		return new ModelAndView("estudante/edicao.html");
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
