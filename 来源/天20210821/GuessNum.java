package day20210821;

import java.util.Random;
import java.util.Scanner;

public class GuessNum {
    //打印输出一个整数的每一位
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
        }else{//这个else对应count<10，也就是说当数字不是一位数的时候进入else
            for(k=i;k>0;k--){//循坏打印多位数的每一位
                m=count;t=1;
                for(j=0;j<k-1;j++){//当打印最后一位是不需要进入这个条件，所以j<k-1
                    t*=10;
                }
                m=m/t;m=m%10;
                System.out.println(m+" ");
            }
        }

    }
    //模拟登录
    public static void main4(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {//只有三次机会
            System.out.println("请输入密码:");
            String password = sc.nextLine();
            if ("abcde".equals(password)) {
                System.out.println("登录成功!");
                break;
            }else if (i == 2) {
                System.out.println("本次机会已用完请明天再来!");
            } else {
                System.out.println("输入错误,还剩下" + (2 - i) + "次机会");
            }
        }
    }
    public static void odd(int num){//打印偶数位
        //因为打印偶数位所以i为30，当num右移30位时此时为第一个偶数位，然后依次向后移，就是要打印2，4，... , 32
        //1的二进制位写出来就是前面全是0，最后一位是1，所以当num右移时应该保证此时打印的那一位在最后一位，
        //所以移30位保证目前打印的那一位在最后一位让他跟1相与，两位都是1才能是1，依次类推就能打印出所有偶数位
        for(int i = 30;i >= 0;i=i-2){
            if((（num >> i) & 1) != 0){
                System.out.println("1");
            }else{
                System.out.println("0");
            }
        }
    }
    public static void even(int num）{//打印奇数位与上面类似
        for(int i = 31;i >= 0;i=i-2){
            if(((num >> i) & 1)!=0){
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
    public static int NumberOf(int n) {//打印一个整数二进制中的所有1
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {//所以n（也就是输入的整数）与1相与，输入的整数哪一位有1当1移到那一位就会知道，因为相与两个都是1才是1
                count++;
            }
            flag = flag << 1;//让flag向左移也就是1向左移，因为1的二进制位前面全是0，只有最后一位是1，所以向左移等于让1遍历前面所有的位置
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
    //猜数字游戏
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int rand = random.nextInt(100)+1;//生成随机数，因为需要1-100的随机数，而random是[1,100),左闭右开的，所以需要给表达式加上1
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
