package Test;

import java.util.Random;
import java.util.Scanner;

public class guessnum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int rand = random.nextInt(100)+1;
        int times = 10;
        while(times > 0){
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
