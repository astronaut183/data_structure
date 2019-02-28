package zyh.data.main;

public class IntArray {
    private int capacity;
    private int size;
    private int[] array;

    public IntArray(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        array = new int[capacity];
    }

    public void add(int data) {
        if (size >= capacity / 2)
            array = extend();
        array[size] = data;
        size++;
    }

    private int[] extend() {
        capacity *= 2;
        int[] newArray = new int[capacity];
        for (int i = 0; i <= size; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    public int get(int index) {
        if (index > size) return -1;
        return array[index];
    }

    public int getSize(){
        return size;
    }
}
