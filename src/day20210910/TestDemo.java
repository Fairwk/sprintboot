package day20210910;

import java.util.Random;
import java.util.Scanner;

public class TestDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = 3;
        while(count != 0){
            System.out.println("请输入你的密码: ");
            String password = scan.nextLine();
            if(password.equals("123456")){//equals是用来判断两个字符串内容是否相等
                System.out.println("你的密码输入正确,登陆成功!");
                break;
            }else{
                count--;
                System.out.println("你还有"+count+"次机会!");
            }
        }
    }
    public static void main11(String[] args) {
        for(int n = 1;n <= 999999;n++){
            int count = 0;
            int tmp = n;
            while(tmp != 0){
                count++;
                tmp = tmp/10;
            }
            tmp = n;
            int sum = 0;
            while(tmp != 0){
               sum += Math.pow(tmp%10,count);//3的count次方   2的count次方  1的count次方
                tmp = tmp/10;
            }
            if(sum == n){
                System.out.println(sum+"is my result!");
            }
        }
    }
    //打印1-100中有多少9
    public static void main10(String[] args) {
        int count = 0;
        for(int i = 1; i <= 100; i++){
            if(i / 10 == 9){
                count++;
            }else if(i % 10 == 9){
                count++;
            }
        }
        System.out.println(count);
    }
    //1/1-1/2+1/3-1/4+1/5....+1/99-1/100
    public static void main9(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        double sum = 0;
        int flg = 1;
        for(int i = 1;i <= n;i++){
            sum = sum + 1.0/i *flg;//因为1/2以及后面的都是小数所以要用1.0来保证
            flg = -flg;//第一次执行完变为-1,执行完第二次负负得正又变为1,从而解决一正一负的要求
        }
        System.out.println(sum);
    }
    //最大公约数
    public static void main8(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = b;
        while(a % b != 0){
            c = a % b;//6
            a = b;//18
            b = c;//6
        }
        System.out.println(c);
    }
    public static void main7(String[] args) {
        for(int i = 1; i <= 9; i++){
            for(int j = 1; j <= i;j++){
                System.out.print(i + "*" + j+"="+i*j +" ");
            }
            System.out.println();
        }
    }
    public static void main6(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int year = 1000; year <= n;year++){
            if(year % 4 ==0 && year % 100 != 0 || year %400 == 0){
                System.out.println(year+"是闰年! ");
            }
        }
    }
    public static void main5(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            int j = 2;
            for (; j <= (int) Math.sqrt(i); j++) {
                if (i % j == 0) {
                    //System.out.println(n+"不是素数!");
                    break;
                }
            }
            if (j > (int) Math.sqrt(i)) {
                System.out.println(i + "是素数! ");
            }
        }
    }

    public static void main4(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i = 2;i< (int)Math.sqrt(n);i++){
            if(n % i == 0){
                System.out.println(n+"不是素数!");
                break;
            }
        }

    }
    public static void main3(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        int randNum = random.nextInt(100);//[0,100)
        //System.out.println(randNum);
        while(true){
            System.out.println("请输入你要猜的数字: ");
            int num = scan.nextInt();
            if(num < randNum){
                System.out.println("你猜的数字小了! ");
            }else if(num == randNum){
                System.out.println("你猜的数字对了! ");
                break;
            }else{
                System.out.println("你猜的数字大了! ");
            }
        }
    }
    public static void main2(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int sum = 0;
        for(int i = 1;i <= num; i++){
            int ret = 1;
            for(int j = 1; j <= i ; j++){
                ret *= j;
            }
            sum += ret;
        }
        System.out.println(sum);
    }
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        while(num <= 20){
            if(num % 15 == 0){
                System.out.println(num);
                //continue;
                break;
            }
            System.out.println("hhhhh");
            num++;
        }
    }
}
