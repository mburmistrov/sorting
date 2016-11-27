package ru.mail.polis.sort;

public class InsertionSort {
    /*public static void main(String[] args) {
        int [] a = {5, 6, 1, 7, 9};

        InsertionSort.sort(a);
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
    }*/

    public static int[] sort(int a[]) {
        if (a == null)
            return new int[0];

        for(int i = 0; i < a.length; i++){
            for(int j = i; j > 0 && a[j] < a[j - 1]; j--){
                Helper.swap(a, j, j - 1);
            }
        }
        return a;
    }
}
