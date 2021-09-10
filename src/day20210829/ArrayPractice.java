package day20210829;

import java.util.Arrays;

public class ArrayPractice {
    public static String toString(int [] array){
        String ret = "[";
        for(int i= 0;i<array.length;i++){
            ret+=array[i];
            if(i<array.length-1){
                ret+=",";
            }
        }
        ret+="]";
        return ret;
    }
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6};
        System.out.println("转换后:");
        System.out.println(toString(arr));
    }
    public static int[] copyOf(int [] array){
        int [] arr = new int[array.length];
        for(int i = 0;i<array.length;i++){
            arr[i] = array[i];
        }
        return arr;
    }
    public static void main4(String[] args) {
        int [] arr = {1,2,3,4,5,6};
        int [] newarr = copyOf(arr);
        System.out.println(Arrays.toString(newarr));
    }
    public static int HalfFind(int [] array,int x){
        int left = 0;
        int right = array.length-1;
        while(left<=right){
            int mid = (left+right) / 2;
            if(array[mid] == x){
                return mid;
            }else if(array[mid]>x){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }
    public static void main3(String[] args) {
        int [] arr = {1,2,3,4,5,6};
        System.out.println(HalfFind(arr,3));
    }
    public static boolean isSorted(int [] array){
        for(int i = 0;i<array.length-1;i++){
            if(array[i] > array[i+1]){
                return false;
            }
        }
        return true;
    }
    public static void main2(String[] args) {
        int [] array = {1,2,3,4,5};
        System.out.println(isSorted(array));

    }
    public static void BubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }
    public static void main1(String[] args) {
        int [] arr = {2,1,3,9,6,4,5};
        System.out.println("排序前:");
        System.out.println(Arrays.toString(arr));
        BubbleSort(arr);
        System.out.println("排序后:");
        System.out.println(Arrays.toString(arr));
    }
}
