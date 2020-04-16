package com.produtos.apirest.repositories;

import com.produtos.apirest.models.Produtos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produtos, Long> {
    Produtos findById(long id);
}