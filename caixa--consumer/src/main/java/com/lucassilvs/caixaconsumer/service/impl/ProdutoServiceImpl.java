package com.lucassilvs.caixaconsumer.service.impl;

import com.lucassilvs.caixaconsumer.models.response.ProdutoResponse;
import com.lucassilvs.caixaconsumer.service.ProdutoService;
import io.confluent.ksql.api.client.BatchedQueryResult;
import io.confluent.ksql.api.client.Client;
import io.confluent.ksql.api.client.ClientOptions;
import io.confluent.ksql.api.client.Row;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    @Override
    public ProdutoResponse buscarProduto(int idProduto) {

        ClientOptions options = ClientOptions.create()
                .setHost("localhost")
                .setPort(8088);


        String buscarProdutoQuery = String.format("select * from PRODUTOS_TABLE where id = %d;", idProduto);

        try {
            Client clientKsqlDB = Client.create(options);

            BatchedQueryResult queryBatchResult = clientKsqlDB.executeQuery(buscarProdutoQuery);
            Long beforeQuery = System.currentTimeMillis();
            System.out.println();
            while (true){
                if(queryBatchResult.isDone()){
                    break;
                }
            }
            clientKsqlDB.close();

            Long afterQuery = System.currentTimeMillis();

            System.out.println(String.format("Tempo de execução em milissegundos: %d",afterQuery - beforeQuery));
            List<Row> queryResult = queryBatchResult.get();
            ProdutoResponse response = new ProdutoResponse();
            response.setQuantidadeProduto(queryResult.get(0).getInteger("ID"));
            response.setNomeProduto(queryResult.get(0).getString("NOME"));
            response.setProdutoId(queryResult.get(0).getInteger("QUANTIDADE"));
            return response;
        }catch (Exception e){
            throw new RuntimeException("Ocorreu algum erro ao tentar buscar Produto por ID: " + e);
        }
    }
}
