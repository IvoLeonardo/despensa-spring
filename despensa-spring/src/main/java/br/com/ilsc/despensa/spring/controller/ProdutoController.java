package br.com.ilsc.despensa.spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ilsc.despensa.spring.model.Produto;
import br.com.ilsc.despensa.spring.repository.ProdutoRepository;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	// @RequestMapping(method = RequestMethod.GET, value = "/cadastroProduto")
	@GetMapping("/cadastroProduto") // Informa a url do arquivo cadastroProduto.html
	public ModelAndView Produto() {

		ModelAndView modelAndView = new ModelAndView("cadastro/cadastroProduto");
		modelAndView.addObject("produtoObj", new Produto());

		return modelAndView;
	}

	// @RequestMapping(method = RequestMethod.POST, value = "/salvarProduto") //
	// código
	// legado. Funciona igual ao @PostMapping

	@PostMapping("**/salvarProduto") // url do formulário contido no action do form
	public ModelAndView salvar(Produto produto) {
		produtoRepository.save(produto);

		ModelAndView modelAndView = new ModelAndView("cadastro/cadastroProduto");
		Iterable<Produto> produtos = produtoRepository.findAll();
		modelAndView.addObject("produtos", produtos);
		modelAndView.addObject("produtoObj", new Produto());

		return modelAndView;
	}

	@GetMapping("/listaProdutos")
	public ModelAndView listaProdutos() {

		ModelAndView modelAndView = new ModelAndView("cadastro/cadastroProduto");// url do arquivo html
		Iterable<Produto> produtos = produtoRepository.findAll(); // cria lista de produtos e o método findAll carrega
																	// todas as informações da tabela do banco de dados
		modelAndView.addObject("produtos", produtos);
		modelAndView.addObject("produtoObj", new Produto());

		return modelAndView;
	}

	@GetMapping("/editarProduto/{idProduto}") // recebe url com parâmetro do link editar
	public ModelAndView editar(@PathVariable("idProduto") Long idProduto) { // @PathVariable pega a variável do link
																			// html

		Optional<Produto> produto = produtoRepository.findById(idProduto);

		ModelAndView modelAndView = new ModelAndView("cadastro/cadastroProduto"); // url do arquivo html (view) que vai
		modelAndView.addObject("produtoObj", produto.get());

		return modelAndView;
	}

	@GetMapping("/excluirProduto/{idProduto}") // recebe url com parâmetro do link excluir
	public ModelAndView excluir(@PathVariable("idProduto") Long idProduto) { // @PathVariable pega a variável do link
																				// html

		produtoRepository.deleteById(idProduto);

		ModelAndView modelAndView = new ModelAndView("cadastro/cadastroProduto"); // url do arquivo html (view) que vai
		modelAndView.addObject("produtos", produtoRepository.findAll());
		modelAndView.addObject("produtoObj", new Produto());

		return modelAndView;
	}
}
