# kafka--gestao-de-estoque
implementação de de um sistema para gerenciamento de estoque de um mercado utilizando Kafka, kafka Stream e ksqlDB.


## Tecnologias utilizadas
- Docker
- Apache Kafka
- Spring Boot 3.0.4
- Gradle 7.5.1
- Java 17
- ksqlDB

## Kafka

Primeiramente, precisamos iniciar o servidor do Cluster Kafka para que possa ser iniciado a aplicação,
 foi disponibilizado um arquivo Docker Compose contendo todos os serviços necessário para a execução.

Para iniciar o Kafka, deve executar dentro da pasta docker/confluent-all-in-one o comando abaixo:

```zsh
docker compose up
```

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

Abaixo o comando para criar uma tabela ksqDB a partir da stream criada anteriormente:

```sql

CREATE TABLE produtos_table WITH(VALUE_FORMAT='AVRO') AS
select id, LATEST_BY_OFFSET(quantidade)
from PRODUTOS_STREAM\
GROUP BY id
 EMIT CHANGES;
```

a busca para criação da tabela é baseada no dado mais recente da coluna 'quantidade'

Abaixo está a query para criação da tabela de produto e quantidade,
porém agora é decrementado ou incrementado baseado no que for solicitado
pelo producer:

```sql
CREATE TABLE produtos_table WITH(VALUE_FORMAT='AVRO') AS
select id, SUM(quantidade) as QUANTIDADE
from PRODUTOS_STREAM
GROUP BY id
 EMIT CHANGES;
```
## Referencias

- [ksqlDB](https://docs.ksqldb.io/)
- [Confluent](https://developer.confluent.io/)



