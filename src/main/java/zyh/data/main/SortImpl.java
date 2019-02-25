package zyh.data.main;

import zyh.data.service.Sort;

public class SortImpl implements Sort {

    /**
     * 冒泡排序
     * 两个嵌套循环，外层循环每执行一次，将遍历到的最大的数放到最后，
     * 内层循环负责两两比较交换，范围是0 到 数组长度-外层循环次数。
     *
     * @param data
     * @return
     */
    @Override
    public void bubbleSort(int[] data) {
        if (data.length == 0) return;
        for (int i = 1; i < data.length; i++) {
            for (int j = 0; j < data.length - i; j++) {
                if (data[j] > data[j + 1]) swap(j, j + 1, data);
            }
        }
    }

    /**
     * 选择排序
     * 两个循环，第一个循环负责全局遍历，第二个循环负责找出循环中最小的值，然后放到最前面
     * 内循环运行一次，找出一个循环中最小值放到最前面，外循环执行完，数组有序
     * @param data
     */
    @Override
    public void selectSort(int[] data) {
        if (data.length == 0) return;
        for (int i = 0; i < data.length; i++) {
            int minCursor = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[minCursor]) minCursor = j;
            }
            swap(minCursor, i, data);
        }
    }

    /**
     * 插入排序
     * 两个循环，外循环负责全局遍历，内循环负责维护一个有序的子数组，外循环执行一次，往有序的子数组中插入一个值，
     * 内循环使子数组有序
     * @param data
     */
    @Override
    public void insertSort(int[] data) {
        if (data.length == 0) return;
        for (int i = 1; i < data.length; i++) {
            int temp = data[i];
            int j;
            for (j = i - 1; j >= 0 && data[j] > temp; j--) {
                data[j + 1] = data[j];
            }
            data[j + 1] = temp;
        }
    }

    /**
     *快速排序
     * 分两步：找到一个数的位置，然后将数组分为两部分，分别再进行快排
     * 确定数的位置：从high开始，寻找比数小的值交换，位置为新high，之后从low开始，寻找比数大的值交换，位置为新low，
     * 直到low=high，最后low或high的位置就是数的最终位置，然后返回
     * 对数的两端，分别再进行快排
     * @param data
     * @param low
     * @param high
     */
    @Override
    public void quickSort(int[] data, int low, int high) {
        if (low < high) {
            int middle = getQuickSortMiddle(data, low, high);
            quickSort(data, low, middle - 1);
            quickSort(data, middle + 1, high);
        }
    }

    private int getQuickSortMiddle(int[] data, int low, int high) {
        int temp = data[low];
        while (low < high) {
            while (data[high] >= temp && high > low) high--;
            data[low] = data[high];
            while (data[low] <= temp && high > low) low++;
            data[high] = data[low];
        }
        data[low] = temp;
        return low;
    }


    /**
     * 归并排序
     * 将数组对半分，一直分到每个字数组只有1个数
     * 然后进行合并，合并后的数组有序，然后两个有序数组合并，最后全部有序
     * @param data
     * @param low
     * @param high
     */
    @Override
    public void margeSort(int[] data, int low, int high) {
        int mid = low + (high - low) / 2;
        if (low < high) {
            margeSort(data, low, mid);
            margeSort(data, mid + 1, high);
            marge(data, low, mid, high);
        }
    }

    private void marge(int[] data, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (data[i] < data[j]) temp[k++] = data[i++];
            if (data[i] >= data[j]) temp[k++] = data[j++];
        }
        while (i <= mid) {
            temp[k++] = data[i++];
        }
        while (j <= high) {
            temp[k++] = data[j++];
        }
        for (int x = 0; x < temp.length; x++) data[low + x] = temp[x];
    }


    private void swap(int a, int b, int[] data) {
        int temp;
        temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
}
