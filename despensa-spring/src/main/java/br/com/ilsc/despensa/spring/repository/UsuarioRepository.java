package br.com.ilsc.despensa.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ilsc.despensa.spring.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}
