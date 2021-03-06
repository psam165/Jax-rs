package jetty.jersey.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import io.swagger.annotations.Api;

@Path("/Greet")
@Api(value="/Greet", produces="text/plain")
public class Greeter {
	
	@GET
	@Produces("text/plain")
	public String simple(){
		
		return "Hello ...World!";
	}
	
	@GET
	@Produces("text/plain")
	@Path("/{fname}")
	public String greetByName(@PathParam(value = "fname") String param){
		return "Hello .."+param;
	}

}
