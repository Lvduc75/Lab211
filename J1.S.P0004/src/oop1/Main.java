/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop1;

import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Main {
    public static void main(String[] args) {
        int size = inputPositiveNumberDecimal("Enter number of array: ");
        ArrayManipulator arrayManipulator = new ArrayManipulator(size);
        
        arrayManipulator.getRandomIntegerArray();

        System.out.println("Unsorted array: ");
        arrayManipulator.display("");

        arrayManipulator.sortArrayByQuickSort();

        System.out.println("Sorted array: ");
        arrayManipulator.display("");
    }

    private static int inputPositiveNumberDecimal(String msg) {
        Scanner sc = new Scanner(System.in);
        double size;
        String input;
        do {
            System.out.println(msg);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input could not be empty. Please enter a positive integer number");
                continue;
            }
            try {
                size = Double.parseDouble(input);
                if (size <= 0 || (int) size != size) {
                    throw new Exception();
                } else {
                    break;
                }
            } catch (NumberFormatException exception) {
                System.out.println("Input could not be a string. Please enter a positive integer number");
            } catch (Exception e) {
                System.out.println("Input could not be less than or equal to zero or a real number. Please enter a positive integer number");
            }
        } while (true);
        return (int) size;
    }
}
