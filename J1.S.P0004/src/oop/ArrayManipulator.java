/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop;

import java.util.Random;

/**
 *
 * @author HP
 */
public class ArrayManipulator {

    private int[] array;

    public ArrayManipulator(int size) {
        this.array = getRandomIntegerArray(size);
    }

    public int[] getArray() {
        return array;
    }

    public void display(String msg) {
        System.out.print(msg + "[");
        int size = array.length;
        for (int i = 0; i < size; i++) {
            System.out.print(array[i]);
            if (i < size - 1) {
                System.out.print(", ");
            } else {
                System.out.println("]");
            }
        }
    }

    private int[] getRandomIntegerArray(int size) {
        int[] newArray = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            newArray[i] = random.nextInt(size);
        }
        return newArray;
    }

    public void sortArrayByQuickSort() {
        quickSort(array, 0, array.length - 1);
    }

    public void quickSort(int arr[], int left, int right) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
    }

    public int partition(int arr[], int left, int right) {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];

        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        };
        return i;
    }
}
