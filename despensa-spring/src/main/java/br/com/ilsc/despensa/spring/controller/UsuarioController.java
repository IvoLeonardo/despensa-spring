package br.com.ilsc.despensa.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.ilsc.despensa.spring.model.Usuario;
import br.com.ilsc.despensa.spring.repository.UsuarioRepository;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("/cadastroUsuario")
	public String cadastraUsuario() {

		return "cadastro/cadastroUsuario";
	}

	@PostMapping("/salvarUsuario")
	public String salvar(Usuario usuario) {

		usuarioRepository.save(usuario);
		return "cadastro/cadastroUsuario";
	}

}
