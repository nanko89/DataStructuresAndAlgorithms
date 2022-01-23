import implementations.ArrayList;
import implementations.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> elements = new SinglyLinkedList<>();
        elements.addFirst(2);
        System.out.println(elements.getFirst());
        elements.addFirst(1);
        System.out.println(elements.getFirst());
        System.out.println(elements.isEmpty());
        elements.addLast(3);
        elements.addLast(4);
        elements.removeLast();


    }

}
