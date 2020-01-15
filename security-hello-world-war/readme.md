Declarative Security Model!!!

- Colocar as informacoes de seguranca no arquivo web.xml
- Os usuarios/perfil sao cadastrados no proprio wildfly atraves do script add-user.bat
- Os usuarios ficam gravados em: 
	standalone\configuration\application-users.properties
- O mapeamento usuario/role fica em:
	standalone\configuration\application-roles.properties
	