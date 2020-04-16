package com.produtos.apirest.controllers;

import java.util.List;

import com.produtos.apirest.models.Produtos;
import com.produtos.apirest.repositories.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ("/api"))
public class ProdutoController {

    @Autowired
    ProdutoRepository pr;

    @GetMapping("/produtos")
    public List<Produtos> listaProdutos(){
        return pr.findAll();
    }
    @GetMapping("/produtos/{id}")
    public Produtos listaProdutoUnico(@PathVariable(value = "id") long id){
        return pr.findById(id);
    }

    @PostMapping("/produtos")
    public Produtos salvaProduto(@RequestBody Produtos produto){
        return pr.save(produto);
    }

}