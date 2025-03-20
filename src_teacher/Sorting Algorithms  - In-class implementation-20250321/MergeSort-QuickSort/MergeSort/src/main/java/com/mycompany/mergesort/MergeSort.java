/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mergesort;

/**
 *
 * @author Legion 5 Pro
 */
public class MergeSort {
    
    public static void merge(int[] arr, int left, int mid, int right){
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        
        // copy values from array to leftArray and rightArray
        for(int i = 0; i < n1; i++){
            leftArray[i] = arr[left + i];
        }
        for(int j = 0; j < n2; j++){
            rightArray[j] = arr[mid + 1 + j];
        }
        
        int i = 0;
        int j = 0;
        int k = left;
        while(i < n1 && j < n2){
            if(leftArray[i] < rightArray[j]){
                arr[k] = leftArray[i];
                i++;
            } else{
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        // check remainings for arr1 and arr2
        while(i < n1){
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while(j < n2){
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
    
    public static void mergeSort(int[] arr, int left, int right){
        if(left < right){ // has 2 or more elements
            int mid = left + (right - left)/2;
            
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            
            merge(arr, left, mid , right);
        }
    }
    
    public static void printArray(int[] arr){
        for(int number : arr){
            System.out.print(number + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 5, 4, 6, 3, 0, 8, 9};
        
        mergeSort(arr, 0, arr.length - 1);
        printArray(arr);
    }
}
