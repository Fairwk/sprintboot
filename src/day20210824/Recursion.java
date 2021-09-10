package day20210824;

import java.util.Scanner;

public class Recursion {
    public static int JieCheng(int n){
        if(n<0){
            return 0;
        }else if(n == 1){
            return 1;
        }else{
            return n*JieCheng(n-1);
        }
    }
    public static void main(String[] args) {
        System.out.println(JieCheng(5));

    }
    public static int SumNum(int n){
        if (n < 10) {
            return n;
        }else{
            return n%10 + SumNum(n/10);
        }
    }
    public static void main7(String[] args) {
        System.out.println("请输入一个整数:");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(num + "每一位数字之和为:"+SumNum(num));
    }
    public static int QingWa(int n){
        if(n == 1){
            return 1;
        }else if(n ==2){
            return 2;
        }else{
            return QingWa(n-1)+QingWa(n-2);
        }
    }
    public static void main6(String[] args) {
        int n = 5;
        System.out.println(QingWa(n));
    }
    public static int fib(int n){
        if(n==1||n==2){
            return 1;
        }else{
            return fib(n-1)+fib(n-2);
        }
    }
    public static void main5(String[] args) {
        int ret = fib(10);
        System.out.println(ret);
    }

    public static void fun(int n){
        if(n>9){
            fun(n/10);
        }
        System.out.println(" "+n%10+" ");
    }
    public static void main4(String[] args) {
        System.out.println("输入数字:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("每一位数字为: ");
        fun(n);
    }
    public static int add(int x,int y){
        return x+y;
    }
    public static double add(double x,double y, double z){
        return x+y+z;
    }
    public static void main3(String[] args) {
        int a = add(1,2);
        double b = add(1.1,2.2,3.3);
        System.out.println("a="+a);
        System.out.println("b="+b);

    }
    public static int compare(int x,int y){
        int max = 0;
        if(x>y){
            max = x;
        }else{
            max = y;
        }
        return max;
    }
    public static double compare(double x,double y){
        return x > y ? x : y;
    }
    public static double compare(double x,double y,int z){
        return Math.max(Math.max(x,y),z);
    }
    public static void main2(String[] args) {
        double i = 1.1;
        double j = 2.2;
        int a = 3;
        System.out.println("最大数为:"+compare(i,j,a));
    }
    public static long sum(int n){
        if(n==1){
            return 1;
        }else{
            return sum(n-1)+n;
        }
    }
    public static void main1(String[] args) {
        System.out.println(sum(10));
    }
}
