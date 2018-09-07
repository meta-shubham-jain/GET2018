package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(
                AppConfig.class);
        JavaCollection collection = (JavaCollection) context
                .getBean("javaCollection");

        System.out.println(collection.getAddressList());
        System.out.println(collection.getAddressSet());
        System.out.println(collection.getAddressMap());
    }
}