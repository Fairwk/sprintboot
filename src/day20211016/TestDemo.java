package day20211016;

public class TestDemo {
    public static boolean func(String str){
        for (int i = 0; i < str.length();i++){
            char ch = str.charAt(i);
            if(ch < '0' || ch > '9'){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "12345a6";
        boolean flg = func(str);
        System.out.println(flg);
    }
    public static void main2(String[] args) {
        String str1 = "hello";
        String str2 = new String("hello");
        System.out.println(str1 == str2);
        String str3 = "hello";
        System.out.println(str1 == str3);
    }
    public static void main1(String[] args) {
        String str = "hello";
        System.out.println(str);
        String str2 = new String("abcdef");
        System.out.println(str2);
        char[] val = {'a','b','c','d','e','f','g'};
        String str3 = new String(val);
        System.out.println(str3);
    }
}
