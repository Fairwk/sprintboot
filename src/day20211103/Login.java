package day20211103;


import java.util.Scanner;

public class Login {

    private static String name = "Fairy";
    private static String password = "123456";

    public static void main(String[] args) throws PasswordException,NameException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名: ");
        String name = scanner.next();
        System.out.println("请输入密码: ");
        String password = scanner.next();
        login(name,password);

    }
    public static void login(String name,String password) throws PasswordException,NameException{
        if(!Login.name.equals(name)){
            throw new NameException("用户名错误");
        }
        if(!Login.password.equals(password)){
            throw new PasswordException("密码错误");
        }
        System.out.println("登陆成功! ");
    }
    public static class NameException extends Exception{
        public NameException(String message){
            super(message);
        }
    }
    public static class PasswordException extends Exception {
        public PasswordException(String message) {
            super(message);
        }
    }
}
