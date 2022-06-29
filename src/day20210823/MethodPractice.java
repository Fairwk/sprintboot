package day20210823;

import java.util.Arrays;
import java.util.Scanner;

public class MethodPractice {
    public static int fibonacci(int n){//斐波那契数数列      
        int a =0;
        int b = 1;
        int c = 0;
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }
        for(int i=2;i<=n;i++){
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ret = fibonacci(n);
        System.out.println(ret);
    }
    public static void main6(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9,10};
        for(int i=0; i<arr.length-1;i++){
            for(int j= 0; j< arr.length-1;j++){
                if (arr[j] % 2 == 0) {
                    int tmp = arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1]=tmp;
                }
            }
        }
        for(int i = 0;i<arr.length;i++){
            System.out.println(arr[i]+" ");
        }
    }
    public static void reOderArray(int [] array){
        int length = array.length;
        for(int i = 0;i<length;i++){
            for(int j = length-1;j>0;j--){
                if(array[j]%2 == 1 && array[j-1] % 2 == 0){
                    int tmp = array[j];
                    array[j]=array[j-1];
                    array[j-1]=tmp;
                }
            }
        }
    }
    public static void main4(String[] args) {
        int [] array = {1,2,3,4,5,6,7,8,9,10};

    }
    public static int getMax(int [] array){
        int max = array[0];
        for(int i= 1;i<array.length;i++){
            if(array[i]>max){
                max=array[i];
            }
        }
        return max;
    }
    public static void main5(String[] args) {
        int [] array = {5,15,35};
        int max = getMax(array);
        System.out.println("最大值: "+ max);
    }
    public static int FindNum(int [] arr){
        for(int i = 0;i<arr.length;i++){
            int count = 1;
            for(int j = 0; j<=arr.length;j++){
                if(i==j){
                    continue;
                }
                if(arr[i]==arr[j]){
                    count++;
                }
                if(count == 1){
                    return arr[i];
                }
            }
        }
        return 0;
    }

    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.substring(1,str.length()-1);
        String[] s = str.split(",");//将字符串以,分割,转为一个字符串数组
        int []arr = new int [s.length];//将字符串转为int型存入整型数组中
        for(int i = 0;i<arr.length;i++){
            arr[i]=Integer.parseInt(s[i]);
        }
        System.out.println(FindNum(arr));
    }
    public static int Circulation(int n){
        int ret = 1;
        for(int i = 1;i<=n;i++){
            ret*=i;
        }
        return ret;
    }
    public static void main2(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int ret = Circulation(n);
        System.out.println(n + "阶乘为:"+ ret);
    }
    public static int sumFac(int n){
        int sum = 0;
        for(int i = 1;i<=n;i++){
            int ret = 1;
            for(int j = 1; j<=i;j++){
                ret *= j;
            }
            sum+=ret;
        }
        return sum;
    }
    public static void main1(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int ret = sumFac(n);
        System.out.println(n + "阶乘和为:"+ ret);
    }
}
