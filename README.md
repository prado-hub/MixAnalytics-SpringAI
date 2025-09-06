**Visão Geral**  
Aplicativo Spring Boot desenvolvido com Java 21 que gerencia o inventário de insumos usados por bartenders e gera receitas criativas usando a integração com o ChatGPT.

**Estrutura do projeto:**
Esse projeto consiste em um CRUD **(create,read,update e delete)** para realizarmos as operações relacionadas ao nosso model e também na implementação do **Spring AI**, um ecossistema spring que facilita a integração com módulos de inteligência artificial com a linguagem **java**. Importante destacar também o uso do **Spring reactive web** para a realização de requisições assíncronas.

**benefícios desse projeto:**
- entender como funciona API's síncronas e assíncronas.
- estudo de diferentes ecossistemas Spring
- aprendizado com docker para empacotamento e build da aplicação, garantindo portabilidade e isolamento de ambiente.
- criação de um CRUD para fundamentar os conceitos de API rest
- leitura de documentação para entendimento do ecossistema implementado.
	>Spring reactive web. 
	Spring AI. 
- documentação com Swagger

**Tecnologias usadas:**
- java 21 (linguagem na qual o projeto foi desenvolvido)
- SpringBoot (framework principal)
- SpringAI (integração facilitada com módulos de inteligência artificial)
- Spring Reactive Web (chamadas assincronas)
- Spring web/Spring MVC (exposição de endpoints REST)
- Docker (empacotamento e execução em contêiner)
- Swagger (documentação da aplicação)
- H2 database (banco de dados para testes)
- FlyWay migrations (versionamento de DB)
