# javaee7-project

Registro dos meus estudos para a obtenção da certificação Oracle Java EE 7 Application Developer (exame 1Z0-900).
Link> https://www.youracclaim.com/badges/80016888-2577-4745-98da-4b54cf8085c2/
Deixo o projeto disponível a quem possa interessar em aprendar mais sobre a especificação.

Pré-requisitos:
JDK8 ou superior
Wildfly 15 ou superior
Maven 3 ou superior


Um projeto simples que visa exercitar os recursos disponíveis no Java EE 7. 
Não é uma solução e não possui regras de negócio. O foco é apenas exercitar o setup da criação do projeto e algumas das funcionalidades disponibilizadas pela especificação.


## ejb-hello-world
Possui implementações de EJB's. Será utilizado por um projeto web cliente, o web-servlet-app.


## servlet-hello-world-war
Possui servlet's que injetam os ejb's descritos acima. É exercitado o ciclo de vida dos servlet's juntamente com a injeção dos ejb's com a anotação @EJB. O CDI não é utilizado aqui.
Exemplos de url's para exercitar a execução do projeto:

```
http://localhost:8X80/servlet-hello-world-war/EjbClient?name=Usuario
http://localhost:8X80/servlet-hello-world-war/FormServlet
```

## jsp-servlet-hello-world-war
Possui servlet's com jsp's. É exercitado a convivência entre jsp e servlet, como interagem entre si e se completam durante a execução.
Exemplos de url's para exercitar a execução do projeto:

```
http://localhost:8X80/jsp-servlet-hello-world-war/bean_usage.jsp?urlParam=teste
http://localhost:8X80/jsp-servlet-hello-world-war/form.jsp
http://localhost:8X80/jsp-servlet-hello-world-war/jsp_redirect.jsp?nome=Gustavo%20luca%20brandao&idade=123&peso=1111
```

## jaxrs-hello-world-war
Projeto restfull criado com a implementação RestEasy. Um webapp que expoe alguns endpoint's para exercitar os conceitos do rest.
Exemplo de url para exercitar a execução do projeto:

```
http://localhost:8X80/jaxrs-hello-world-war/services/hello
```

## jsf-hello-world-war
Uma aplicação para uma festa de aniversário. Utiliza JSF como solução. São exercitados a interação do front com o backend.
Exemplo de url para exercitar a execução do projeto:

```
http://localhost:8X80/jsf-hello-world-war/party_index.xhtml
```

## websocket-hello-world-war
Uma aplicação para chat entre clientes. Exercita o funcionamento de websocket's (cliente x servidor)
Exemplo de url para exercitar a execução do projeto:

```
http://localhost:8X80/websocket-hello-world-war/index_chat.html
```

## webfilter-hello-world-war
Exercita a execução de webfilters.

URL para ver o resultado da execução de um webfilter:
```
http://localhost:8X80/webfilter-hello-world-war/index.xhtml?shouldApplyFilter=true
```

URL onde o webfilter é chamado, porém não atua na resposta:
```
http://localhost:8X80/webfilter-hello-world-war/index.xhtml?shouldApplyFilter=false
```

## security-hello-world-war
Um projeto que exercita o recurso de Declarative Security Model do Java EE 7. 
Há algumas páginas xhtml com diferentes níveis de acesso. Um login é requerido para acessar as páginas e baseado na permissão do usuário logado a permissão de acesso é concedida ou não.

Orientações:
- Colocar as informacoes de seguranca no arquivo web.xml
- Os usuarios/perfil sao cadastrados no proprio wildfly atraves do script add-user.bat
- Os usuarios ficam gravados em: 
	```
	standalone\configuration\application-users.properties
	```
- O mapeamento usuario/role fica em:
	```
	standalone\configuration\application-roles.properties
	```
	
URL's disponíveis:

```
http://localhost:8X80/security-hello-world-war/index.xhtml
http://localhost:8X80/security-hello-world-war/admin.xhtml
http://localhost:8X80/security-hello-world-war/error.xhtml
http://localhost:8X80/security-hello-world-war/login.xhtml
```

onde cada página requer um tipo de permissão, conforme definido no arquivo web.xml.

## jpa-hello-world-ejb
Uma simples aplicação que (re)cria as tabelas automaticamente no startup da aplicação e popula com alguns dados default através de um Singleton Session Bean (EJB).

Setup antes de realizar o deploy:

- Ter o mysql instalado 
- Criar uma base chamada "testejavaee7"
- Criar o diretório "wildfly-1X.0.0.Final\modules\system\layers\base\com\mysql\main" no wildfly e, em seguida:
  - Criar o arquivo module.xml com o conteúdo:
    ```
    <?xml version="1.0" encoding="UTF-8"?>
    <module xmlns="urn:jboss:module:1.1" name="com.mysql">
	    <resources>
		    <resource-root path="mysql-connector-java-5.1.42.jar"/>
	    </resources>
	    <dependencies>
		    <module name="javax.api"/>
		    <module name="javax.transaction.api"/>
		    <module name="javax.servlet.api" optional="true"/>
	    </dependencies>
    </module>
    ```
  - Colar o jar do driver "mysql-connector-java-5.1.42.jar"
- Editar o arquivo wildfly\standalone\configuration\standalone.xml na seção "datasources", inserir:
  ```
  <datasource jta="true" jndi-name="java:jboss/datasources/testejavaee7-ds" pool-name="testejavaee7" enabled="true" use-java-context="true" spy="true" use-ccm="true">
      <connection-url>jdbc:mysql://localhost:3306/testejavaee7</connection-url>
      <driver>mysql</driver>
      <transaction-isolation>TRANSACTION_READ_COMMITTED</transaction-isolation>
      <pool>
          <min-pool-size>10</min-pool-size>
          <max-pool-size>100</max-pool-size>
          <prefill>true</prefill>
      </pool>
      <security>
          <user-name>root</user-name>
          <password>123456</password>
      </security>
      <statement>
          <prepared-statement-cache-size>32</prepared-statement-cache-size>
          <share-prepared-statements>true</share-prepared-statements>
      </statement>
  </datasource>
  ```
  E na seção drivers:
  ```
  <driver name="mysql" module="com.mysql">
      <xa-datasource-class>com.mysql.jdbc.jdbc2.optional.MysqlXADataSource</xa-datasource-class>
  </driver>
  ```
  Referência: https://lucasmarques.me/mysql-wildfly-datasource/

## cdi-hello-world-war
Um webapp que exercita a injeção de dependências com o CDI.

URL para ver o resultado da execução do projeto:
```
http://localhost:8X80/cdi-hello-world-war/GoldilocksServlet
```

## concurrency-hello-world-war
Um webapp que exercita a Concurrency API.

Utiliza um ManagedExecutorService provido pelo container e dispara algumas tasks para submissão.

Utiliza CDI para encapsular em um produtor o lookup do ManagedExecutorService.

O resultado da submissão é exibido no console do servidor de aplicação. Exemplo:

```
2019-09-04 19:34:35,425 INFO  [stdout] (EE-ManagedExecutorService-default-Thread-7) Executando callable 1 na thread: EE-ManagedExecutorService-default-Thread-7

2019-09-04 19:34:35,431 INFO  [stdout] (EE-ManagedExecutorService-default-Thread-8) Executando callable 2 na thread: EE-ManagedExecutorService-default-Thread-8

2019-09-04 19:34:35,435 INFO  [stdout] (EE-ManagedExecutorService-default-Thread-2) Executando callable 3 na thread: EE-ManagedExecutorService-default-Thread-2

2019-09-04 19:34:35,440 INFO  [stdout] (default task-1) Sucesso no callable 1

2019-09-04 19:34:35,441 INFO  [stdout] (default task-1) Sucesso no callable 2

2019-09-04 19:34:35,444 INFO  [stdout] (default task-1) Sucesso no callable 3

```

URL para ver o resultado da execução do projeto:
```
http://localhost:8X80/concurrency-hello-world-war/task
```

## jms-hello-world-war
Um webapp para exercitar a especificação JMS (parte de produtor) e EJB (MessageDriven beans).

A partir de uma requisição get a partir de uma servlet, uma mensagem é disparada a uma fila. A mensagem, por sua vez, é consumida por um MessageDriven bean e logada no console. Exemplo:

```
20:30:19,044 INFO  [stdout] (Thread-0 (ActiveMQ-client-global-threads)) Mensagem recebida: SUA_MENSAGEM_AQUI
```

As filas e factories JMS devem ser criadas e configuradas no servidor de aplicação.
Tutorial para o Wildfly: https://gianlucacosta.info/blog/wildfly-jms-tutorial

Dica: caso não queira seguir o tutorial configurando pelo console, é possível executar pela linha de comando:

- wildfly\bin\jbosscli.bat
- connect 
- Criar fila: jms-queue add --queue-address=myQueue --entries=java:/queue/myQueue
- Criar a factory: /subsystem=messaging-activemq/server=default/connection-factory=MyConnectionFactory:add(entries=[java:/myJmsTest/MyConnectionFactory],connectors=[in-vm])


Após a configuração ter sido realizada, efetuar o deploy da aplicação no modo standalone-full:

```
standalone.bat -c standalone-full.xml
```

URL para disparar mensagens:
```
http://localhost:8X80/jms-hello-world-war/producer?message=SUA_MENSAGEM_AQUI
```

## batch-hello-world-war
Um webapp para exercitar a nova Batch API do Java EE 7.

URL para disparar um novo job:
```
http://localhost:8X80/batch-hello-world-war/batch
```

Após a requisição, ir verificando no console o progresso do job. Ao final será impressa uma página http com as informações da execução.
