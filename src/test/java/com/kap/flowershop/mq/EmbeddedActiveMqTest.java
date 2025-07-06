package com.kap.flowershop.mq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.junit.EmbeddedActiveMQBroker;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.jms.core.JmsTemplate;
import org.zapodot.junit.jms.EmbeddedJmsRule;

import javax.jms.*;

import static org.junit.Assert.assertTrue;

public class EmbeddedActiveMqTest {

    private final String DESTINATION = "testRsQueue";
    private final String HEADER_NAME = "HEADER_WITH_FAULT";
    private final String FAULT_TEXT = "some fault";
    private final String MESSAGE_TEXT = "some message";

    @Rule
    public EmbeddedActiveMQBroker broker = new EmbeddedActiveMQBroker();

    @Rule
    public EmbeddedJmsRule embeddedJmsRule = EmbeddedJmsRule.builder().build();

    @Test
    public void checkJMSMessageHeaderWithConnection() throws JMSException {
        ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory("vm://localhost?broker.persistent=false");
        Connection connection = cf.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination destination = session.createQueue(DESTINATION);

        MessageProducer producer = session.createProducer(destination);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        Message sendingMessage = session.createMessage();
        sendingMessage.setStringProperty(HEADER_NAME, FAULT_TEXT);
        sendingMessage.setJMSDeliveryMode(1);

        producer.send(sendingMessage);

        MessageConsumer consumer = session.createConsumer(destination);
        Message message = consumer.receive(1000);

        consumer.close();
        session.close();
        connection.close();

        assertTrue(message.getStringProperty(HEADER_NAME).contains(FAULT_TEXT));
    }

    @Test
    public void checkJMSMessageHeaderWithBroker() throws JMSException {
        ActiveMQConnectionFactory cf = broker.createConnectionFactory();
        cf.setBrokerURL("vm://localhost");
        JmsTemplate jmsTemplate = new JmsTemplate(cf);
        jmsTemplate.setDefaultDestinationName(DESTINATION);

        broker.start();

        jmsTemplate.convertAndSend(DESTINATION, MESSAGE_TEXT, (mqMessage) -> {
            mqMessage.setStringProperty(HEADER_NAME, FAULT_TEXT);
            mqMessage.setJMSDeliveryMode(1);
            return mqMessage;
        });
        Message message = jmsTemplate.receive(DESTINATION);

        broker.stop();

        assertTrue(message.getStringProperty(HEADER_NAME).contains(FAULT_TEXT));
    }

    @Test
    public void checkJMSMessageHeader() throws JMSException {
        final ConnectionFactory cf = embeddedJmsRule.connectionFactory();
        JmsTemplate jmsTemplate = new JmsTemplate(cf);
        jmsTemplate.setDefaultDestinationName(DESTINATION);
        jmsTemplate.setDeliveryPersistent(false);

        jmsTemplate.convertAndSend(DESTINATION, MESSAGE_TEXT, (mqMessage) -> {
            mqMessage.setStringProperty(HEADER_NAME, FAULT_TEXT);
            mqMessage.setJMSDeliveryMode(1);
            return mqMessage;
        });
        Message message = jmsTemplate.receive(DESTINATION);

        assertTrue(message.getStringProperty(HEADER_NAME).contains(FAULT_TEXT));
    }
}
