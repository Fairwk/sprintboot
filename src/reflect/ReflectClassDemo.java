package reflect;

import java.lang.reflect.Constructor;
import java.lang.Class;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectClassDemo {
    public static void reflectNewInstance() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> c3 = Class.forName("reflect.Student");
        Object o = c3.newInstance();
        Student student = (Student) o;
        System.out.println(student);
    }
    public static void reflectPrivateConstructor(){
        try{
            Class<?> c3 = Class.forName("reflect.Student");
            Constructor<?> constructor = c3.getDeclaredConstructor(String.class,int.class);
            //私有的属性或者方法需要设置
            constructor.setAccessible(true);
            Object stu = constructor.newInstance("kun", 18);
            Student student = (Student) stu;
            System.out.println(student);

        }catch(Exception e){

        }
    }
    // 反射私有属性
    public static void reflectPrivateField(){
        try{
            Class<?> c3 = Class.forName("reflect.Student");
            Field field = c3.getDeclaredField("name");
            field.setAccessible(true);
            Student student = (Student) c3.newInstance();
            //设置student这个字段的值为hhhh
            field.set(student,"hhhh");
            System.out.println(student);

        }catch(Exception e){

        }

    }
    // 反射私有方法
    public static void reflectPrivateMethod() {
        try {
            Class<?> classStudent = Class.forName("reflect.Student");
            Method methodStudent = classStudent.getDeclaredMethod("function", String.class);
            System.out.println("私有方法的方法名为：" + methodStudent.getName());
//私有的一般都要加
            methodStudent.setAccessible(true);
            Object objectStudent = classStudent.newInstance();
            Student student = (Student) objectStudent;
            //反射调用的方法 是使用invoke  代表: 调用student这个对象methodStudent 表示的方法,并且传参
            methodStudent.invoke(student, "我是给私有的function函数传的参数");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        reflectPrivateMethod();
    }
}
