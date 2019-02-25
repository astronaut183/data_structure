package zyh.data.service;

public interface Heap {
    int size();

    boolean isEmpty();

    void insert(int data);

    int extractMax();

}
