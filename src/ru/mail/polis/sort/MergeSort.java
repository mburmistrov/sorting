package ru.mail.polis.sort;

import java.util.Arrays;

public class MergeSort {
    public static int[] sort(int a[]) {
        if (a == null)
            return new int[0];

        if (a.length == 0 || a.length == 1) {
            return a;
        }

        int avg = a.length / 2;
        int[] leftPart = Arrays.copyOf(a, avg);
        int[] rightPart = Arrays.copyOfRange(a, avg, a.length);

        leftPart = sort(leftPart);
        rightPart = sort(rightPart);

        int i = 0, j = 0;
        while (i < leftPart.length && j < rightPart.length) {
            if (leftPart[i] <= rightPart[j]) {
                a[i + j] = leftPart[i++];
            } else {
                a[i + j] = rightPart[j++];
            }
        }

        while (i < leftPart.length) {
            a[i + j] = leftPart[i++];
        }

        while (j < rightPart.length) {
            a[i + j] = rightPart[j++];
        }

        return a;
    }
}
