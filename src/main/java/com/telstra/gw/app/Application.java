package com.telstra.gw.app;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.JmsListenerEndpointRegistry;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Nikhil,Bhavana,Jayaram on 29/04/2018.
 */
@EnableJms
@SpringBootApplication
@ComponentScan(basePackages = "com.telstra.gw")
public class Application extends Exception {
	
	private static final Logger logger = Logger.getLogger(Application.class);
	
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfiguration(){
        return new PropertySourcesPlaceholderConfigurer();
    }
    
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static  void  main(String args[]) {
    			    	 
       AnnotationConfigApplicationContext
                context = new AnnotationConfigApplicationContext(Application.class);
      
       SpringApplication.run(Application.class, args);
       JmsListenerEndpointRegistry
                bean = context.getBean(JmsListenerEndpointRegistry.class);
       
       Runtime.getRuntime().addShutdownHook(new Thread()
       {
           public void run()
           {
               logger.info("Shutdown Hook is running !");
               for (MessageListenerContainer listenerContainer : bean.getListenerContainers()) {
                       DefaultMessageListenerContainer container = (DefaultMessageListenerContainer) listenerContainer;
                       container.shutdown();
                   }
           }
       });

       
    }
}
