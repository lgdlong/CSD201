/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.searchalgorithms;

/**
 *
 * @author Legion 5 Pro
 */
public class SearchAlgorithms {
    public static int linearSearch(int[] array, int target){
        for(int i = 0; i < array.length; i++){
            if(array[i] == target){
                return i;
            }
        }
        return -1;
    }
    
    public static int binarySearch(int[] array, int target){
        int left = 0;
        int right = array.length - 1;
        
        while(right >= left){
            int mid = left + (right - left)/2;
            if(array[mid] == target){
                return mid;
            }
            if(array[mid] < target){
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
         int[] array = {10, 2, 7, 14, 30, 25, 48, 22};
         int[] sortedArray = {1, 5, 12, 22, 31, 48, 58, 61, 73};
         int target = 31;
         int result = binarySearch(sortedArray, target);
         if(result != -1){
             System.out.println("Number " + target + " is found at position " + result);
         } else{
             System.out.println("Number " + target + " is not found.");
         }
    }
}
