package com.lucassilvs.caixaconsumer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface ProdutosController {

    @GetMapping
    ResponseEntity consultarQuantidadeArmazenadaProduto(@RequestParam(name = "id")int idProduto);
}
