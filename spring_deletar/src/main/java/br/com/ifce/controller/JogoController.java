package br.com.ifce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.ifce.model.Jogo;
import br.com.ifce.service.JogoService;

@Controller
public class JogoController {
	@Autowired
	private JogoService jogoService;
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/home/formulario")
	public ModelAndView formulario() {
		ModelAndView mv = new ModelAndView("formulario");
		mv.addObject("jogo", new Jogo());
		return mv;
	}
	
	@RequestMapping("/home/formulario/salvar")
	public ModelAndView salvar(Jogo jogo, @RequestParam(value="imagem") MultipartFile imagem) {
		jogoService.cadastrarJogo(jogo, imagem);
		
		ModelAndView mv = new ModelAndView("redirect:/home/lista");
		return mv;
	}
	
	@GetMapping("/home/lista")
	public ModelAndView listarJogos() {
		List<Jogo> jogos = jogoService.listarJogos();
		
		ModelAndView mv = new ModelAndView("lista-jogos");
		mv.addObject("listaDeJogos", jogos);
		
		return mv;
	}
	
	@GetMapping("/home/lista/excluir/{codigo}")
	public ModelAndView apagar(@PathVariable Long codigo) {
		jogoService.excluir(codigo);
		
		ModelAndView mv = new ModelAndView("redirect:/home/lista");
		
		return mv;
	}
	
	@RequestMapping("/home/lista/atualizar/{codigo}")
	public ModelAndView editar(@PathVariable Long codigo) {
		Optional<Jogo> jogo = jogoService.buscarPorID(codigo);
		
		ModelAndView mv = new ModelAndView("formulario");
		mv.addObject("jogo", jogo);
		
		return mv;
	}
}
