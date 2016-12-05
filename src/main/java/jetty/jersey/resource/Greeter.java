package jetty.jersey.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/Greet")
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

	@POST
	public Response insertGreet(String body){
		System.out.println(body);
		
		return Response.ok().build();
	}
	
}
