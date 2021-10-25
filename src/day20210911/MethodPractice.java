package day20210911;


import java.util.Scanner;
//递归求斐波那契数列
public class MethodPractice {
    public static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
    //非递归求斐波那契数列
    public static int fib2(int n){
        int f1 = 1;
        int f2 = 1;
        int f3 = 0;
        for(int i = 3; i <= n; i++){
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
    public static void main(String[] args) {
        int ret = fib2(10);
        System.out.println(ret);
    }
    public static int func(int n){
        if(n < 10){
            return n;
        }
        return n%10+func(n/10);
    }
    public static void main6(String[] args) {
        int ret = func(1729);
        System.out.println(ret);
    }
    public static int sumNum(int n){
        if(n == 1){
            return 1;
        }
        return n+sumNum(n-1);
    }
    public static void main5(String[] args) {
        int ret = sumNum(10);
        System.out.println(ret);
    }
    public static void fac1(int n){
        if(n > 9){
            fac1(n/10);
        }
        System.out.println(n%10);
    }
    public static void main4(String[] args) {
        fac1(1234);

    }
    public static int sum(int num1,int num2){
        return num1 + num2;
    }
    public static double sum(double num1,double num2){
        return num1 + num2;
    }
    public static int sum(int num1,int num2, int num3){
        return num1 + num2 + num3;
    }
    public static double sum(double num1,int num2,double num3,int num4){
        return num1 + num2 + num3 + num4;
    }
    public static void main3(String[] args) {
        System.out.println(sum(1,2));
        System.out.println(sum(1.1,2.2));
        System.out.println(sum(4,5,6));
        System.out.println(sum(1.1,2,3.3,4));
    }
    public static void main2(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i = 31; i >= 1;i -= 2){
            System.out.print(((n >> i)&1)+" ");
        }
        System.out.println();
        for(int i = 30; i >= 0 ; i -= 2){
            System.out.print(((n >> i)&1)+" ");

        }
    }
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int count = 0;
        for(int i = 0; i < 32; i++){
            if(((n>>i)&1)==1){
                count++;
            }
        }
        System.out.println("count:"+count);
    }
}
