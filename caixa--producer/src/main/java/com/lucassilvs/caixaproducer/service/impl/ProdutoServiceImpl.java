package com.lucassilvs.caixaproducer.service.impl;

import com.lucassilvs.caixaproducer.components.kafka.KafkaUtils;
import com.lucassilvs.caixaproducer.kafka.ProdutoAvro;
import com.lucassilvs.caixaproducer.models.request.ProdutoRequest;
import com.lucassilvs.caixaproducer.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private KafkaUtils<ProdutoAvro> kafkaUtils;


    @Override
    public void adicionarProduto(ProdutoRequest produtoRequest) {
        ProdutoAvro produto = ProdutoAvro.newBuilder()
                .setId(produtoRequest.getProdutoId())
                .setNome(produtoRequest.getNomeProduto())
                .setQuantidade(produtoRequest.getQuantidadeProduto())
                .build();

        kafkaUtils.postarMensagem(produto);

    }

    @Override
    public void removerProduto(ProdutoRequest produtoRequest) {
        ProdutoAvro produto = ProdutoAvro.newBuilder()
                .setId(produtoRequest.getProdutoId())
                .setNome(produtoRequest.getNomeProduto())
                .setQuantidade( - (produtoRequest.getQuantidadeProduto()))
                .build();

        kafkaUtils.postarMensagem(produto);
    }
}
