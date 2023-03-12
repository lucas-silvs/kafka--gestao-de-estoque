package com.lucassilvs.caixaproducer.controller.impl;

import com.lucassilvs.caixaproducer.controller.ProdutoController;
import com.lucassilvs.caixaproducer.models.request.ProdutoRequest;
import com.lucassilvs.caixaproducer.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProdutoControllerImpl implements ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/adicionar-produto")
    public ResponseEntity adicionarProduto( @RequestBody ProdutoRequest produtoRequest) {
       try {
           produtoService.adicionarProduto(produtoRequest);
           return ResponseEntity.ok("Produto adicionado com sucesso");
       }
       catch (Exception e){
           return ResponseEntity.internalServerError().body("Ocorreu algum erro ao tentar adicionar produto: " + e.getMessage() + "excessão: " + e);
       }
    }

    @PostMapping("/remover-produto")
    public ResponseEntity removerProduto(@RequestBody ProdutoRequest produtoRequest) {
        try {
            produtoService.removerProduto(produtoRequest);
            return ResponseEntity.ok("Produto removido com sucesso");
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body("Ocorreu algum erro ao tentar remover produto: " + e.getMessage() + "excessão: " + e);
        }
    }
}
