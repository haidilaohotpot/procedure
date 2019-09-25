package cn.edu.mju.procedure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ProcedureApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProcedureApplication.class, args);
    }
    
}
