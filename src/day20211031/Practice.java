package day20211031;

import java.util.ArrayList;
import java.util.Collections;

class Student implements Comparable<Student>{
    private String name;
    private int age;

    public Student(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.age - o.age;
    }
}

public class Practice {
    public static void main(String[] args) {
        String str1 = "welcome to bit";
        String str2 = "come";
        ArrayList<Character> list = new ArrayList<>();
        for(int i = 0; i < str1.length(); i++){
            char ch = str1.charAt(i);
            if(!str2.contains(ch+"")){
                list.add(ch);
            }
        }
        System.out.println(list);

        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i));
        }

    }
    public static void main1(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(3);
        Collections.sort(list);
        System.out.println(list);
    }
    public static void main2(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("bit",19));
        students.add(new Student("kun",29));
        students.add(new Student("ming",9));
        System.out.println(students);
        //对自定义类型进行排序 需要实现接口
        Collections.sort(students);
        System.out.println(students);


    }

}
