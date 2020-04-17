package com.produtos.apirest.controllers;

import java.util.List;

import com.produtos.apirest.models.Produtos;
import com.produtos.apirest.repositories.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API Rest Produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {

    @Autowired
    ProdutoRepository pr;

    @GetMapping("/produtos")
    @ApiOperation(value = "Retorna todos os produtos")
    public List<Produtos> listaProdutos(){
        return pr.findAll();
    }
    @GetMapping("/produtos/{id}")
    @ApiOperation(value = "Retorna um único produto")
    public Produtos listaProdutoUnico(@PathVariable(value = "id") long id){
        return pr.findById(id);
    }

    @PostMapping("/produtos")
    @ApiOperation(value = "Salva um produto")
    public Produtos salvaProduto(@RequestBody Produtos produto){
        return pr.save(produto);
    }

    @DeleteMapping("/produtos")
    @ApiOperation(value = "Deleta um produto")
    public void deletaProduto(@RequestBody Produtos produto){
         pr.delete(produto);
    }

    @PutMapping("/produtos")
    @ApiOperation(value = "Atualiza um produto")
    public Produtos atualizaProduto(@RequestBody Produtos produto){
        return pr.save(produto);
    }
}