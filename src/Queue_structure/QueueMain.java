package Queue_structure;

import java.sql.SQLOutput;

class Queue<T> {
    class Node<T> {
        T data;
        Node next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> first = null;
    private Node<T> last = null;
    private Node<T> pointer = null;

    public void add(T d) {
        Node<T> item = new Node<>(d);
        if (first == null) {
            first = item;
            last = first;
        } else {
            last.next = item;
            last = item;
        }
    }

    public T remove() {
        T tmp = first.data;
        if (first != last) {
            first = first.next;
            return tmp;
        }
        first = null;
        last = null;
        return tmp;
    }

    public T peek() {
        if (first != null) {
            return first.data;
        }
        return null;
    }

    public boolean isEmpty() {
        if (first == null) {
            return true;
        }
        return false;
    }

}

public class QueueMain {
    public static void main(String[] args) {
        Queue<Integer> item = new Queue<>();
        item.add(1);
        item.add(2);
        item.add(3);
        item.add(4);
        item.add(5);
        System.out.println("first : "+item.peek());
        System.out.println("remove : "+item.remove());
        System.out.println("remove : "+item.remove());
        System.out.println("first : "+item.peek());
        System.out.println(item.isEmpty());
        System.out.println("remove : "+item.remove());
        System.out.println("remove : "+item.remove());
        System.out.println("remove : "+item.remove());
        System.out.println(item.isEmpty());
    }
}
