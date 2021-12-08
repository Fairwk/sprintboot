package day20210821;

import java.util.Random;
import java.util.Scanner;

public class GuessNum {
    public static void main5(String[] args) {
        System.out.println("请输入一个人整数:");
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int m,i = 1,j,t,k;
        m=count;
        while(m>9){
            m=m/10;
            i++;
        }
        if(count>9){
            System.out.println(count+"是"+i+"位数");
        } if(count <10){
            System.out.println(count+"是一位数:"+count);
        }else{
            for(k=i;k>0;k--){
                m=count;t=1;
                for(j=0;j<k-1;j++){
                    t*=10;
                }
                m=m/t;m=m%10;
                System.out.println(m+" ");
            }
        }

    }
    public static void main4(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入密码:");
            String password = sc.nextLine();
            if ("abcde".equals(password)) {
                System.out.println("登录成功!");
                break;
            }else if (i == 2) {
                System.out.println("本次机会已用完请明天再来!");
            } else {
                System.out.println("录入错误,还剩下" + (2 - i) + "次机会");
            }
        }
    }
    public static void odd(int num){
        for(int i = 30;i >= 0;i=i-2){
            if((num&(1 << i)) != 0){
                System.out.println("1");
            }else{
                System.out.println("0");
            }
        }
    }
    public static void even(int num){
        for(int i = 31;i >= 0;i=i-2){
            if((num & (1 << i))!=0){
                System.out.println("1");
            }else{
                System.out.println("0");
            }
        }
    }
    public static void main3(String[] args) {
        int num = 14;
        int check = 0;
        odd(num);
        System.out.println();
        even(num);
    }
    public static int NumberOf(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int ans = NumberOf(n);
            System.out.println(ans);

        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int rand = random.nextInt(100)+1;
        while(true){
            System.out.println("请输入一个数字:");
            int num = sc.nextInt();
            if(num > rand){
                System.out.println("高了!");
            }else if(num < rand){
                System.out.println("低了!");
            }else{
                System.out.println("猜对了!");
                break;
            }
        }
        System.out.println("游戏结束!");
        sc.close();
    }
}
