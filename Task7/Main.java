package Task7;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        UserRegistry registry = new UserRegistry();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1.Register");
            System.out.println("2.Login");
            System.out.println("3.Logout");
            System.out.println("4.Show all");
            System.out.println("5.Sort by name");
            System.out.println("6.Show logged users");
            System.out.println("0.Exit");

            int c = sc.nextInt();
            sc.nextLine();

            switch (c) {

                case 1:
                    System.out.print("Login:");
                    String l = sc.nextLine();
                    System.out.print("Pass:");
                    String p = sc.nextLine();
                    registry.registerUser(l, p);
                    break;

                case 2:
                    System.out.print("Login:");
                    l = sc.nextLine();
                    System.out.print("Pass:");
                    p = sc.nextLine();
                    registry.loginUser(l, p);
                    break;

                case 3:
                    System.out.print("ID:");
                    int id = sc.nextInt();
                    registry.logoutUser(id);
                    break;

                case 4:
                    registry.displayAllUsers();
                    break;

                case 5:
                    LinkedList<User> sorted =
                            registry.getInOrder(
                                    (a, b) ->
                                            a.getIdentifier().getUsername()
                                                    .compareTo(
                                                            b.getIdentifier().getUsername()
                                                    )
                            );

                    for (User u : sorted)
                        System.out.println(u);
                    break;

                case 6:
                    LinkedList<User> filtered =
                            registry.getFiltered(User::isLoggedIn);

                    for (User u : filtered)
                        System.out.println(u);
                    break;

                case 0:
                    return;
            }
        }
    }
}