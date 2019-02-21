package zyh.data.main;

import zyh.data.service.LinkList;

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
    }
}
