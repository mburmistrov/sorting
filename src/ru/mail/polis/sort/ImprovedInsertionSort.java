package ru.mail.polis.sort;

public class ImprovedInsertionSort {

    public static int[] sort(int a[]) {
        if (a == null)
            return new int[0];

        for(int i = 0; i < a.length - 1; i++){
            int p = Helper.binarySearch(a, a[i], i);
            int aP = a[i];
            System.arraycopy(a, p, a, p + 1, i - p);
            a[p] = aP;
        }
        return a;
    }
}
