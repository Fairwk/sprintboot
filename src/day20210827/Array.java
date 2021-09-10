package day20210827;

import java.util.Arrays;

public class Array {
    public static int[] putNum(int [] arr){
        for(int i = 0;i<100;i++){
            arr[i] = i+1;
        }
        return arr;
    }
    public static void main(String[] args) {
        int [] arr = new int[100];
        System.out.println(Arrays.toString(putNum(arr)));
    }
    public static void printArray(int [] arr){
        for(int a:arr){
             System.out.println(a);
        }
    }
    public static void main4(String[] args) {
        int [] arr = {1,2,3,4,5,6};
        printArray(arr);

    }
    public static int [] transform(int [] arr){
        int [] tmp = new int[arr.length];
        for(int i = 0;i<arr.length;i++){
            tmp[i] = arr[i]*2;
        }
        return tmp;
    }
    public static void main3(String[] args) {
        int [] arr = {1,2,3};
        int [] ret = transform(arr);
        System.out.println(Arrays.toString(ret));

    }
    public static void main2(String[] args) {
        int [] arr = {1,2,3,4,5,6};
        int sum = 0;
        for(int i = 0; i<arr.length;i++){
            sum = sum+arr[i];
        }
        System.out.println("和为:"+sum);
    }
    public static double avg(int [] arr){
        int sum = 0;
        for(int x :arr){
            sum += x;
        }
        return (double)sum/(double)arr.length;
    }
    public static void main1(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8};
        System.out.println(avg(arr));
    }
}
