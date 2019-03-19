package zyh.data.main;

public class LRU {
    private static int size = 0;
    private static int capacity = 3;
    private static Node head;

    static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public static void insert(int data) {
        Node node = new Node(data);
        if (size == 0) {
            head = node;
            size++;
            return;
        }
        node.next = head;
        head = node;
        size++;
        if (size > capacity) {
            remove(size);
        }
    }

    public static void remove(int cursor) {
        Node node1 = head;
        Node node2 = node1.next;
        for (int i = 2; i < cursor; i++) {
            node1 = node2;
            node2 = node2.next;
        }
        node1.next = node2.next;
        size--;
    }

    public static int findByData(int data) {
        Node node = head;
        int i = 0;
        while (node != null) {
            i++;
            if (node.data == data) return i;
            node = node.next;
        }
        return -1;
    }

    public static void lru(int data) {
        int cursor = findByData(data);
        if (cursor == -1) {
            insert(data);
        }else{
            remove(cursor);
            insert(data);
        }

    }

    public static void display() {
        if (size == 0) {
            return;
        } else {
            Node point = head;
            for (int i = 0; i < size; i++) {
                System.out.print(point.data);
                point = point.next;
                if (i == size - 1) break;
                else System.out.print("->");
            }
            System.out.println("");
        }


    }

    public static void main(String[] args) {
        lru(1);
        display();
        lru(2);
        display();
        lru(3);
        display();
        lru(4);
        display();
        lru(2);
        display();
        lru(4);
        display();
    }
}
