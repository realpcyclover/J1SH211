/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.h211;

import java.util.Scanner;

/**
 *[5, 2, 2, -5, 4, 3, 2, 4, 1, 1, 1, 0, 2, 17]. 
            ArrayIntList list2 = list.fromCounts();
            
 list2 to store [2, 2, 2, 2, 2, -5, -5, 3, 3, 3, 3, 4, 4, 1, 0, 17, 17].

 * @author 84399
 */
public class J1SH211 {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int size;
        while (true) {
            size = checkInt("Enter size of array: ", 0, Integer.MAX_VALUE);
            try {
                if (size % 2 != 0) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("Size must be even integer!");
            }
        }
        System.out.println("Enter elements of array:");
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                arr[i] = checkInt("Enter arr[" + i + "]: ", 0, Integer.MAX_VALUE);
            } else {
                arr[i] = checkInt("Enter arr[" + i + "]: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }
        ArrayIntList list = new ArrayIntList(arr, size);
        ArrayIntList list2 = list.fromCounts();
        for (int item : list2.getElementData()) {
            System.out.print(item + " ");
        }
        System.out.println("");
    }

   public static int checkInt(String Mess, int Min, int Max) {
        Scanner sc = new Scanner(System.in);

        int Ret = 0;
        String input = "";
        do {
            System.out.println(Mess);
            try {
                input = sc.nextLine();
                Ret = Integer.parseInt(input);
                if (Ret >= Min && Ret <= Max) {
                    break;
                }
                System.out.println("Out of range, please enter in range: " + Min + " -> " + Max + ")");
            } catch (Exception e) {
                // Regex: dấu "?" có thể có dấu trừ hoặc không. //d+ : nhiều hơn hoặc bằng 1 //d*: nhiều hơn hoặc bằng 0
                // ?: bằng 0 hoặc 1
                if (input.matches("\\-?\\d*")) {
                    System.out.println("Out of range of integer number.");
                } else {
                    System.err.println("Invalid number input, please enter an integer number only.");
                }
            }
        } while (true);
        return Ret;
    }

}
