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
        //linklist
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

        //queue
        Queue queue = new QueueImpl();
        queue.put(1);
        queue.put(2);
        queue.put(3);
        int q = queue.pop();
        System.out.println(q);
        queue.display();


        //stack
        Stack stack = new StackImpl();
        stack.put(1);
        stack.put(2);
        stack.put(3);
        stack.put(4);
        System.out.println(stack.pop());
        
        
        //binary tree
        BinaryTree binaryTree = new BinaryTree();

        System.out.println("前序递归");
        binaryTree.theFirstOrderTraversal(binaryTree.getRoot());
        System.out.println("");
        System.out.println("中序递归");
        binaryTree.theInOrderTraversal(binaryTree.getRoot());
        System.out.println("");
        System.out.println("后序递归");
        binaryTree.thePostOrderTraversal(binaryTree.getRoot());
        System.out.println("");
        System.out.println("前序非递归");
        binaryTree.preOrderNonRecursive(binaryTree.getRoot());
        System.out.println("");
        System.out.println("中序非递归");
        binaryTree.inOrderNonRecursive(binaryTree.getRoot());
        System.out.println("");
        System.out.println("后序非递归");
        binaryTree.postOrderNonRecursive(binaryTree.getRoot());
        System.out.println("");
        System.out.println("层序");
        binaryTree.levelOrderTraversal(binaryTree.getRoot());
    }
}
