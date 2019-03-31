# javaee7-project
Um projeto simples que visa exercitar os recursos disponíveis no Java EE 7. 
Não é uma solução e não possui regras de negócio. O foco é apenas exercitar o setup da criação do projeto e algumas das funcionalidades disponibilizadas pela especificação.

# ejb
Possui implementações de EJB's. Será utilizado por um projeto web cliente, o web-servlet-app.

# web-servlet-app
Possui servlet's que injetam os ejb's descritos acima. É exercitado o ciclo de vida dos servlet's juntamente com a injeção dos ejb's com a anotação @EJB. O CDI não é utilizado aqui.
Exemplos de url's para exercitar a execução do projeto:

http://localhost:8180/web-servlet-app/EjbClient?name=Usuario

http://localhost:8180/web-servlet-app/FormServlet

# web-jsp-servlet-app
Possui servlet's com jsp's. É exercitado a convivência entre jsp e servlet, como interagem entre si e se completam durante a execução.
Exemplos de url's para exercitar a execução do projeto:

http://localhost:8180/web-jsp-servlet-app/bean_usage.jsp?urlParam=teste

http://localhost:8180/web-jsp-servlet-app/form.jsp

http://localhost:8180/web-jsp-servlet-app/jsp_redirect.jsp?nome=Gustavo%20luca%20brandao&idade=123&peso=1111

# rest
Projeto restfull criado com a implementação RestEasy. Um webapp que expoe alguns endpoint's para exercitar os conceitos do rest.
Exemplo de url para exercitar a execução do projeto:

http://localhost:8180/rest/services/hello

# web-jsf-app
Uma aplicação para uma festa de aniversário. Utiliza JSF como solução. São exercitados a interação do front com o backend.

http://localhost:8180/web-jsf-app/party_index.xhtml



