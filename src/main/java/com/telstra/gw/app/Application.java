package com.telstra.gw.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.JmsListenerEndpointRegistry;
import org.springframework.web.client.RestTemplate;

import com.telstra.gw.parser1.JAXbXPath;

/**
 * Created by orcilia on 21/03/2018.
 */
@EnableJms
@SpringBootApplication
@ComponentScan(basePackages = "com.telstra.gw")
public class Application extends Exception {
	
	/*  static {
		    new Thread(() -> {

		    	Server server = new Server(8080);
		      ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		      context.setContextPath("/");
		      server.setHandler(context);

		      try {
		        server.start();
		        server.join();
		      } catch (Exception e) {
		        e.printStackTrace();
		      }
		    }).start();
		  }*/

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
    
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static  void  main(String args[]) {
       AnnotationConfigApplicationContext
                context = new AnnotationConfigApplicationContext(Application.class);
      /*  String message = "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" + 
        		"    <SOAP-ENV:Header>\n" + 
        		"        <v1:Header xmlns:v1=\"http://www.telstra.com/schemas/soap/header/v1/\">\n" + 
        		"            <v1:transactionID>NotApplicable</v1:transactionID>\n" + 
        		"            <v1:transactionName>requestSingleSiteQualification</v1:transactionName>\n" + 
        		"            <v1:sourceSystem>ISL-FUL_MSQ</v1:sourceSystem>\n" + 
        		"            <v1:targetSystem>B2BGW-NBN</v1:targetSystem>\n" + 
        		"            <v1:serviceVersion>12.0</v1:serviceVersion>\n" + 
        		"            <v1:timestamp>2013-08-08T09:51:07.454Z</v1:timestamp>\n" + 
        		"        </v1:Header>\n" + 
        		"    </SOAP-ENV:Header>\n" + 
        		"   <SOAP-ENV:Body>\n" + 
        		"    <dns:ManageServiceQualificationRequest  xmlns:dns=\"http://www.nbnco.com.au/cim/manageServiceQualification/v4\" xmlns:ase=\"http://www.nbnco.com.au/cim/common/accessSeeker/v3\" xmlns:bin=\"http://www.nbnco.com.au/cim/common/businessInteraction/v4\"  xmlns:msg=\"http://www.nbnco.com.au/cim/common/message/v4\" xmlns:pla=\"http://www.nbnco.com.au/cim/common/place/v3\" xmlns:pfm=\"http://www.nbnco.com.au/cim/common/performance/v3\" xmlns:prd=\"http://www.nbnco.com.au/cim/common/product/v4\" xmlns:prj=\"http://www.nbnco.com.au/cim/common/project/v4\" xmlns:pty=\"http://www.nbnco.com.au/cim/common/party/v3\" xmlns:rbe=\"http://www.nbnco.com.au/cim/common/rootBusinessEntity/v3\" xmlns:res=\"http://www.nbnco.com.au/cim/common/resource/v3\" xmlns:srv=\"http://www.nbnco.com.au/cim/common/service/v3\" xmlns:tme=\"http://www.nbnco.com.au/cim/common/time/v4\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" + 
        		"            <serviceQualificationType>ServiceQualification</serviceQualificationType>\n" + 
        		"                <ServiceQualification>\n" + 
        		"                    <ServiceQualificationComprisedOf>\n" + 
        		"                        <ItemInvolvesLocation>\n" + 
        		"                            <Place xsi:type=\"pla:GNAF\">\n" + 
        		"                                <latitude>-18</latitude>\n" + 
        		"                                <longitude>102</longitude>\n" + 
        		"                            </Place>\n" + 
        		"                        </ItemInvolvesLocation>\n" + 
        		"                    <type>SpatialGeocode</type>\n" + 
        		"                    </ServiceQualificationComprisedOf>\n" + 
        		"                </ServiceQualification>\n" + 
        		"    </dns:ManageServiceQualificationRequest>\n" + 
        		"   </SOAP-ENV:Body>\n" +  
        		"</SOAP-ENV:Envelope>";
        
        
        new JAXbXPath().parse(message, null);
*/      
       SpringApplication.run(Application.class, args);
       JmsListenerEndpointRegistry
                bean = context.getBean(JmsListenerEndpointRegistry.class);

        /*Runtime.getRuntime().addShutdownHook(new Thread()
        {
            public void run()
            {
                System.out.println("Shutdown Hook is running !");
                for (MessageListenerContainer listenerContainer : bean.getListenerContainers()) {
                    DefaultMessageListenerContainer container = (DefaultMessageListenerContainer) listenerContainer;
                    container.shutdown();
                }
            }
        });*/


    }
}
