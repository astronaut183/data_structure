package zyh.data.main;

import zyh.data.service.LinkList;
import zyh.data.service.Queue;
import zyh.data.service.Stack;

import java.util.Collection;
import java.util.Iterator;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //System.out.println( "Hello World!" );
        LinkList linkList = new LinkListImpl();
        linkList.add(1);
        linkList.add(2);
        linkList.add(2);
        linkList.add(3);
        linkList.display();
        linkList.insert(2, 4);
        linkList.display();
        linkList.delete(1);
        linkList.display();
        System.out.println(linkList.get(3));

        Queue queue = new QueueImpl();
        queue.put(1);
        queue.put(2);
        queue.put(3);
        int q = queue.pop();
        System.out.println(q);
        queue.display();


        Stack stack = new StackImpl();
        stack.put(1);
        stack.put(2);
        stack.put(3);
        stack.put(4);
        System.out.println(stack.pop());
    }
}
