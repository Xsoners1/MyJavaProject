package Task7;

public class MyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList(int initialSize) throws InvalidInitializationException {
        if (initialSize < 0) {
            throw new InvalidInitializationException("Начальний розмер не може бути від’ємний");
        }
        head = null;
        tail = null;
        size = 0;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        size++;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        size++;
    }

    public void add(int index, int data) {
        if (index < 0 || index > size) {
            throw new InvalidIndexException("Неправильний індекс: " + index);
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        if (index == size) {
            addLast(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        Node prevNode = current.prev;

        prevNode.next = newNode;
        newNode.prev = prevNode;

        newNode.next = current;
        current.prev = newNode;

        size++;
    }

    public int get(int index) throws GetException {
        if (size == 0) {
            throw new EmptyListException("Список порожній");
        }

        if (index < 0 || index >= size) {
            throw new GetException("Неправильний індекс: " + index);
        }

        Node current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    public void remove(int index) throws RemoveException {
        if (size == 0) {
            throw new EmptyListException("Список порожній");
        }

        if (index < 0 || index >= size) {
            throw new RemoveException("ННеправильний індекс: " + index);
        }

        if (index == 0) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
        } else if (index == size - 1) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
            else head = null;
        } else {
            Node current = head;

            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        size--;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return size;
    }

    public void print() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }
}