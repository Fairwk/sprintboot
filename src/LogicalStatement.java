import java.util.Scanner;

public class LogicalStatement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int i = 1;
        if(a == 0 || b == 0){
            System.out.println(a==0 ? b : a);
        }else{
            for(int j = 2; j <= a && j <= b;j++){
                if(a %j == 0 && b % j ==0){
                    i = j;
                }
            }
            System.out.println(i);
        }
    }
    public static void main9(String[] args) {
        double n = 0.0;
        double i = 1.0;
        double tem = 0.0;
        double sum = 0.0;
        for(n=1;n<101;n++){
            i=-i;
            tem=(1/n)*i;
            sum+=tem;
        }
        System.out.println(sum);
    }
    public static void main8(String[] args) {
        int cut = 0;
        for(int i = 2;i <=100; i++){
            for(int j = 2; j <= i;j++){
                if(i % j ==0 && i != j ){
                    break;
                }
                if(j==i){
                   System.out.println(j+" ");
                   cut++;
                }
            }
        }
    }
    public static void main7(String[] args) {
        int i = 0;
        for(int a = 1; a <= 100;a++){
            if(a/10==9){
                i++;
            }
            if((a%10)==9) {
                i++;
            }
        }
        System.out.println("1到100中有"+i+"个9");
    }
    public static void main6(String[] args) {
        for(int i = 0;i<1000;i++){
            int a = i / 100;
            int b = i % 100 / 10;
            int c = i % 10;
            if(a*a*a+b*b*b+c*c*c==i){
                System.out.println(i+"是水仙花数");
            }
        }
    }
    public static void main5(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int x = sc.nextInt();
            char[][] arr = new char[x][x];//以用户输入的数字创建一个相同大小的二维数组
            //设置数组全为空格
            for(int i = 0; i<x;i++){
                for(int j = 0;j<x;j++){
                    arr[i][j]=' ';
                }
            }
            //利用下标设置x
            for(int i = 0;i<x;i++){
                int left = 0;
                int right = x-1;
                for(;left<x && right >=0;left++,right--){
                    arr[i][i] = '*';
                    arr[left][right] = '*';
                }
            }
            //打印数组
            for(int i = 0;i<x;i++){
                for(int j=0;j<x;j++){
                    System.out.printf("%c",arr[i][j]);
                }
                System.out.println();
            }
        }
    }
    public static void multiplicationTable(int n){
        int i = 1;
        int j = 1;
        for(i=1;i<=n;i++){
            for(j=1;j<=i;j++){
                System.out.println(j+"*"+i+"="+j*i+" ");
            }
            System.out.println();
        }
    }
    public static void main4(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        multiplicationTable(n);

    }
    public static void main3(String[] args){
        Scanner sc =new Scanner(System.in);
        System.out.println("请输入需要判断的年龄");
        while(sc.hasNext()){
            int age = sc.nextInt();
            String tmp;
            if(age<0){
                System.out.println("输入有误!");
                break;
            }
            if(age<=18){
                tmp = "early youth";
            }else if(age >= 19 && age <=28){
                tmp = "youth";
            }else if(age > 28 && age <= 55){
                tmp = "middle age";
            }else{
                tmp = "old age";
            }
            switch(tmp){
                case"early youth":
                    System.out.println(age+"岁是少年人");
                    break;
                case"youth":
                    System.out.println(age+"岁是青年人");
                    break;
                case"middle age":
                    System.out.println(age+"岁是中年人");
                    break;
                case"old age":
                    System.out.println(age+"岁是老年人");
                    break;
                default:
                    break;
            }
        }
    }
    public static void main2(String[] args){
        int num = 7;
        int i = 0;
        if(num < 2){
            System.out.println("不是素数!");
        }else if(num==2){
            System.out.println("是素数!");
        }else{
            for(i = 2;i<num;i++){
                if(num%i==0){
                    System.out.println("不是素数!");
                    break;
                }else if(i==(num-1)){
                    System.out.println("是素数!");
                    break;
                }
            }
        }
    }
    public static void main1(String[] args){
        for(int year = 1000;year <= 2000;year++){
            boolean Isleapyear=false;
            if(year % 4 == 0 && year % 100 !=0) {
                Isleapyear = true;
            }
            if(year%400==0){
                Isleapyear = true;
            }
            if(Isleapyear){
                System.out.printf(year+" ");
            }
        }
    }
}
