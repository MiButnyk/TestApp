package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestApplication implements CommandLineRunner {

    private final MyScanner myScanner;

    @Autowired
    public TestApplication(MyScanner myScanner) {
        this.myScanner = myScanner;
    }

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(TestApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Greetings!");
        myScanner.answer();
        System.out.println("Goodbye!");
    }
}