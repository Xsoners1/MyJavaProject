package Task7;

public class Main {
    public static void main(String[] args) {

        try {
            MyLinkedList<Integer> intList = new MyLinkedList<>(0);
            intList.addLast(10);
            intList.addLast(20);
            intList.print();

            MyLinkedList<String> strList = new MyLinkedList<>(0);
            strList.addLast("Hello");
            strList.addLast("World");
            strList.print();

            MyLinkedList<Double> doubleList = new MyLinkedList<>(0);
            doubleList.addLast(1.5);
            doubleList.addLast(2.7);
            doubleList.print();

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}