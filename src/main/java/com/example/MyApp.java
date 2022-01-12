package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        MessageService messageService = applicationContext.getBean("messageService", MessageService.class);
        MessageService secondMessageService = applicationContext.getBean("randomMessageService", MessageService.class);
        System.out.println("First bean hash: " + messageService.hashCode());
        System.out.println("second bean hash: " + secondMessageService.hashCode());
        boolean hashCompared = messageService.hashCode() == secondMessageService.hashCode();
        System.out.println("Are they identical: " + hashCompared);


        System.out.println("message service bean: " + messageService.getMessage());
        System.out.println("random message service bean: " + secondMessageService.getMessage());

        applicationContext.close();

        System.out.println("from java file");

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MessageServiceConfig.class);

        messageService = ctx.getBean(RandomTextMessageService.class);
        secondMessageService = ctx.getBean(RandomTextMessageService.class);
        System.out.println("First bean hash: " + messageService.hashCode());
        System.out.println("second bean hash: " + secondMessageService.hashCode());
        hashCompared = messageService.hashCode() == secondMessageService.hashCode();
        System.out.println("Are they identical: " + hashCompared);
        System.out.println("random message service bean: " + messageService.getMessage());
        System.out.println("random message service bean: " + secondMessageService.getMessage());
        MessageService nameMessageService = ctx.getBean(MyNameMessageService.class);
        System.out.println("name message service bean: " + nameMessageService.getMessage());


        ctx.close();


    }
}
