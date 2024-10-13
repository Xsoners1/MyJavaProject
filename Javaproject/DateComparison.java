package Javaproject;

import java.util.Scanner;

public class DateComparison {

    static class Date {
        int day;
        int month;
        int year;

        Date(int day, int month, int year) {
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть першу дату (день.місяць.рік): ");
        String[] firstDateParts = scanner.nextLine().split("\\.");
        int day1 = Integer.parseInt(firstDateParts[0]);
        int month1 = Integer.parseInt(firstDateParts[1]);
        int year1 = Integer.parseInt(firstDateParts[2]);
        Date date1 = new Date(day1, month1, year1);

        System.out.print("Введіть другу дату (день.місяць.рік): ");
        String[] secondDateParts = scanner.nextLine().split("\\.");
        int day2 = Integer.parseInt(secondDateParts[0]);
        int month2 = Integer.parseInt(secondDateParts[1]);
        int year2 = Integer.parseInt(secondDateParts[2]);
        Date date2 = new Date(day2, month2, year2);

        if (date1.year < date2.year) {
            System.out.println("Перша дата раніша.");
        } else if (date1.year > date2.year) {
            System.out.println("Друга дата раніша.");
        } else {
            if (date1.month < date2.month) {
                System.out.println("Перша дата раніша.");
            } else if (date1.month > date2.month) {
                System.out.println("Друга дата раніша.");
            } else {
                if (date1.day < date2.day) {
                    System.out.println("Перша дата раніша.");
                } else if (date1.day > date2.day) {
                    System.out.println("Друга дата раніша.");
                } else {
                    System.out.println("Дати однакові.");
                }
            }
        }

        scanner.close();
    }
}
