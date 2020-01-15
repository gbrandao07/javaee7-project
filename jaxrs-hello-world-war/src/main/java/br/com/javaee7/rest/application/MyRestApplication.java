package br.com.javaee7.rest.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import br.com.javaee7.rest.endpoint.HelloEndpoint;

/**
 * Classe que indica ao servidor quais classes serao expostas como servicos rest.
 * 
 * Criado com base no tutorial: https://www.baeldung.com/resteasy-tutorial.
 * 
 * Considerar a partir do item 2.2 JBoss AS Setup.
 * 
 * @author gustavo
 *
 */
@ApplicationPath("/services")
public class MyRestApplication extends Application {

}
