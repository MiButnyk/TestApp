package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.Console;
import java.util.Scanner;

@SpringBootApplication
public class TestApplication implements CommandLineRunner {

    private final Service service;
    private final Console console;


    @Autowired
    public TestApplication(Service service) {
        this.service = service;
        this.console = System.console();
    }

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(TestApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
        System.out.println("finish");
    }

    @Override
    public void run(String... args) {
        System.out.println("Greetings!");
        answer();
    }

    void answer() {
        System.out.println("If you want to know who is the head of a department, enter 1\n" +
                "If you want to see department statistics, enter 2\n" +
                "If you want to see the average salary for a department, enter 3\n" +
                "If you want to see the number of employees of a department, enter 4\n" +
                "If you want to do a global search, enter 5");
        int input = Integer.parseInt(console.readLine("Your input is: "));
//        Scanner in = new Scanner(System.in);
//        int input = in.nextInt();
        switch (input) {
            case 1:
                String str1 = console.readLine("Who is head of department ");
//                Scanner in2 = new Scanner(System.in);
//                String str1 = in2.nextLine();
                service.head(str1);
                break;
            case 2:
                System.out.print("Show statistics of department ");
                //String str2 = in.nextLine();
                //service.statistics(str2);
                break;
            case 3:
                System.out.print("Show the average salary for the department ");
                //String str3 = in.nextLine();
                //service.salary(str3);
                break;
            case 4:
                System.out.print("Show count of employee for department ");
                //String str4 = in.nextLine();
                //service.quantity(str4);
                break;
            case 5:
                System.out.print("Global search by ");
                //String str5 = in.nextLine();
                //service.search(str5);
                break;
            default:
                break;
        }
    }
}