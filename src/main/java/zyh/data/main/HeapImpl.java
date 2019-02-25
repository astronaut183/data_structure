package zyh.data.main;

import zyh.data.service.Heap;

import java.util.ArrayList;
import java.util.List;

public class HeapImpl implements Heap {
    private int count;

    private List<Integer> data;

    HeapImpl() {
        count = -1;
        data = new ArrayList<>();
    }

    HeapImpl(int[] numbers) {
        data = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++)
            data.add(numbers[i]);

        count = numbers.length;
        for (int i = count - 1 / 2; i >= 1; i--) shiftDown(i);
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == -1;
    }

    @Override
    public void insert(int item) {
        data.add(item);
        count++;
        shiftUp(count);
    }

    /**
     * 插入元素之后，维持最大堆的过程
     * 将新插入的元素和父节点比较，如果比父节点大，则交换，一直比到父节点大的时候
     *
     * @param k
     */
    private void shiftUp(int k) {
        while (k > 0 && data.get((k - 1) / 2) < data.get(k)) {
            swap((k - 1) / 2, k, data);
            k = (k - 1) / 2;
        }
    }


    public int extractMax() {
        if (isEmpty()) return -1;
        int result = data.get(0);
        swap(0, count, data);
        count--;
        shiftDown(0);
        return result;
    }

    /**
     * 提取元素后，将末尾元素放到根节点，维持最大堆
     * 只要根节点比任何一个孩子小，就与较大的孩子进行交换，直到父节点比孩子都大，或者没有孩子
     *
     * @param k
     */
    private void shiftDown(int k) {
        while (((k * 2) + 1) <= count) {
            int j = k * 2 + 1;

            if (j + 1 <= count && data.get(j + 1) > data.get(j)) j++;

            if (data.get(k) >= data.get(j)) break;
            swap(k, j, data);
            k = j;
        }
    }

    private void swap(int a, int b, List<Integer> data) {
        int temp;
        temp = data.get(a);
        data.set(a, data.get(b));
        data.set(b, temp);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }
}
