package br.com.ilsc.despensa.spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ilsc.despensa.spring.model.Fornecedor;
import br.com.ilsc.despensa.spring.repository.FornecedorRepository;

@Controller
public class FornecedorController {

	@Autowired
	private FornecedorRepository fornecedorRepository;

	@GetMapping("/cadastroFornecedor") // Informa a url do arquivo cadastroProduto.html
	public ModelAndView Fornecedor() {

		ModelAndView modelAndView = new ModelAndView("cadastro/cadastroFornecedor");
		modelAndView.addObject("fornecedorObj", new Fornecedor());

		return modelAndView;
	}

	// @RequestMapping(method = RequestMethod.POST, value = "/salvarProduto") //
	// código
	// legado. Funciona igual ao @PostMapping

	@PostMapping("**/salvarFornecedor") // url do formulário contido no action do form
	public ModelAndView salvar(Fornecedor fornecedor) {
		fornecedorRepository.save(fornecedor);

		ModelAndView modelAndView = new ModelAndView("cadastro/cadastroFornecedor");
		Iterable<Fornecedor> fornecedores = fornecedorRepository.findAll();
		modelAndView.addObject("fornecedores", fornecedores);
		modelAndView.addObject("fornecedorObj", new Fornecedor());

		return modelAndView;
	}

	@GetMapping("/listaFornecedores")
	public ModelAndView listaFornecedores() {

		ModelAndView modelAndView = new ModelAndView("cadastro/cadastroFornecedor");// url do arquivo html
		Iterable<Fornecedor> fornecedores = fornecedorRepository.findAll(); // cria lista de produtos e o método findAll
																			// carrega
		// todas as informações da tabela do banco de dados
		modelAndView.addObject("fornecedores", fornecedores);
		modelAndView.addObject("fornecedorObj", new Fornecedor());

		return modelAndView;
	}

	@GetMapping("/editarFornecedor/{fornecedorId}") // recebe url com parâmetro do link editar
	public ModelAndView editar(@PathVariable("fornecedorId") Long fornecedorId) { // @PathVariable pega a variável do
																					// link
		// html

		Optional<Fornecedor> fornecedor = fornecedorRepository.findById(fornecedorId);

		ModelAndView modelAndView = new ModelAndView("cadastro/cadastroFornecedor"); // url do arquivo html (view) que
																						// vai
		modelAndView.addObject("fornecedorObj", fornecedor.get());

		return modelAndView;
	}

	@GetMapping("/removerFornecedor/{fornecedorId}") // recebe url com parâmetro do link excluir
	public ModelAndView excluir(@PathVariable("fornecedorId") Long fornecedorId) { // @PathVariable pega a variável do
																					// link
																					// html

		fornecedorRepository.deleteById(fornecedorId);

		ModelAndView modelAndView = new ModelAndView("cadastro/cadastroFornecedor"); // url do arquivo html (view) que
																						// vai
		modelAndView.addObject("fornecedores", fornecedorRepository.findAll());
		modelAndView.addObject("fornecedorObj", new Fornecedor());

		return modelAndView;
	}
}
