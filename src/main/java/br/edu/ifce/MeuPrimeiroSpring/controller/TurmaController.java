package br.edu.ifce.MeuPrimeiroSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifce.MeuPrimeiroSpring.model.Turma;
import br.edu.ifce.MeuPrimeiroSpring.serviceImpl.TurmaServiceImpl;

@Controller
@RequestMapping("/turmas")
public class TurmaController {
	
	@Autowired
	TurmaServiceImpl turma;
	
	@GetMapping
	public ModelAndView turmas(ModelMap model) {
		model.addAttribute("tur", turma.buscarTodos());
		return new ModelAndView("turma/lista.html");
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar(Turma tur) {
		return new ModelAndView("turma/cadastro.html");
	}
	
	@PostMapping("/salvar")
	public String salvar(Turma tur) {
		turma.salvar(tur);
		return "redirect:/turmas/listar";
	}
	
	@GetMapping("/listar")
	public ModelAndView listar(ModelMap model) {
		model.addAttribute("tur", turma.buscarTodos());
		return new ModelAndView("turma/lista.html");
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("tur", turma.buscarPorId(id));
		return new ModelAndView("turma/edicao.html");
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
