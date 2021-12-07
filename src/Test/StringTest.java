package Test;

import java.util.Locale;

public class StringTest {
    public static void main(String[] args) {
        String s = "This is a java of the demo";
        System.out.println("字符串长度: " + s.length());
        System.out.println("字符串里第8个字符的位置是: "+s.charAt(8));
        System.out.println("第8个字符后面的子字符串是: "+s.substring(8));
        System.out.println("第8到15之间的子字符串是: "+ s.substring(8,15));
        System.out.println("测试字符串是否以He开头: "+s.startsWith("He"));
        System.out.println("将字符串全部转换为小写字符: "+s.toLowerCase());
        System.out.println("h第一次出现的位置是: "+s.indexOf("h"));
        System.out.println("h最后一次出现的位置是: "+s.lastIndexOf("h"));
    }
}
