package com.lucassilvs.caixaproducer.controller;

import com.lucassilvs.caixaproducer.models.request.ProdutoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface ProdutoController {

    ResponseEntity<String> adicionarProduto(ProdutoRequest produtoRequest);

    ResponseEntity<String> removerProduto(ProdutoRequest produtoRequest);
}
