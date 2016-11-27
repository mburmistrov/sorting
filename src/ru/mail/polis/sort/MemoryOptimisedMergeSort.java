package ru.mail.polis.sort;


public class MemoryOptimisedMergeSort {
    public static int[] sort(int[] a){
        if (a == null)
            return new int[0];
        if (a.length == 0 || a.length == 1)
            return a;

        return performSort(a, 0, a.length - 1);
    }

    static int[] performSort(int[] a, int min, int max){
        if(max - min == 1){
            if(a[min] > a[max]) {
                Helper.swap(a, min, max);
            }
        } else if(max - min != 0) {
            int mid = ( (int) Math.floor(min + (max - min) / 2));

            performSort(a, min, mid);
            performSort(a, mid + 1, max);
            mergeArrays(a, min, max, mid);
        }
        return a;
    }

    static void mergeArrays(int[] a, int min, int max, int mid){
        int i = min;
        while(i <= mid){
            if(a[i] > a[mid + 1]){
                Helper.swap(a, i, mid + 1);
                push(a, mid + 1, max);
            }
            i++;
        }
    }

    static void push(int[] aForPush, int s, int e){
        for(int i = s; i < e; i++){
            if(aForPush[i] > aForPush[i + 1])
                Helper.swap(aForPush, i , i + 1);
        }
    }
}
