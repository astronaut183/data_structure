package zyh.data.main;

import zyh.data.service.LinkList;

public class LinkListImpl implements LinkList {

    int size;
    private Node head;
    private Node cur;

//    public LinkListImpl() {
//        this.size = 0;
//        cur = null;
//        head = null;
//    }

    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    @Override
    public void add(int data) {
        Node node = new Node(data);
        if (size == 0) {
            head = node;
            cur = node;
        } else {
            cur.next = node;
            cur = node;
        }
        size++;
    }

    @Override
    public int get(int curr) {
        if (curr > size) {
            return -1;
        }
        Node cur = head;
        for (int i = 1; i < curr; i++) {
            cur = cur.next;
        }
        return cur.data;
    }

    @Override
    public void insert(int curr, int data) {
        if (curr == 1) {
            Node node = new Node(data);
            node.next = head;
            head = node;
        } else {
            Node point = head;
            Node node = new Node(data);
            for (int i = 1; i < curr; i++) {
                point = point.next;
            }
            node.next = point.next;
            point.next = node;
        }
        size++;

    }

    @Override
    public void display() {
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

    @Override
    public void delete(int cur) {
        if (cur > size) {
            return;
        } else {
            if (cur == 1) {
                head = head.next;
                size--;
            } else {
                Node prePoint = head;
                Node curPoint = prePoint.next;
                for (int i = 2; i < cur; i++) {
                    prePoint = prePoint.next;
                    curPoint = prePoint.next;
                }
                prePoint.next = curPoint.next;
                size--;
            }

        }
    }

    @Override
    public int getSize() {
        return size;
    }
}
