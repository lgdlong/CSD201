/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quicksort;

/**
 *
 * @author Legion 5 Pro
 */
public class QuickSort {
    
    public static void printArray(int[] arr){
        for(int number : arr){
            System.out.print(number + " ");
        }
        System.out.println("");
    }
    
    public static int partition(int[] arr, int left, int right){
        int pivot = arr[right];
        int j = left - 1;
        for(int i = left; i <= right; i++){
            if(arr[i] <= pivot){
                j++;
                if(i != j){ 
                    // swap arr[i] and arr[j]
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return j;
    }
    
    public static void quickSort(int[] arr, int left, int right){
        if(left < right){
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 5, 4, 6, 3, 0, 8, 9};
        
        quickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }
}
