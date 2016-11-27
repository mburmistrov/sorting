package ru.mail.polis.sort;

import java.util.Random;

public class RandomPivot3PartQuickSort {

    public static int[] sort(int[] a) {
        if (a == null)
            return new int[0];

        performSort(a, 0, a.length - 1);
        return a;
    }

    private static void performSort(int a[], int left, int right) {
        if (left >= right) {
            return;
        }

        Random r = new Random();

        int index = r.nextInt(right - left + 1) + left;

        Helper.swap(a, left, index);

        int x = a[left];
        int j = left;
        int k = left;

        for (int i = left + 1; i <= right; i++) {
            if (a[i] < x) {
                j++;
                Helper.swap(a, i , j);
            } else if (a[i] == x) {
                k++;
                j++;
                Helper.swap(a, i, j);
                Helper.swap(a, k, j);
            }
        }

        int temp = j;

        for (int i = left; i <= k; i++) {
            Helper.swap(a, i, j--);
        }

        performSort(a, left, j);
        performSort(a, temp + 1, right);
    }
}