package ru.mail.polis.sort;

import java.util.Random;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Helper {

    private static final Random r = ThreadLocalRandom.current();

    public static void swap(int[] a, int i, int j) {
        int x = a[i];
        a[i] = a[j];
        a[j] = x;
    }

    public static int[] gen(int n) {
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        for (int i = a.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            Helper.swap(a, i, j);
        }
        return a;
    }

    public static int[] genSortedASC(int n) {
        int[] a = Helper.gen(n);
        Arrays.sort(a);
        return a;
    }

    public static int[] genSortedDESC(int n) {
        int[] a = Helper.genSortedASC(n);

        for (int i = 0; i < a.length / 2; i++) {
            Helper.swap(a, i, a.length - i - 1);
        }

        return a;
    }

    public static int[] genWorseCaseForMergeSort(int n) {
        int[] a = Helper.genSortedASC(n);
        Helper.worseCaseForMergeSortSeparate(a);
        return a;
    }

    public static void worseCaseForMergeSortSeparate(int[] a) {
        if(a.length <= 1)
            return;

        if(a.length == 2)
        {
            int swap = a[0];
            a[0] = a[1];
            a[1] = swap;
            return;
        }

        int i, j;
        int m = (a.length + 1) / 2;
        int left[] = new int[m];
        int right[] = new int[a.length - m];

        for(i = 0, j = 0 ;i < a.length; i = i + 2, j++)
            left[j]=a[i];

        for(i = 1, j = 0; i < a.length; i = i + 2, j++)
            right[j] = a[i];

        Helper.worseCaseForMergeSortSeparate(left);
        Helper.worseCaseForMergeSortSeparate(right);
        Helper.worseCaseForMergeSortMerge(a, left, right);
    }

    public static void worseCaseForMergeSortMerge(int[] a, int[] left, int[] right) {
        int i, j;
        for(i = 0; i < left.length; i++) {
            a[i] = left[i];
        }
        for(j = 0; j < right.length; j++, i++) {
            a[i] = right[j];
        }
    }

    public static int binarySearch(int[] a, int key, int right) {
        int left = -1;
        int mid;
        while (left < right - 1) {
            mid = left + (right - left) / 2;

            if (a[mid] < key) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
