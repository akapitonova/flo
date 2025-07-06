package com.kap.flowershop.testclasses;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class GeneralsTest {

    @Test
    public void MaxElemetsTest() {
        double[] arr = new double[10];
        for(int i=0; i< arr.length; i++) {
            arr[i]=Math.random();
        }

        double max = arr[0];
        double min = arr[0];
        double avg = 0.0;

        for(int j=1; j<arr.length; j++) {
            if(arr[j] > max) {
                max = arr[j];
            }

            if(min<arr[j]) {
                min = arr[j];
            }

            avg+=arr[j];
        }

        System.out.println("max="+max);
        System.out.println("min="+min);
        System.out.println("cur="+avg);

        assertNotNull(max);
        assertNotNull(min);
        assertNotNull(avg);
    }

    @Test
    public void bubleSort() {
        double[] arr = new double[10];
        for(int i=0; i< arr.length; i++) {
            arr[i]=Math.random();
        }

        double temp = 0.0;
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr.length; j++) {
                if(arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for(int i=0; i<arr.length; i++) {
            System.out.println(arr[i]+" ");
        }

        assertNotNull(arr);
    }

    @Test
    public void checkSimple() {
        for(int i=2; i<=100; i++) {
            boolean isSimple = true;
            for(int j=2;j<i;j++) {
                if(i%j == 0) {
                    isSimple = false;
                    break;
                }
            }

            if(isSimple) {
                System.out.println(i);
            }
        }

        assertTrue(true);
    }

    @Test
    public void removeElement() {
        int arr[] = {0,1,2,2,3,0,4,2};
        int toRemove = 2;

        int offset = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == toRemove) {
                offset++;
            } else {
                arr[i - offset] = arr[i];
            }
        }

        arr = Arrays.copyOf(arr, arr.length - offset);

        for(int i=0; i<arr.length; i++) {
            System.out.println(arr[i]+" ");
        }

        assertNotNull(arr);
    }

    @Test
    public void weightTest() {
        List<Integer> nums = Arrays.asList(1, 2, 3);
        List<Integer> weights = Arrays.asList(1, 2, 10);
        List<Integer> arr = new ArrayList<>();
        int size = 0;

        for(int i=0; i< weights.size(); i++) {
            size+= weights.get(i);

            int j=weights.get(i);
            while (j != 0) {
                arr.add(nums.get(i));
                j--;
            }
        }

        Integer random = arr.get(new Random().nextInt(size));

        System.out.println(random);

        assertNotNull(random);
    }

    @Test
    public void getElementPosition() {
        int element = 12_345;
        int[] arr = generateRandomArray(1_000_000);
        Arrays.sort(arr);

        double pos = binarySearchRecursively(arr, element);
        System.out.println(pos);

        assertNotNull(pos);
    }

    private static int[] generateRandomArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(length);
        }
        return array;
    }

    private int binarySearchRecursively(int[] arr, int key) {
        return binarySearchRecursively(arr, key, 0, arr.length);
    }

    private int binarySearchRecursively(int[] arr, int key, int left, int right) {
        if(right < left) {
            return -1;
        }

        int middle = (left + right) / 2;

        if(key == arr[middle]) {
            return middle;
        } else if(key < arr[middle]) {
            return binarySearchRecursively(arr, key, left, middle - 1);
        } else {
            return binarySearchRecursively(arr, key, middle + 1, right);
        }
    }

    
}
