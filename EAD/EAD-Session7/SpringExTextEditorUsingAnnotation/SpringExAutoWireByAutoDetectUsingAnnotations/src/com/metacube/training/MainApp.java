package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String args[]) {

        @SuppressWarnings("resource")
        ApplicationContext context = new AnnotationConfigApplicationContext(
                AppConfig.class);

        TextEditor textEditor = (TextEditor) context.getBean(TextEditor.class);
        textEditor.spellCheck();
    }
}
