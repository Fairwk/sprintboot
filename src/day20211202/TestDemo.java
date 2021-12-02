package day20211202;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.function.Consumer;

//无返回值无参数
@FunctionalInterface
interface NoParameterNoReturn {
    void test();
}
//无返回值一个参数
@FunctionalInterface
interface OneParameterNoReturn {
    void test(int a);
}
//无返回值多个参数
@FunctionalInterface
interface MoreParameterNoReturn {
    void test(int a,int b);
}
//有返回值无参数
@FunctionalInterface
interface NoParameterReturn {
    int test();
}
//有返回值一个参数
@FunctionalInterface
interface OneParameterReturn {
    int test(int a);
}
//有返回值多参数
@FunctionalInterface
interface MoreParameterReturn {
    int test(int a,int b);
}
public class TestDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("bit");
        list.add("hello");
        list.add("lambda");
        /*list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        */
        list.forEach((s)-> System.out.println(s));

    }
    public static void main2(String[] args) {
        NoParameterReturn noParameterReturn = ()->{
            return 1;
        };
        int ret = noParameterReturn.test();
        System.out.println(ret);
        //当lambada表达式 只有一个语句的时候 可以省略花括号
        NoParameterReturn noParameterReturn2 = ()->1;
        ret = noParameterReturn.test();
        System.out.println(ret);

        System.out.println("==============");
        //OneParameterReturn oneParameterReturn = (a)->{return a;};
        //OneParameterReturn oneParameterReturn = (a)->a;
        OneParameterReturn oneParameterReturn = a->a;
        ret = oneParameterReturn.test(10);
        System.out.println(ret);

        System.out.println("==============");
        //MoreParameterReturn moreParameterReturn = (int a,int b)->{return a+b;};
        //MoreParameterReturn moreParameterReturn = (a,b)->{return a+b;};
        MoreParameterReturn moreParameterReturn = (a,b)->a+b;
        ret = moreParameterReturn.test(10,20);
        System.out.println(ret);
    }
    public static void main1(String[] args) {
        NoParameterNoReturn noParameterNoReturn = ()->{
            System.out.println("hhh");
        };
        noParameterNoReturn.test();

        OneParameterNoReturn oneParameterNoReturn = (a)->{
            System.out.println(a);
        };
        oneParameterNoReturn.test(10);

        MoreParameterNoReturn moreParameterNoReturn = (a,b)->{
            System.out.println(a+b);
        };
        moreParameterNoReturn.test(10,20);
    }
}
