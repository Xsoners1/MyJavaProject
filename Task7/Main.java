package Task7;

public class Main {
    public static void main(String[] args) {

        try {
            MyLinkedList list = new MyLinkedList(0);

            list.addLast(10);
            list.addLast(20);
            list.addFirst(5);
            list.add(1, 15);

            System.out.print("Список: ");
            list.print();

            System.out.println("Елемент: " + list.get(2));

            list.remove(10);

        } catch (InvalidInitializationException e) {
            System.out.println("Помилка створення: " + e.getMessage());
        } catch (GetException e) {
            System.out.println("Помилка отримання: " + e.getMessage());
        } catch (RemoveException e) {
            System.out.println("Помилка видалення: " + e.getMessage());
        } catch (InvalidIndexException e) {
            System.out.println("Помилка індексу: " + e.getMessage());
        } catch (EmptyListException e) {
            System.out.println("Список порожній: " + e.getMessage());
        }
    }
}