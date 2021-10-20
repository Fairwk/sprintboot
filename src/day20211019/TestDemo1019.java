package day20211019;

import java.util.Scanner;

public class TestDemo1019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(func(str,n));

    }
    public static String func(String str,int n){
        if(str == null || n <= 0 || n >=str.length()){
            return null;
        }
        String str1 = reverse(str,0,n-1);
        String str2 = reverse(str1,n,str.length()-1);
        String ret = reverse(str2,0,str.length()-1);
        return ret;
    }
    public static String reverse(String str,int begin,int end){
        char[] value = str.toCharArray();
        while(begin < end) {
            char tmp = value[begin];
            value[begin] = value[end];
            value[end] = tmp;
            begin++;
            end--;
        }
        //return new String(value);
        return String.copyValueOf(value);
    }
    public static void main2(String[] args) {
        String str = "abcdefg";
        String ret = reverse(str,0,str.length()-1);
        System.out.println(ret);
    }
    public static String func(String str){
        String[] strings = str.split(" ");
        String ret = "";
        for(String s : strings){
            ret +=s;
        }
        return ret;
    }
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String ret = func(str);
        System.out.println(ret);


    }
}
