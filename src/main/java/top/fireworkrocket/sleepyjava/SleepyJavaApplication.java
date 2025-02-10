package top.fireworkrocket.sleepyjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import static top.fireworkrocket.sleepyjava.default_config.ConfigReader.initProp;

@SpringBootApplication
public class SleepyJavaApplication {

    public static void main(String[] args) {
        initProp();
        SpringApplication.run(SleepyJavaApplication.class, args);
    }

}