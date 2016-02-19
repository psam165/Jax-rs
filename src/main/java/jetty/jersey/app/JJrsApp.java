package jetty.jersey.app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jetty.jersey.resource.Greeter;

//@ApplicationPath("/jetty-rs")
public class JJrsApp extends Application{

	private Logger logger = LoggerFactory.getLogger(JJrsApp.class);
	
	public Set<Class<?>>    getClasses(){
		logger.info("Starting application........JJrsApp");
		Set<Class<?>> set = new HashSet<Class<?>>();
		set.add(Greeter.class);
		for (Class<?> x : set){
			logger.info("Printing...{}",x);
		}
		return set;
	}
	
}
