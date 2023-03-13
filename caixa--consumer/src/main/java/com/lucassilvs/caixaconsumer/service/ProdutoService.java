package com.lucassilvs.caixaconsumer.service;

import com.lucassilvs.caixaconsumer.models.response.ProdutoResponse;

public interface ProdutoService {

    ProdutoResponse buscarProduto(int idProduto);
}
