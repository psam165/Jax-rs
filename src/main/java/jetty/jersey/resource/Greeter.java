package jetty.jersey.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/Greet")
public class Greeter {
	
	@GET
	 @Produces("text/plain")
	public String simple(){
		
		return "Hello ...World!";
	}

}
