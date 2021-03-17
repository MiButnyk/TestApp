package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MyScanner {

    private final MyService service;
    private final Scanner in = new Scanner(System.in);

    @Autowired
    public MyScanner(MyService service) {
        this.service = service;
    }

    public void answer() {
        System.out.println("If you want to know who is the head of a department, enter 1\n" +
                "If you want to see department statistics, enter 2\n" +
                "If you want to see the average salary for a department, enter 3\n" +
                "If you want to see the number of employees of a department, enter 4\n" +
                "If you want to do a global search, enter 5\n" +
                "If you want to exit the application, enter 0");
        System.out.print("Your input is: ");
        int input = Integer.parseInt(in.nextLine());
        while (input != 0) {
            switch (input) {
                case 1:
                    System.out.print("Who is head of department ");
                    String str1 = nextLine();
                    service.head(str1);
                    break;
                case 2:
                    System.out.print("Show statistics of department ");
                    String str2 = nextLine();
                    service.statistics(str2);
                    break;
                case 3:
                    System.out.print("Show the average salary for the department ");
                    String str3 = nextLine();
                    service.salary(str3);
                    break;
                case 4:
                    System.out.print("Show count of employee for department ");
                    String str4 = nextLine();
                    service.quantity(str4);
                    break;
                case 5:
                    System.out.print("Global search by ");
                    String str5 = nextLine();
                    service.search(str5);
                    break;
                default:
                    break;
            }
            System.out.print("Your input is: ");
            input = Integer.parseInt(in.nextLine());
        }
    }

    private String nextLine() {
        if (in.hasNextLine()) {
            return in.nextLine();
        }
        System.err.println("The scanner can not read the next line");
        return null;
    }
}
