import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Lists {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();

        //добавление 1000 элемент в ArrayList
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(random.nextInt( 500+100)-100);
        }
        long endTime = System.nanoTime();
        long durationAddArrayList = endTime - startTime;
        System.out.println("Array List add: " + durationAddArrayList);

        //добавление 1000 элемент в LinkedList
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkedList.add(random.nextInt( 500+100)-100);
        }
        endTime = System.nanoTime();
        long durationAddLinkedList = endTime - startTime;
        System.out.println("Linked List add: " + durationAddLinkedList);

        //удаление 1000 элементов из ArrayList
        startTime = System.nanoTime();
        for (int i = 999; i >= 0; i--) {
            arrayList.remove(i);
        }
        endTime = System.nanoTime();
        long durationDeleteArrayList = endTime - startTime;
        System.out.println("Array List delete: " + durationDeleteArrayList);

        //удаление 1000 элементов из LinkedList
        startTime = System.nanoTime();
        for (int i = 999; i >= 0; i--) {
            linkedList.remove(i);
        }
        endTime = System.nanoTime();
        long durationDeleteLinkedList = endTime - startTime;
        System.out.println("Linked List delete: " + durationDeleteLinkedList);

        //поиск 1000 элементов из ArrayList
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            arrayList.contains(i);
        }
        endTime = System.nanoTime();
        long durationFindArrayList = endTime - startTime;
        System.out.println("Array List find: " + durationFindArrayList);

        //поиск 1000 элементов из LinkedList
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkedList.contains(i);
        }
        endTime = System.nanoTime();
        long durationFindLinkedList = endTime - startTime;
        System.out.println("Linked List find: " + durationFindLinkedList);

        System.out.format("Difference add ArrayList and  LinkedList %d%n" , durationAddArrayList-durationAddLinkedList);
        System.out.format("Difference delete ArrayList and  LinkedList %d%n" , durationDeleteArrayList-durationDeleteLinkedList);
        System.out.format("Difference find ArrayList and  LinkedList %d%n" , durationFindArrayList-durationFindLinkedList);
    }
}
