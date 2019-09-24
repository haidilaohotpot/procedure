package cn.edu.mju.procedure;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@MapperScan(basePackages = "cn.edu.mju.procedure.mapper")
public class ProcedureApplication {

    public static void main(String[] args) {

        new SpringApplicationBuilder(ProcedureApplication.class).run(args);

    }

}
