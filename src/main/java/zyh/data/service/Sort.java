package zyh.data.service;

public interface Sort {
    void bubbleSort(int[] data);

    void insertSort(int[] data);

    void quickSort(int[] data, int low, int high);

    void margeSort(int[] data, int low, int high);

    void selectSort(int[] data);

    void heapSort1(int[] data);

    void heapSort2(int[] data);
}