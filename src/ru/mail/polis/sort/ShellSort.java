package ru.mail.polis.sort;

public class ShellSort {

    public static int[] sort(int a[]) {
        if (a == null)
            return new int[0];

        int inner, outer;
        int temp;

        int h = 1;
        while (h <= a.length / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for (outer = h; outer < a.length; outer++) {
                temp = a[outer];
                inner = outer;

                while (inner > h - 1 && a[inner - h] >= temp) {
                    a[inner] = a[inner - h];
                    inner -= h;
                }
                a[inner] = temp;
            }
            h = (h - 1) / 3;
        }
        return a;
    }
}
