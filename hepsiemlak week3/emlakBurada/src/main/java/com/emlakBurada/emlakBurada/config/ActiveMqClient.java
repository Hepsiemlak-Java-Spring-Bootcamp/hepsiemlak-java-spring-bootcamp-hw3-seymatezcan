package com.emlakBurada.emlakBurada.config;

import lombok.Data;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Configuration;

import javax.jms.*;

@Data
@Configuration
public class ActiveMqClient {

 private static String url= ActiveMQConnection.DEFAULT_BROKER_URL;
 private static String subject="emlakburadaQueue";

 public static void main(String[] args) throws JMSException{

     ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
     Connection connection = connectionFactory.createConnection();
     connection.start();

     Session session = connection.createSession(false,
             Session.AUTO_ACKNOWLEDGE);

     Destination destination = session.createQueue(subject);
     MessageProducer producer = session.createProducer(destination);

     TextMessage message = session
             .createTextMessage("Email message");
     producer.send(message);
     System.out.println("JCG printing@@ '" + message.getText() + "'");
     connection.close();

    }
}
