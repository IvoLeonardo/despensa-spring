package br.com.ilsc.despensa.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ilsc.despensa.spring.model.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

	// List<Produto> findProdutoByName(String produto);
}
