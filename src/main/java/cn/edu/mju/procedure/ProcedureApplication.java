package cn.edu.mju.procedure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ProcedureApplication {

    public static void main(String[] args) {

        new SpringApplicationBuilder(ProcedureApplication.class).run(args);

    }

}
