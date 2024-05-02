package com.sri.dsa.array.basic;

/**
 * This class provides methods to sort an array using various sorting
 * algorithms:
 * Bubble Sort, Insertion Sort, Selection Sort, Merge Sort, Quick Sort, and Heap
 * Sort.
 * Each method modifies the array in place to sort the elements in ascending
 * order (except for Merge Sort which uses extra space).
 *
 * Usage: This class can be used to sort any integer array using one of the
 * provided sorting methods.
 * Complexity varies by algorithm, with most efficient algorithms (Quick Sort,
 * Merge Sort, Heap Sort) typically offering O(n log n) performance.
 * Space Complexity varies, with most algorithms using O(1) except for Merge
 * Sort which uses O(n).
 *
 * Copyright (c) 2024 Srikanth Pula.
 * All rights reserved.
 *
 * @author Srikanth Pula
 *         Date: 01-05-2024
 */
public class SortArray {

    /**
     * Main method which acts as the entry point of the program.
     *
     * @param args Command line arguments, not used in this program.
     */
    public static void main(String[] args) {
        int[] array = { 64, 34, 25, 12, 22, 11, 90 };

        // Demonstrating each sorting method
        int[] tempArray = array.clone();
        bubbleSort(tempArray);
        System.out.println("Bubble Sorted: " + arrayToString(tempArray));

        tempArray = array.clone();
        insertionSort(tempArray);
        System.out.println("Insertion Sorted: " + arrayToString(tempArray));

        tempArray = array.clone();
        selectionSort(tempArray);
        System.out.println("Selection Sorted: " + arrayToString(tempArray));

        tempArray = array.clone();
        mergeSort(tempArray, 0, tempArray.length - 1);
        System.out.println("Merge Sorted: " + arrayToString(tempArray));

        tempArray = array.clone();
        quickSort(tempArray, 0, tempArray.length - 1);
        System.out.println("Quick Sorted: " + arrayToString(tempArray));

        tempArray = array.clone();
        heapSort(tempArray);
        System.out.println("Heap Sorted: " + arrayToString(tempArray));
    }

    // Implementations of each sorting method

    private static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (array[j] > array[j + 1]) {
                    // swap temp and arr[i]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
    }

    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            /*
             * Move elements of arr[0..i-1], that are
             * greater than key, to one position ahead
             * of their current position
             */
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    private static void selectionSort(int[] array) {
        int n = array.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (array[j] < array[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = array[min_idx];
            array[min_idx] = array[i];
            array[i] = temp;
        }
    }

    private static void mergeSort(int[] array, int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            mergeSort(array, l, m);
            mergeSort(array, m + 1, r);

            // Merge the sorted halves
            merge(array, l, m, r);
        }
    }

    private static void merge(int[] array, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int[] L = new int[n1];
        int[] R = new int[n2];

        /* Copy data to temp arrays */
        for (int i = 0; i < n1; ++i)
            L[i] = array[l + i];
        for (int i = 0; i < n2; ++i)
            R[i] = array[m + 1 + i];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            /*
             * pi is partitioning index, arr[pi] is
             * now at right place
             */
            int pi = partition(array, low, high);

            // Recursively sort elements before
            // partition and after partition
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (array[j] < pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    private static void heapSort(int[] array) {
        int n = array.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // call max heapify on the reduced heap
            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && array[l] > array[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && array[r] > array[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(array, n, largest);
        }
    }

    // Utility method to print array elements
    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int num : array) {
            sb.append(num).append(" ");
        }
        return sb.toString().trim();
    }
}
