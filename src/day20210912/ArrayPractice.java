package day20210912;

import java.util.Arrays;

public class ArrayPractice {
    public static void main10(String[] args) {
        String s;
        System.out.println("s=");
    }
    public static void reverse(int[] array){
        int left = 0;
        int right = array.length-1;
        while(left < right){
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }
    //冒泡排序
    public static void bubbleSort(int[] array){
        for(int i = 0; i<array.length-1;i++){
            for(int j = 0; j < array.length-1-i;j++){
                if(array[j] > array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }
    //优化版
    public static void bubbleSort2(int[] array){
        boolean flg = false;//false代表没有发生交换
        for(int i = 0; i<array.length-1;i++){
            flg = false;
            for(int j = 0; j < array.length-1-i;j++){
                if(array[j] > array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flg = true;
                }
            }
            if(flg == false){
                break;
            }
        }
    }
    public static void swap(int[] array){
        int left = 0;
        int right = array.length-1;
        while(left < right){
            while(left < right && array[left] % 2 == 0){//偶数就++
                left++;
            }
            //left遇到奇数了
            while(left < right && array[right] % 2 != 0){
                right--;
            }
            //right遇到偶数了
            if(left < right){
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
            }
        }
    }

    public static void main8(String[] args) {
        int[] array = {2,3,1,6,7};
        swap(array);
        System.out.println(Arrays.toString(array));
    }
    public static void main7(String[] args) {
        //int[] array = {12,3,2,5,4,8,10};
        //int[] array = {1,2,3,4,5,6};
        int[] array = {2,3,1,6,7};
        bubbleSort2(array);
        //reverse(array);
        //swap(array);
        System.out.println(Arrays.toString(array));

    }
    public static boolean isUp(int[] array){
        for(int i = 0;i<array.length-1;i++){
            if(array[i] > array[i+1]){
                return false;
            }
        }
        return true;
    }
    public static void main6(String[] args) {
        int[] array = {1,2,3,10,5,6};
        boolean ret = isUp(array);
        System.out.println(ret);
    }
    //顺序查找
    public static int find(int[] array,int key){
        for(int i = 0; i < array.length;i++){
            if(array[i] == key){
                return i;
            }
        }
        return -1;
    }
    //二分查找
    public static int binarySearch(int[] array,int key){
        int left = 0;
        int right = array.length-1;
        while(left <= right) {
            int mid = (left+right)>>>1;
            if (array[mid] < key) {
                left = mid+1;
            } else if (array[mid] == key) {
                return mid;
            } else {
                right = mid-1;
            }
        }
        return -1;
    }

    public static void main5(String[] args) {
        int[] array = {12,2,18,24,76,13};
        //int ret = binarySearch(array,8);
        //System.out.println("下标:"+ret);
        System.out.println(Arrays.binarySearch(array,18));
    }
    public static void main4(String[] args) {
        int[] array = {12,2,18,24,76,13};
        int ret = find(array,8);
        System.out.println("下标:"+ret);
    }
    public static int maxArray(int[] array){
        int max = array[0];
        for( int i = 1; i < array.length; i++){
            if(max < array[i]){
                max = array[i];
            }
        }
        return max;
    }
    public static void main3(String[] args) {
        int[] array = {12,76,18,24,2,13};
        int ret = maxArray(array);
        System.out.println(ret);
    }
    public static int[] copyArray(int [] array){
        int len = array.length;
        int [] arr = new int[len];
        for(int i = 0; i < len;i++){
            arr[i] = array[i];
        }
        return arr;
    }
    public static void main2(String[] args) {
        int [] array = {1,2,3,4,5,6,7};
        //int [] ret =  copyArray(array);
        //System.out.println(Arrays.toString(ret));
        int [] ret = Arrays.copyOf(array,array.length);
        System.out.println(Arrays.toString(ret));

    }
    public static String myToString(int [] array){
        String ret = "[";
        for(int i = 0 ; i < array.length; i++){
            ret  +=array[i];
            if(i != array.length-1){
                ret += ",";
            }
        }
        ret +="]";
        return ret;
    }
    public static void main1(String[] args) {
        int[] array ={21,12,34,5,6,7};
        System.out.println(Arrays.toString(array));

    }
}
