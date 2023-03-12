# kafka--gestao-de-estoque
implementação de de um sistema para gerenciamento de estoque de um mercado utilizando Kafka, kafka Stream e ksqlDB.


## ksqlDB
 será utilizado para esse projeto o ksqlDB, ferramenta da Confluent para gerenciamento
 de processamento de dados de Kafka Stream com sintaxe SQL, e será utilizada para consulta
 do status dos produtos pelo consumer.
 
Abaixo, está o comando para criação do Kafka Stream do tópico de produtos no Control Center:

```sql
CREATE STREAM produtos_stream
  (id BIGINT,
   nome VARCHAR,
   quantidade BIGINT)
 WITH (KAFKA_TOPIC='produtos',
       VALUE_FORMAT='AVRO');
```

e abaixo o comando para criar uma tabela ksqDB a partir do tópico produtos:

```sql

CREATE TABLE produtos_table WITH(VALUE_FORMAT='AVRO') AS
select id, LATEST_BY_OFFSET(quantidade)
from PRODUTOS_STREAM\
GROUP BY id
 EMIT CHANGES;
```

a busca para criação da tabela é baseada no dado mais recente da coluna 'quantidade'

