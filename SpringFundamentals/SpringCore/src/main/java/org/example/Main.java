package org.example;

import org.example.Configuration.Config;
import org.example.School.School;
import org.example.notification.WhatsappNotification;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        ApplicationContext app = new AnnotationConfigApplicationContext(Config.class);
//        School sch = app.getBean(School.class);
        WhatsappNotification not = app.getBean(WhatsappNotification.class);
        System.out.println(not.hashCode());
        not.notification();
//        sch.studentName();
    }
}
