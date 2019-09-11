package cn.tcmp.six;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.tcmp.six.mapper")
public class BugProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BugProviderApplication.class, args);
    }

}
