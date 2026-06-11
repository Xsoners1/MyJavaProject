package Practychna12;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1 - generate log file");
        System.out.println("2 - filter log file");

        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {

            System.out.print("Enter log file name: ");
            String file = sc.nextLine();

            LogGenerator.generate(file);
        }

        if (choice == 2) {

            System.out.print("Source file: ");
            String source = sc.nextLine();

            System.out.print("Target file: ");
            String target = sc.nextLine();

            System.out.println("Choose level:");
            System.out.println("CRITICAL / ERROR / WARNING / INFO / DEBUG");

            String lvl = sc.nextLine();

            LogLevel level =
                    LogLevel.valueOf(lvl.toUpperCase());

            LogFilter filter = new SevereLogFilter();
            filter.filter(source, target, level);
        }
    }
}