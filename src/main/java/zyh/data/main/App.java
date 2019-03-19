package zyh.data.main;

import zyh.data.service.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //System.out.println( "Hello World!" );
        //linklist
//        LinkList linkList = new LinkListImpl();
//        linkList.add(1);
//        linkList.add(2);
//        linkList.add(2);
//        linkList.add(3);
//        linkList.display();
//        linkList.insert(2, 4);
//        linkList.display();
//        linkList.delete(1);
//        linkList.display();
//        System.out.println(linkList.get(3));
//
//        //queue
//        Queue queue = new QueueImpl();
//        queue.put(1);
//        queue.put(2);
//        queue.put(3);
//        int q = queue.pop();
//        System.out.println(q);
//        queue.display();
//
//
//        //stack
//        Stack stack = new StackImpl();
//        stack.put(1);
//        stack.put(2);
//        stack.put(3);
//        stack.put(4);
//        System.out.println(stack.pop());
//
//
//        //binary tree
//        BinaryTree binaryTree = new BinaryTree();
//
//        System.out.println("前序递归");
//        binaryTree.theFirstOrderTraversal(binaryTree.getRoot());
//        System.out.println("");
//        System.out.println("中序递归");
//        binaryTree.theInOrderTraversal(binaryTree.getRoot());
//        System.out.println("");
//        System.out.println("后序递归");
//        binaryTree.thePostOrderTraversal(binaryTree.getRoot());
//        System.out.println("");
//        System.out.println("前序非递归");
//        binaryTree.preOrderNonRecursive(binaryTree.getRoot());
//        System.out.println("");
//        System.out.println("中序非递归");
//        binaryTree.inOrderNonRecursive(binaryTree.getRoot());
//        System.out.println("");
//        System.out.println("后序非递归");
//        binaryTree.postOrderNonRecursive(binaryTree.getRoot());
//        System.out.println("");
//        System.out.println("层序");
//        binaryTree.levelOrderTraversal(binaryTree.getRoot());


//        int[] data = {1, 6, 5, 2, 9};
//        Sort sort = new SortImpl();
//        sort.heapSort2(data);
//        for (int d : data) {
//            System.out.println(d);
//        }

//        StackAndQueue stackAndQueue = new StackAndQueue();
//        stackAndQueue.TwoStackBeQueue();
//        stackAndQueue.TwoQueueBeStack();

//        IntArray array = new IntArray(2);
//        array.add(1);
//        System.out.println(array.getSize());
//        array.add(2);
//        System.out.println(array.getSize());
//        array.add(3);
//        System.out.println(array.getSize());
//        array.add(4);
//        System.out.println(array.getSize());

//        Mid mid = new Mid();
//        mid.midem(data);
//    }

//        Backpack backpack = new Backpack();
//        int[] w = {1,2,3};
//        int[] v = {6,10,12};
//        int size = 5;
//        System.out.println(backpack.recursiveBackpack1(w,v,size));
//        System.out.println(backpack.recursiveBackpack2(w,v,size));
//        System.out.println(backpack.backpack(w,v,size));

//        GraphMatrix graphMatrix = new GraphMatrixImpl(5);
//        graphMatrix.addBrim(1, 0, 1);
//        graphMatrix.addBrim(1, 2, 1);
//        graphMatrix.addBrim(3, 2, 1);
//        graphMatrix.addBrim(3, 1, 1);
//        graphMatrix.addBrim(1, 4, 1);
//        graphMatrix.display();
//        //graphMatrix.dfsGraph();
//        //graphMatrix.bfsGraph();
//        graphMatrix.TopologicalGraph();

        /**
         * scanner输入
         */
        Scanner scanner = new Scanner(System.in);
        int na = scanner.nextInt();
        int nb = scanner.nextInt();
        int[] aa = new int[na];
        int[] bb = new int[nb];
        int i = 0;
        while (scanner.hasNext()) {
            aa[i++] = scanner.nextInt();
            if (i == aa.length) {
                break;
            }
        }

        i = 0;
        while (scanner.hasNext()) {
            bb[i++] = scanner.nextInt();
            if (i == bb.length) {
                break;
            }
        }

        for (int j = 0; j < aa.length; j++) {
            System.out.print(aa[j] + " ");
        }
        System.out.println();
        for (int j = 0; j < bb.length; j++) {
            System.out.print(bb[j] + " ");
        }
    }
}
