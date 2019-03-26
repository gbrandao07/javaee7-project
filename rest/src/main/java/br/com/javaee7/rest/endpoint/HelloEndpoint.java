package br.com.javaee7.rest.endpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.javaee7.rest.endpoint.model.Person;

/**
 * Rest endpoint para exemplo 
 *  
 * @author gustavo
 *
 */
@Path("/hello")
public class HelloEndpoint {

//	@GET
//	public String getStrHelloMessage() {
//		return "HelloUser";
//	}
	
	/* 
	 * http://localhost:8180/rest/services/hello
	 * 
	 * {
	 *		"name": "Gustavo"
	 * }
	 * 
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStrHelloMessage() {
		GenericEntity<Person> myEntity = new GenericEntity<Person>(new Person("Gustavo")) {};
		return Response.status(200).entity(myEntity).build();
	}
}
