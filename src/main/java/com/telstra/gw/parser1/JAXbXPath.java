package com.telstra.gw.parser1;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.telstra.gw.models.Book;
import com.telstra.gw.models.LocationID;

import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.xml.bind.*;
import java.io.StringReader;

/**
 * Created by abhishek.vangala on 3/22/2018.
 */
@Component
public class JAXbXPath {

    //private final Logger logger = LoggerFactory.getLogger(JAXbXPath.class);
    public void parse(String message) { // XML Message Object
        try {
            System.setProperty("javax.xml.bind.context.factory", "org.eclipse.persistence.jaxb.JAXBContextFactory");

            JAXBContext jaxbContext = JAXBContext.newInstance(LocationID.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(message);
            Object book =  unmarshaller.unmarshal(reader);

            // If there is no change in Names then we can directly parse
            // the XML without any intervention then below would work
            /*Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
            marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, false);
            marshaller.marshal(book,System.out);*/

            // To specify the field name as required , we follow below approach.
            Gson gson = new Gson();
            JsonObject object = gson.toJsonTree(book).getAsJsonObject();
            System.out.println("Converted using GSON "+object.toString());
        }catch(JAXBException e){
            //System.out.println(e.getStackTrace());
            e.printStackTrace();
        }
        finally {
            // Release the objects
        }

    }
}
