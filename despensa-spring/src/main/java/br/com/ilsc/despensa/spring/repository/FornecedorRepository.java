package br.com.ilsc.despensa.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ilsc.despensa.spring.model.Fornecedor;

@Repository
public interface FornecedorRepository extends CrudRepository<Fornecedor, Long> {

}
