package test2;

import java.util.Scanner;

public class TelephoneBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入通话时长:");
        int time = sc.nextInt();
        double money = 0;
        if(time > 100){
            money = 20 + (time - 100)*0.15;
            System.out.println("电话费为:" + money + "元");
        }else{
            money = 20;
            System.out.println("电话费为:" + money + "元");
        }

    }
}
