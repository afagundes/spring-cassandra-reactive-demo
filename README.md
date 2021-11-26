# Spring Boot + Cassandra - Reactive DEMO

Teste de integração com o banco de dados Apache Cassandra utilizando spring-data-cassandra-reactive e Spring Boot.

## Pré-requisitos

Para facilitar o teste vamos subir o Casssandra utilizando Docker.

``` shell
# Cria uma rede
docker network create -d bridge cassandra

# Sobe a última versão do Apache Cassandra
docker run --rm -d -p 9042:9042 --name cassandra --hostname cassandra --network cassandra cassandra:latest

# Com o Cassandra no ar, conectamos ao node para executar os comandos
docker run --rm -it --network cassandra nuvo/docker-cqlsh cqlsh cassandra 9042 --cqlversion='3.4.5'
```

Dentro do shell CQLSH, criamos o Keyspace utilizado pelo exemplo

``` cassandraql
CREATE KEYSPACE IF NOT EXISTS store WITH REPLICATION = { 'class': 'SimpleStrategy', 'replication_factor': '1' };
```

## Execução

Dentro do diretório do projeto, executamos o seguinte comando

``` shell
./mvnw spring-boot:run
```

## Testes

Primeiro precisamos inserir alguns dados no Cassandra. Para isso faremos um POST no endpoint http://localhost:8080/product com o seguinte JSON:

``` json
{
    "title": "iPhone 12 128GB",
    "quantity": 1,
    "tags": ["smartphone", "apple", "iphone"]
}
```

Depois verificamos se os dados foram inseridos chamando o endpoint http://localhost:8080/product com o método GET. A resposta será semelhante a essa:

``` json
[
    {
        "id": "ec5594a0-4e29-11ec-862a-a96ef7a27f8e",
        "title": "iPhone 12 128GB",
        "quantity": 1,
        "tags": [
            "apple",
            "iphone",
            "smartphone"
        ]
    }
]
```
