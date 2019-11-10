# b2vn-auth-api
Back-end de autenticação do projeto B2VN utilizando Java 11, Spring Boot, Spring Security, OAuth2.0, Spring Cloud OpenFeign, QueryDSL e PostgreSQL 11.

# Build no projeto localmente

mvn clean install

# Rodando o projeto localmente

Na raiz da aplicação: 

mvn spring-boot:run

ou

cd /target
java -jar b2vn-auth-api.jar

# Criar rede b2vn overlay para aplicação
docker network create -d overlay --driver=bridge b2vn

# Build do projeto de autenticação B2VN Auth
docker build -t b2vn-auth-api .

# Rodar o projeto B2VN Auth
docker run --net=b2vn -p 8080:8080 -t b2vn-auth-api   

# Documentação da API com o Swagger
http://localhost:8080/swagger-ui.html
