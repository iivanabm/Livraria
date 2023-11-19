package com.projeto.livraria.model.repository;

import com.projeto.livraria.model.Caderno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadernoRepository extends CrudRepository<Caderno, Integer> {
}
