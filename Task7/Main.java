package Task7;

public class Main {
    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList();

        list.addLast(10);
        list.addLast(20);
        list.addFirst(5);
        list.add(1, 15);

        System.out.print("Список: ");
        list.print();

        System.out.println("Элемент по индексу 2: " + list.get(2));

        list.remove(1);
        System.out.print("После удаления: ");
        list.print();

        System.out.println("Размер: " + list.size());
        System.out.println("Capacity: " + list.capacity());

        list.clear();
        System.out.print("После очистки: ");
        list.print();
    }
}