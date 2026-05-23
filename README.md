# README - Projeto Dobu API

## Descrição do Projeto

O projeto **Dobu API** consiste no desenvolvimento de uma API REST utilizando Java com Spring Boot para gerenciamento de consultas veterinárias.

O sistema foi desenvolvido com o objetivo de facilitar o controle e gerenciamento das consultas realizadas em uma clínica veterinária, permitindo cadastrar, listar, atualizar, buscar e remover consultas de forma organizada e eficiente.

A aplicação segue boas práticas de desenvolvimento backend utilizando arquitetura em camadas, DTOs, tratamento de exceções, paginação e cache.

---

# Solução Desenvolvida

Para solucionar o problema de gerenciamento de consultas veterinárias, foi criada uma API REST contendo:

* CRUD completo de consultas;
* Busca por descrição;
* Paginação de resultados;
* Persistência de dados;
* Tratamento de exceções;
* Cache para otimização;
* DTOs para entrada e saída de dados.

A aplicação utiliza Spring Data JPA juntamente com Hibernate para persistência dos dados no banco H2 Database.

---

# Funcionalidades

## Funcionalidades implementadas

### Consultas

* Cadastro de consultas;
* Listagem de consultas;
* Busca por ID;
* Atualização de consultas;
* Exclusão de consultas;
* Busca por descrição;
* Paginação de resultados.

### Recursos adicionais

* Cache com `@Cacheable`;
* Tratamento de exceções personalizadas;
* DTOs para organização dos dados;
* Persistência utilizando JPA/Hibernate.

---

# Tecnologias Utilizadas

| Tecnologia      | Finalidade                    |
| --------------- | ----------------------------- |
| Java 21         | Linguagem principal           |
| Spring Boot     | Framework backend             |
| Spring Web      | API REST                      |
| Spring Data JPA | Persistência de dados         |
| Hibernate       | ORM                           |
| H2 Database     | Banco de dados                |
| Maven           | Gerenciamento de dependências |
| Postman         | Teste dos endpoints           |
| Git/GitHub      | Versionamento                 |

---

# Estrutura do Projeto

O projeto foi organizado utilizando arquitetura em camadas:

```text
controller  -> Endpoints da API
service     -> Regras de negócio
repository  -> Acesso ao banco de dados
entity      -> Entidades do sistema
dto         -> Transferência de dados
exception   -> Tratamento de exceções
```

---

# Cronograma de Desenvolvimento

| Atividade                        | Responsável | Data       |
| -------------------------------- | ----------- | ---------- |
| Criação do projeto Spring Boot   | Erick       | 10/05/2026 |
| Configuração Maven               | Erick       | 10/05/2026 |
| Desenvolvimento das entidades    | Erick       | 11/05/2026 |
| Desenvolvimento dos repositories | Erick       | 11/05/2026 |
| Desenvolvimento dos services     | Erick       | 12/05/2026 |
| Desenvolvimento dos controllers  | Amandha     | 13/05/2026 |
| Implementação dos DTOs           | Amandha     | 14/05/2026 |
| Implementação de cache           | Amandha     | 15/05/2026 |
| Tratamento de exceções           | Amandha     | 16/05/2026 |
| Testes no Postman                | Giovanna    | 17/05/2026 |
| Correção de erros                | Giovanna    | 18/05/2026 |
| Documentação do projeto          | Giovanna    | 22/05/2026 |
| Finalização do projeto           | Giovanna    | 22/05/2026 |

---

# Endpoints da API

## Listar consultas

```http
GET / htts://localhost:8080/consultas
```

---

## Buscar consulta por ID

```http
GET / htts://localhost:8080/consultas/{id}
```

---

## Buscar consulta por descrição

```http
GET / htts://localhost:8080/consultas/buscar?descricao=texto
```

---

## Criar consulta

```http
POST / htts://localhost:8080/consultas
```

### Exemplo JSON

```json
{
  "descricao": "Consulta de rotina",
  "valor": 150.0,
  "dataConsulta": "2026-05-22T10:30:00"
}
```

---

## Atualizar consulta

```http
PUT / htts://localhost:8080/consultas/{id}
```

---

## Excluir consulta

```http
DELETE / htts://localhost:8080/consultas/{id}
```

---

# Persistência dos Dados

A persistência foi realizada utilizando:

* Spring Data JPA;
* Hibernate;
* Banco H2 Database.

Os testes realizados demonstraram que os dados podem ser:

* Inseridos;
* Atualizados;
* Recuperados;
* Removidos corretamente.

---

# Testes da API

Os testes dos endpoints foram realizados utilizando o Postman.

As requisições exportadas devem ser adicionadas na pasta:

```text
/documentos
```

Exemplo:

```text
/documentos
 ├── README.md
 ├── dobu-postman-collection.json
```

---

# Como Executar o Projeto

## Clonar o repositório

```bash
git clone URL_DO_REPOSITORIO
```

---

## Executar o projeto

```bash
./mvnw spring-boot:run
```

---

## Acessar a API

```text
http://localhost:8080/consultas
```

---

