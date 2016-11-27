package ru.mail.polis.sort;

public class BinaryQuickSort {

    private static final int INT_BINARY_LENGTH = 31;

    public static int[] sort(int[] a) {
        if (a == null)
            return new int[0];

        if (a.length == 0 || a.length == 1)
            return a;

        performSort(a, 0, a.length - 1, INT_BINARY_LENGTH);

        return a;
    }

    public static int[] performSort(int[] arr, int l, int r, int bit){
        if (l < r && !(bit < 0)) {
            int index = partition(arr, l, r, bit);

            performSort(arr, l, index, bit - 1);
            performSort(arr, index + 1, r, bit - 1);
        }

        return arr;
    }

    static int getBit(int n, int k) {
        return (n >> k) & 1;
    }

    public static int partition(int[] a, int l, int r, int bit){
        int i = l;
        int j = r;

        while (i <= j) {
            while (i < a.length && getBit(a[i], bit) == 0) i++;
            while (j > -1 && getBit(a[j], bit) == 1) j--;
            if (i <= j) Helper.swap(a, i++, j--);
        }

        return j;
    }
}