package com.produtos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.produtos.entidades.Produtos;

@Repository
public interface IProdutosRepository extends CrudRepository<Produtos, Integer>{

}
