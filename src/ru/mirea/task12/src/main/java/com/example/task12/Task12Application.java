package com.example.task12;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Task12Application implements CommandLineRunner {

    public static void main(String[] args) {
        System.out.println(Arrays.asList(args));
        SpringApplication.run(Task12Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //--in=D:\University\4_semestr\SHPPNYAD\JavaPatternMirea\src\ru\mirea\task12\src\data.txt
        //--out=D:\University\4_semestr\SHPPNYAD\JavaPatternMirea\src\ru\mirea\task12\src\hashed.txt
    }
}
