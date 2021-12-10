package test1;

public class LeapYear {
    public static void main(String[] args){
        int year = 2003;
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
            System.out.println(year + "是闰年!");
        }else{
            System.out.println(year + "不是闰年!");
        }
    }
}
