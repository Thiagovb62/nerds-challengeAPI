# nerds-api

- Aplicação Java Spring Boot.
- Banco: PostgreSQL.
- Swagger UI: `http://localhost:8080/swagger-ui/index.html`

## Requisitos
- Java JDK 17\+ (ou compatível com a versão do projeto)
- Maven
- Docker e Docker Compose (para execução em containers)
- (Opcional) PostgreSQL local, se for executar sem Docker

## Variáveis de ambiente
A aplicação lê as seguintes variáveis de ambiente (definidas no `application.properties`):

- `DATABASE_URL` — URL JDBC do PostgreSQL, formato: `jdbc:postgresql://<host>:<port>/<database>`
    - Exemplo usado no Docker: `jdbc:postgresql://db:5432/nerds-db`
- `DATABASE_USERNAME` — usuário do banco (ex.: `nerds`)
- `DATABASE_PASSWORD` — senha do banco (ex.: `nerds`)

Observação: passe o valor completo do JDBC em `DATABASE_URL`. Não use literais como `{$DATABASE_URL}`.

## Rodando Localmente
Apos mudar as variaveis de ambiente no properties execute no terminal da aplicacao o seguinte comando

- `mvn spring-boot:run`
-depois acesse tambem via swagger `http://localhost:8080/swagger-ui/index.html`

## Rodando com Docker Compose
1. Certifique-se de ter `docker` e `docker compose` instalados.
2. No diretório do projeto (onde está `docker-compose.yaml`), execute:
   ```bash
   docker compose up --build -d
3. A aplicação estará disponível em `http://localhost:8080/swagger-ui/index.html`
