package com.holddie.topic;

import java.util.concurrent.atomic.AtomicInteger;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

public class ActiveMQTopicServer {
	public static void main(String[] args) throws JMSException, InterruptedException {
		ActiveMQQueue queue = new ActiveMQQueue("test.topic");
		// 创建连接和会话
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		// 创建消费者
		MessageConsumer consumer = session.createConsumer(queue);
		AtomicInteger count = new AtomicInteger(0);
		MessageListener messageListener = message -> {
			try {
				System.out
						.println(count.incrementAndGet() + " => receive from " + queue.toString() + ": " + message);
				// 前面所有未被确认的消息全部确认
				message.acknowledge();
			}
			catch (JMSException e) {
				// 不要吞并异常
				e.printStackTrace();
			}
		};
		consumer.setMessageListener(messageListener);

		MessageProducer producer = session.createProducer(queue);
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
