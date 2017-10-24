package resources;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entites.User;
import iservices.IUserService;
@RequestScoped
@Path(value = "secure")

public class Authentification {
	
	@EJB
	IUserService userService; 
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response authentificate(User us) {
		String username = us.getEmail();
		if (userService.login(us) == false)
			{return Response.status(404).build();}
		 String token = issueToken(username);
		 return Response.ok(token).header("Authorization",token).build();
	}
	
	
    private String issueToken(String login) {
    	Random random = new SecureRandom();
    	String token = new BigInteger(130, random).toString(32);
    	return "Bearer "+ token ;
    } 
}
