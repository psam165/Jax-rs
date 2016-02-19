package jetty.jersey.context;

import java.util.logging.LogManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;

public class JerseyLogListener implements ServletContextListener{
	
	Logger logger = LoggerFactory.getLogger(JerseyLogListener.class);

	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Servlet Context initialized,,,,");
		LogManager.getLogManager().reset();
		SLF4JBridgeHandler.install();
		
		logger.info("Context initialized and SLF4JBridge being used");
		
		
	}

}
