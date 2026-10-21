package org.example.Student;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Students {
    private String name;
    private int rollNo;
}
