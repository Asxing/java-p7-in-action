package com.holddie.queue;

import java.util.concurrent.atomic.AtomicInteger;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;

public class ActiveMQQueueServer {
	public static void main(String[] args) throws JMSException, InterruptedException {
		ActiveMQTopic topic = new ActiveMQTopic("test.topic");
		// 创建连接和会话
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		// 创建消费者
		MessageConsumer consumer = session.createConsumer(topic);
		AtomicInteger count = new AtomicInteger(0);
		MessageListener messageListener = message -> {
			try {
				System.out
						.println(count.incrementAndGet() + " => receive from " + topic.toString() + ": " + message);
				// 前面所有未被确认的消息全部确认
				message.acknowledge();
			}
			catch (JMSException e) {
				// 不要吞并异常
				e.printStackTrace();
			}
		};
		consumer.setMessageListener(messageListener);

		MessageProducer producer = session.createProducer(topic);
		int index = 0;
		while (index++ < 100) {
			TextMessage textMessage = session.createTextMessage(index + " message");
			producer.send(textMessage);
		}
		Thread.sleep(2000);
		session.close();
		connection.close();
	}

}
