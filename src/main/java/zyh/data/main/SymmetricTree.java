package zyh.data.main;


public class SymmetricTree {
    public boolean IsSymmertric(BinaryTree.Node root) {
        if (root == null) return true;
        return IsSubSymmertric(root.getRightChind(),root.getLeftChind());
    }

    public boolean IsSubSymmertric(BinaryTree.Node rChild, BinaryTree.Node lChild) {
        if (rChild == null && lChild == null) return true;
        if (rChild == null || lChild == null) return false;
        return  (rChild.getData()==lChild.getData())&&IsSubSymmertric(rChild.getRightChind(),lChild.getLeftChind())&&
                IsSubSymmertric(rChild.getLeftChind(),lChild.getRightChind());
    }
}
