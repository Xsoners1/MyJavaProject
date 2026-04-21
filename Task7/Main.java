package Task7;

public class Main {
    public static void main(String[] args) {

        try {
            MyLinkedList<Student> list = new MyLinkedList<>(0);

            list.addLast(new Student("Vova", 20));
            list.addLast(new Student("Alex", 18));
            list.addLast(new Student("Max", 22));

            System.out.println("До сортировки:");
            list.print();

            list.sort();
            System.out.println("После sort() (по возрасту):");
            list.print();

            list.sort(new StudentNameComparator());
            System.out.println("После sort(Comparator) (по имени):");
            list.print();

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}