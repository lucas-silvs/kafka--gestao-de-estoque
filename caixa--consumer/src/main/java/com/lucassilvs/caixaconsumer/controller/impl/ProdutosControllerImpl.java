package com.lucassilvs.caixaconsumer.controller.impl;

import com.lucassilvs.caixaconsumer.controller.ProdutosController;
import com.lucassilvs.caixaconsumer.models.response.ProdutoResponse;
import com.lucassilvs.caixaconsumer.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class ProdutosControllerImpl implements ProdutosController {

    @Autowired
    private ProdutoService produtoService;


    @GetMapping("/buscar-produto")
    public ResponseEntity consultarQuantidadeArmazenadaProduto(int idProduto) {
        ProdutoResponse response = produtoService.buscarProduto(idProduto);
        return ResponseEntity.ok(response);
    }
}
