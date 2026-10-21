package org.example.notification;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class WhatsappNotification {
    public void notification(){
        System.out.println("Inside WhatsappNotification");
    }
}
