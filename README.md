# b2vn-auth-api
Back-end de autenticação do projeto B2VN utilizando Java 11, Spring Boot, Spring Security, OAuth2.0, Spring Cloud OpenFeign, QueryDSL e PostgreSQL 11.

## Exigências

Para o desenvolvimento, você precisará apenas do JAVA instalado em seu ambiente de trabalho.

### Java

O [Java](https://adoptopenjdk.net/?variant=openjdk11&jvmVariant=hotspot) é realmente fácil de instalar.
Você poderá executar o seguinte comando após o procedimento de instalação abaixo.

    $ java -version
    java version "11.0.5"


## Instalação - Local

    $ git clone https://github.com/vhnegrisoli/b2vn-auth-api.git
    $ cd b2vn-auth-api
    
### Build no projeto localmente

    $ mvn clean install

### Rodando o projeto localmente

Na raiz da aplicação: 

    $ mvn spring-boot:run

ou

    $ cd /target
    $ java -jar b2vn-auth-api.jar
    

## Instalação - Docker

Para começar, como são microsserviços, é necessário ter todos os projetos.

    $ git clone https://github.com/vhnegrisoli/b2vn-auth-api.git
    $ git clone https://github.com/vhnegrisoli/b2vn-radar-api.git
    $ git clone https://github.com/Noninus/b2vn-front.git

###  Criar network b2vn
    $ docker network create b2vn

### Build dos projetos
    $ docker image build -t b2vn-auth-api .
    $ docker image build -t b2vn-radar-api .
    $ docker image build -t b2vn-front .

### Criar o container com o parametro --name para especificar o network
    $ docker container run --network b2vn --name auth -p 8080:8080 -d b2vn-auth-api
    $ docker container run --network b2vn --name radar -p 8081:8081 -d b2vn-radar-api
    $ docker container run --network b2vn --name front -p 3000:80 b2vn-front


### Funcionalidades
    Paginação nas consultas para melhoras a eficiência  
    Token de segurança (Oauth2)
    Log para controle de acesso dos usuários
    Sistema [RBAC](https://docs.microsoft.com/pt-br/azure/role-based-access-control/overview) (Usuários, administradores, configurações de acesso, permissões)
    Rate Limiting baseado no RBAC
    API baseada em microsserviços: Autenticação, Radares, Trajetos e Controles
    Saídas em JSON, XML
    Exportação para CSV


## Arquitetura

A arquitetura utilizada é a [REST](http://www.matera.com/blog/post/quais-os-beneficios-da-arquitetura-rest), que é um protocolo utilizado na integração de Web Services, e estes, são soluções utilizadas para integração e comunicação entre sistemas. Como uma abstração da arquitetura HTTP

![RESTful example](http://www.matera.com/br/wp-content/uploads/2018/06/RESTful-Service-Client-Example-Crunchify-Tutorial.png)


## Documentos da API

### Diagrama de caso de uso

O [Diagrama de Caso de Uso](https://medium.com/operacionalti/uml-diagrama-de-casos-de-uso-29f4358ce4d5) descreve as funcionalidades propostas pelo PhiloPDV e é uma excelente ferramenta para o levantamento dos requisitos funcionais do sistema.interações com elementos externos e entre si.

![Caso de Uso - B2VN](https://uploaddeimagens.com.br/images/002/513/934/full/caso-uso.jpeg?1574080556)

### Diagrama de implantação

O [Diagrama de Implantação](https://www.lucidchart.com/pages/pt/o-que-e-diagrama-de-implementacao-uml) descreve a implementação física de informações geradas pelo programa de software em componentes de hardware.

![Implantação - B2VN](https://i.ibb.co/JByjgDR/Diagrama-de-Implanta-o.png)

## Documentação - Swagger

### Documentação da autenticação
http://localhost:8080/swagger-ui.html

### Documentação dos radares
http://localhost:8081/swagger-ui.html


## Linguagens & ferramentas

### JAVA

- [Spring Boot](https://spring.io/projects/spring-boot) é o framework do projeto.
- [Spring Security](https://spring.io/projects/spring-security) é uma estrutura que fornece autenticação, autorização e outros recursos de segurança para aplicativos corporativos
- [Oauth2](https://oauth.net/2/) é o protocolo para autorização. 
- [QueryDSL](http://www.querydsl.com/) é utilizado para simplificação de consultas ao banco de dados.
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa) implementa facilmente o JPA.
- [PostgreSQL](https://www.postgresql.org/) como banco de dados.
- [OpenFeign](https://github.com/OpenFeign/feign) para realizar os feign clients.
- [Spring Cloud](https://spring.io/projects/spring-cloud) para ferramentas voltadas a microsserviços.