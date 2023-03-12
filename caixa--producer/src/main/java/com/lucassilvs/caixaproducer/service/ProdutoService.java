package com.lucassilvs.caixaproducer.service;

import com.lucassilvs.caixaproducer.models.request.ProdutoRequest;

public interface ProdutoService {

    void adicionarProduto(ProdutoRequest produtoRequest);

    void  removerProduto(ProdutoRequest produtoRequest);
}
