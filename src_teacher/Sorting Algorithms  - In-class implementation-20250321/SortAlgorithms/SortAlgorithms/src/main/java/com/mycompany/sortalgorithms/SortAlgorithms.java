/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sortalgorithms;

/**
 *
 * @author Legion 5 Pro
 */
public class SortAlgorithms {
    
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void printArray(int[] arr){
        for(int number : arr){
            System.out.print(number + " ");
        }
        System.out.println("");
    }
    
    public static void bubbleSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int swapCount = 0;
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                    swapCount++;
                }
            }
            if(swapCount == 0){
                break;
            }
        }
    }
    
    public static void insertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            for( int j = i; j > 0 ; j--){
                if(arr[j] < arr[j-1]){
                    swap(arr, j, j-1);
                } else{
                    break;
                }
            }
        }
    }
    
    public static void selectionSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                swap(arr, i, minIndex);
            }
        }
    }
    
    
    

    public static void main(String[] args) {
        int[] myArray = {30, 20, 7, 18, 12, 24, 36, 45};
        selectionSort(myArray);
        printArray(myArray);
    }
}
