package com.telstra.gw.app;

import org.apache.activemq.ActiveMQConnectionFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerEndpointRegistry;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;

import javax.jms.ConnectionFactory;

/**
 * Created by orcilia on 21/03/2018.
 */
@EnableJms
@SpringBootApplication
@ComponentScan(basePackages = "com.telstra.gw")
public class Application {

  //  private final Logger logger = LoggerFactory.getLogger(Application.class);
  /*  @Bean public ConnectionFactory connectionFactory(){
        ConnectionFactory connectionFactory1 = new ActiveMQConnectionFactory("admin","admin","tcp://localhost:61616");
        return connectionFactory1;
    }

    @Bean
    public JmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory =
                new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        //core poll size=4 threads and max poll size 8 threads
        return factory;
    }
*/
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfiguration(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    public static  void  main(String args[]) {
        AnnotationConfigApplicationContext
                context = new AnnotationConfigApplicationContext(Application.class);
        JmsListenerEndpointRegistry
                bean = context.getBean(JmsListenerEndpointRegistry.class);


        SpringApplication.run(Application.class, args);

        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            public void run()
            {
                System.out.println("Shutdown Hook is running !");
                for (MessageListenerContainer listenerContainer : bean.getListenerContainers()) {
                        DefaultMessageListenerContainer container = (DefaultMessageListenerContainer) listenerContainer;
                        container.shutdown();
                    }
            }
        });


    }
}
