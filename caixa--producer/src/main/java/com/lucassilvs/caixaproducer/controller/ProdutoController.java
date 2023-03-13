package com.lucassilvs.caixaproducer.controller;

import com.lucassilvs.caixaproducer.models.request.ProdutoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ProdutoController {

    @PostMapping("/adicionar-produto")
    ResponseEntity<String> adicionarProduto(  @RequestBody ProdutoRequest produtoRequest);

    @PostMapping("/remover-produto")
    ResponseEntity<String> removerProduto(@RequestBody ProdutoRequest produtoRequest);
}
