package zyh.data.main;


import java.util.PriorityQueue;

/**
 *
 * 无序数组求中位数，size/2堆，或者半个快排
 */
public class Mid {
    public void midem(int[] data) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int len = data.length / 2 + 1;
        for (int i = 0; i < len; i++) {
            heap.add(data[i]);
        }

        for (int i = len; i < data.length; i++) {
            if (data[i] > heap.peek()) {
                heap.poll();
                heap.add(data[i]);
            }
        }

        if (!heap.isEmpty()) {
            //System.out.println(heap.poll());
            if (data.length % 2 == 0) {
                System.out.println(heap.poll());
            } else {
                int mid1 = heap.poll();
                if (!heap.isEmpty()) {
                    int mid2 = heap.poll();
                    System.out.println(mid1 + mid2 / 2);
                }

            }
        }

    }

}
