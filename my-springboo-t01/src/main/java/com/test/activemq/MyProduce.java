package com.test.activemq;

public class MyProduce {
//    //链接url
//    private static final String ACTIVEMQ_URL = "tcp://192.168.59.128:61616";
//    //目标队列名称;
//    private static final String QUEUE_NAME = "myDeque";
//
//    public static void main(String[] args) throws JMSException {
//        //1.按照自己的链接,创建连接的工厂;
//        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
//
//        //2.通过工厂创建链接;-->开启;
//        Connection connection = activeMQConnectionFactory.createConnection();
//        connection.start();
//        //3.创建会话; 参数:  事务, 签收机制;
//        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//        //4.创建目的地;例如:队列
//        Destination destination = session.createQueue(QUEUE_NAME);
//        //5.创建消息生产者;
//        MessageProducer producer = session.createProducer(destination);
//        //生产6条消息存入到MQ中间件的队列中;
//        for (int i = 0; i <= 5; i++) {
//            //表名是第几条消息;
//            TextMessage textMessage = session.createTextMessage("this is the" + i + "message");
//            producer.send(textMessage);
//        }
//        //关闭资源;
//        producer.close();
//        session.close();
//        connection.close();
//
//        System.out.println("+-+-+-+-+-+-+-+-+-+我把消息都发给中间大佬MQ了");
//    }
}
