package br.com.ifce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.ifce.model.Jogo;
import br.com.ifce.repository.JogoRepository;
import br.com.ifce.util.JogoFileUtils;

@Service
public class JogoService {
	
	@Autowired
	private JogoRepository jogoRepo;
	
	public void cadastrarJogo(Jogo jogo, MultipartFile imagem) {
		
		String caminho = "images/" + jogo.getNome() + ".png";
		JogoFileUtils.salvarImagem(caminho, imagem);
		
		jogoRepo.save(jogo);
	}
	
	public List<Jogo> listarJogos() {
		return jogoRepo.findAll();
	}
	
	public void excluir(Long codigo) {
		jogoRepo.deleteById(codigo);
	}
	
	public Optional<Jogo> buscarPorID(Long codigo) {
		return jogoRepo.findById(codigo);
		
	}
}
