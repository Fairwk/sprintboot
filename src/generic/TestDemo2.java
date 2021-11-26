package generic;

import java.util.ArrayList;

/*
写一个泛型类,求泛型数组当中的最大值
因为用<>写都是引用类型,所以不能用< >进行比较,
要进行比较需要实现两个接口,但是当前代码一运行就会擦除到Object,
Object没有实现接口,所以我们要控制不要擦除到Object,所以你要给泛型边界
泛型是没有下界的

 */
class Algorithm<T extends Comparable<T>>{//泛型的上界 擦除到实现了这个接口的地方 换句话说 将来这个T类型 一定是实现了这个接口的
    public T findMax(T[] array){
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(max.compareTo(array[i]) < 0){
                max = array[i];
            }
        }
        return max;
    }
}
class Algorithm2{
    //泛型方法
    public static<T extends Comparable<T>> T findMax(T[] array){
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(max.compareTo(array[i]) < 0){
                max = array[i];
            }
        }
        return max;
    }
}

class Test{
    //适合于 写东西
    public static<T> void print(ArrayList<T> list){
        for (T t: list) {
            System.out.println(t);
        }
    }
    //? 代表通配符 擦出机制 擦成Object 适合于 读东西
    //一般通配符都存在于源码中
    //上界 : <? extends 上界> 跟泛型一样
    //下界 : <? super 下界> 传入的类型是下界的父类或者是下界本身
    public static void print2(ArrayList<?> list){
        for (Object t: list) {
            System.out.println(t);
        }
    }
}
public class TestDemo2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Test.print2(list);
    }
    public static void main2(String[] args) {
        Integer[] integers = {1,2,13,4,5};
        //会根据 形参的类型 已导出 整个泛型的类型参数
        Integer ret = Algorithm2.findMax(integers);
        System.out.println(ret);
        //一般就会省略
        Integer ret2 = Algorithm2.<Integer>findMax(integers);
        System.out.println(ret2);

    }
    public static void main1(String[] args) {
        Algorithm<Integer> algorithm1 = new Algorithm<>();
        Integer[] integers = {1,2,13,4,5};
        Integer ret = algorithm1.findMax(integers);
        System.out.println(ret);
    }
}
