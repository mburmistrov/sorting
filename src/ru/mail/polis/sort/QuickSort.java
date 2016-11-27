package ru.mail.polis.sort;

public class QuickSort {

    public static int[] sort(int[] a) {
        if (a == null)
            return new int[0];

        if (a.length == 0 || a.length == 1)
            return a;

        performSort(a, 0, a.length - 1);

        return a;
    }

    private static void performSort(int[] a, int low, int high) {
        int i = low, j = high;

        int pivot = a[low + (high - low) / 2];

        while (i <= j) {
            while (a[i] < pivot) {
                i++;
            }

            while (a[j] > pivot) {
                j--;
            }

            if (i <= j) {
                Helper.swap(a, i, j);
                i++;
                j--;
            }
        }
        //recur
        if (low < j)
            performSort(a,low, j);
        if (i < high)
            performSort(a, i, high);
    }
}
