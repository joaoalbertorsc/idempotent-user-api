```markdown
# Idempotent User API

Uma API RESTful simples desenvolvida em **Spring Boot**, focada na validação de dados de entrada e na implementação de métodos HTTP seguros e idempotentes.

## 🚀 Tecnologias Utilizadas

* **Java 17+**
* **Spring Boot 3.3.x** (Web, Validation)
* **Jakarta Validation** (Validação de DTOs)
* **Springdoc OpenAPI / Swagger** (Documentação automática)

## 🎯 Funcionalidades Principais

1. **Criação de Usuários:** Endpoint `POST /users` para cadastrar novos usuários.
2. **Validação Rigorosa:** Validação de campos obrigatórios, tamanho mínimo de string e valores numéricos positivos.
3. **Idempotência:** Requisições idênticas repetidas (mesmo payload) não geram registros duplicados no servidor, retornando sempre o status `201 Created` de forma transparente para o cliente.
4. **Tratamento de Exceções:** Retorno padronizado de erros de validação (HTTP 400 Bad Request).

## ⚙️ Como Executar o Projeto

1. Certifique-se de ter o **Java 17+** e o **Maven** instalados na sua máquina.
2. Clone o repositório e navegue até a pasta do projeto.
3. Execute o comando abaixo no terminal para iniciar a aplicação:

```bash
mvn spring-boot:run

```

A aplicação iniciará na porta `8080`.

## 📚 Documentação e Testes (Swagger)

Com a aplicação rodando, acesse a interface interativa do Swagger pelo seu navegador para testar a API:

👉 **[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)**

## 🛠️ Exemplos de Uso (Endpoint `POST /users`)

### 1. Requisição de Sucesso

**Request:**

```json
{
  "nome": "Carlos",
  "idade": 28
}

```

**Response (201 Created):**

```json
{
  "nome": "Carlos",
  "idade": 28
}

```

*Nota: Graças ao mecanismo de idempotência, enviar esta exata mesma requisição múltiplas vezes continuará retornando `201 Created` sem duplicar o usuário.*

### 2. Requisição com Erro de Validação

**Request:**

```json
{
  "nome": "Al",
  "idade": -5
}

```

**Response (400 Bad Request):**

```json
{
  "nome": "O nome deve ter pelo menos 3 caracteres.",
  "idade": "A idade deve ser um número positivo."
}

```
