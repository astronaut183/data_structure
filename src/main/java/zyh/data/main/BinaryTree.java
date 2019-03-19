package zyh.data.main;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    private Node root;

    public class Node{
        private int data;
        private Node leftChind;
        private Node rightChind;

        public Node(int data, Node leftChind, Node rightChind){
            this.data = data;
            this.leftChind = leftChind;
            this.rightChind = rightChind;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeftChind() {
            return leftChind;
        }

        public void setLeftChind(Node leftChind) {
            this.leftChind = leftChind;
        }

        public Node getRightChind() {
            return rightChind;
        }

        public void setRightChind(Node rightChind) {
            this.rightChind = rightChind;
        }
    }

    //binary tree

    /**
     *         1
     *       /  \
     *      2    3
     *     / \  /
     *    4  5 6
     */
    public BinaryTree(){
        Node a = new Node(6,null,null);
        Node b = new Node(5,null,null);
        Node c = new Node(4,null,null);
        Node d = new Node(3,a,null);
        Node e = new Node(2,c,b);
        Node f = new Node(1,e,d);
        root = f;
    }
    //前序递归
    public void theFirstOrderTraversal(Node root){
        System.out.print(root.data +" ");
        if(root.leftChind!=null)    theFirstOrderTraversal(root.leftChind);
        if(root.rightChind!=null)   theFirstOrderTraversal(root.rightChind);
    }
    //中序递归
    public void theInOrderTraversal(Node root){
        if(root.leftChind!=null)   theInOrderTraversal(root.leftChind);
        System.out.print(root.data +" ");
        if(root.rightChind!=null)   theInOrderTraversal(root.rightChind);
    }
    //后续递归
    public void thePostOrderTraversal(Node root){
        if(root.leftChind!=null)    thePostOrderTraversal(root.leftChind);
        if(root.rightChind!=null)   thePostOrderTraversal(root.rightChind);
        System.out.print(root.data +" ");
    }


    /**
     * 前序遍历，非递归实现
     * 1，先入栈根节点，输出根节点val值，再先后入栈其右节点、左结点；
     * 2，出栈左节点，输出其val值，再入栈该左节点的右节点、左节点；直到遍历完该左节点所在子树。
     * 3，再出栈右节点，输出其val值，再入栈该右节点的右节点、左节点；直到遍历完该右节点所在子树。
     * */
    public void preOrderNonRecursive(Node root){
        Stack<Node> stack = new Stack<>();
        if(root!=null){
            stack.push(root);
        }
        while(!stack.empty()){
            Node node = stack.pop();
            System.out.print(node.data +" ");
            if(node.rightChind!=null)   stack.push(node.rightChind);
            if(node.leftChind!=null)    stack.push(node.leftChind);
        }
    }
    /**中序非递归
     *
     *   中序遍历，非递归实现
     *  1，首先从根节点出发一路向左，入栈所有的左节点；
     *  2，出栈一个节点，输出该节点val值，查询该节点是否存在右节点，
     *  若存在则从该右节点出发一路向左入栈该右节点所在子树所有的左节点；
     *  3，若不存在右节点，则出栈下一个节点，输出节点val值，同步骤2操作；
     *  4，直到节点为null，且栈为空。
     */

    public void inOrderNonRecursive(Node root){
        Stack<Node> stack = new Stack<>();
        while(root!=null||!stack.empty()){
            while(root!=null){
                stack.push(root);
                root = root.leftChind;
            }
            if(!stack.empty()){
                Node node = stack.pop();
                System.out.print(node.data +" ");
                root = node.rightChind;
            }
        }
    }

    /**后序非递归
     * 采用两个栈，一个栈实现太复杂，使用一个辅助的栈作为后序遍历的逆序，然后依次弹出
     * 1，首先将一路的右节点都压入两个栈；
     * 2，stack栈出一个节点，就访问它的左节点，再一路压入左节点的右节点，重复1
     * 3，此时output栈为后序遍历的逆序
     * @param root
     */
    public void postOrderNonRecursive(Node root){
        Stack<Node> stack = new Stack<>();
        Stack<Node> output = new Stack<>();

        while(root!=null||stack.size()!=0){
            if(root!=null){
                output.push(root);
                stack.push(root);
                root = root.getRightChind();
            }else{
                root = stack.pop();
                root = root.getLeftChind();
            }
        }
        while(output.size()>0){
            System.out.print(output.pop().data +" ");
        }
    }

    /**
     * 广度优先遍历
     * 采用非递归实现
     * 需要辅助数据结构：队列
     * 将根节点入队，判断队列为空，出队，出队的时候判断节点有没有子节点，有子节点的话，将子节点都入队
     * 然后下一个节点出队，子节点入队
     */
    public void levelOrderTraversal(Node root){
        int level = 1;
        Node cursor = root;
        Node levelCursor = root;
        ArrayDeque<Node> queue = new ArrayDeque<>();
            if(root!=null){
                queue.add(root);
            }
        while(!queue.isEmpty()){
                Node node = queue.remove();
            System.out.print(node.data+" ");
                if(node.getLeftChind()!=null){
                    queue.add(node.getLeftChind());
                    cursor = node.getLeftChind();
                }
                if(node.getRightChind()!=null){
                    queue.add(node.getRightChind());
                    cursor = node.getRightChind();
                }
                if(levelCursor==node){
                    System.out.print("    "+ ++level);
                    System.out.println("");
                    levelCursor = cursor;
                }

        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

}
