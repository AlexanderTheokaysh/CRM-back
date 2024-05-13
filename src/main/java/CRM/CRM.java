package CRM;

import CRM.config.FileConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(FileConfig.class)
public class CRM {

    public static void main(String[] args) {
        SpringApplication.run(CRM.class, args);
    }
}
