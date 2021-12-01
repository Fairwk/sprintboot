package testenum;

import java.lang.reflect.Constructor;
//自己写的枚举类会自动继承Enum
public enum TestEnum {
    RED("red",1),BLACK("black",2),
    GREEN("green",3),WHITE("white",4);
    private String name;
    private int ordinal;
    //枚举的构造方法默认是私有的
    TestEnum(String name,int ordinal){
        this.name = name;
        this.ordinal = ordinal;
    }
    public static TestEnum getEnumKey (int ordinal){
        for (TestEnum t: TestEnum.values()) {
            if(t.ordinal == ordinal) {
                return t;
            }
        }
        return null;
    }

    public static void reflectPrivateConstructor(){
        try{
            //1.获取Class对象
            Class<?> c = Class.forName("testenum.TestEnum");
            //2.获取构造方法
            Constructor<?> constructor = c.getDeclaredConstructor(String.class,int.class,String.class,int.class);

            constructor.setAccessible(true);
            //3.获取对象的实例
            TestEnum testEnum = (TestEnum) constructor.newInstance("kun",18,"hhh","456");
            System.out.println(testEnum);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        reflectPrivateConstructor();
    }

    public static void main3(String[] args) {
        System.out.println(getEnumKey(2));
    }
    public static void main2(String[] args) {
        //以数组的形式返回所有成员
        TestEnum[] testEnums = TestEnum.values();
        for (int i = 0; i < testEnums.length; i++) {
            System.out.println(testEnums[i] +" " + testEnums[i].ordinal());//获取枚举成员的位置

        }
        System.out.println(TestEnum.valueOf("GREEN"));
        //把普通字符转换为枚举实例,若枚举里不包含该字符则会报错
        System.out.println("===============");
        System.out.println(GREEN.compareTo(WHITE) );
        //比较两个枚举成员在定义时的顺序
    }
    public static void main1(String[] args) {
        TestEnum testEnum2 = TestEnum.BLACK;
        switch (testEnum2) {
            case RED:
                System.out.println("red");
                break;
            case BLACK:
                System.out.println("black");
                break;
            case WHITE:
                System.out.println("WHITE");
                break;
            case GREEN:
                System.out.println("black");
                break;
            default:
                break;
        }
    }

}
