# javaee7-project
Um projeto simples que visa exercitar os recursos disponíveis no Java EE 7. 
Não é uma solução e não possui regras de negócio. O foco é apenas exercitar o setup da criação do projeto e algumas das funcionalidades disponibilizadas pela especificação.


## ejb
Possui implementações de EJB's. Será utilizado por um projeto web cliente, o web-servlet-app.


## web-servlet-app
Possui servlet's que injetam os ejb's descritos acima. É exercitado o ciclo de vida dos servlet's juntamente com a injeção dos ejb's com a anotação @EJB. O CDI não é utilizado aqui.
Exemplos de url's para exercitar a execução do projeto:

```
http://localhost:8180/web-servlet-app/EjbClient?name=Usuario
http://localhost:8180/web-servlet-app/FormServlet
```

## web-jsp-servlet-app
Possui servlet's com jsp's. É exercitado a convivência entre jsp e servlet, como interagem entre si e se completam durante a execução.
Exemplos de url's para exercitar a execução do projeto:

```
http://localhost:8180/web-jsp-servlet-app/bean_usage.jsp?urlParam=teste
http://localhost:8180/web-jsp-servlet-app/form.jsp
http://localhost:8180/web-jsp-servlet-app/jsp_redirect.jsp?nome=Gustavo%20luca%20brandao&idade=123&peso=1111
```

## rest
Projeto restfull criado com a implementação RestEasy. Um webapp que expoe alguns endpoint's para exercitar os conceitos do rest.
Exemplo de url para exercitar a execução do projeto:

```
http://localhost:8180/rest/services/hello
```

## web-jsf-app
Uma aplicação para uma festa de aniversário. Utiliza JSF como solução. São exercitados a interação do front com o backend.
Exemplo de url para exercitar a execução do projeto:

```
http://localhost:8180/web-jsf-app/party_index.xhtml
```

## websocket-app
Uma aplicação para chat entre clientes. Exercita o funcionamento de websocket's (cliente x servidor)
Exemplo de url para exercitar a execução do projeto:

```
http://localhost:8180/websocket-app/index_chat.html
```

## webfilter-app
Exercita a execução de webfilters.

URL para ver o resultado da execução de um webfilter:
```
http://localhost:8180/webfilter-app/index.xhtml?shouldApplyFilter=true
```

URL onde o webfilter é chamado, porém não atua na resposta:
```
http://localhost:8180/webfilter-app/index.xhtml?shouldApplyFilter=false
```

## security-app
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
http://localhost:8180/security-app/index.xhtml
http://localhost:8180/security-app/admin.xhtml
http://localhost:8180/security-app/error.xhtml
http://localhost:8180/security-app/login.xhtml
```

onde cada página requer um tipo de permissão, conforme definido no arquivo web.xml.

## jpa
Uma simples aplicação que (re)cria as tabelas automaticamente no startup da aplicação e popula com alguns dados default através de um Singleton Session Bean (EJB).

Setup antes de realizar o deploy:

- Ter o mysql instalado 
- Criar uma base chamada "testejavaee7"
- Criar o diretório "wildfly-12.0.0.Final\modules\system\layers\base\com\mysql\main" no wildfly e, em seguida:
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
- Editar o arquivo wildfly-12.0.0.Final\standalone\configuration\standalone.xml na seção "datasources", inserir:
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

