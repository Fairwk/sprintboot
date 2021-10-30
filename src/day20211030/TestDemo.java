package day20211030;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>(30);
        ArrayList<Integer> list3 = new ArrayList<>(list1);
    }
    public static void main2(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(22);
        list.add(42);
        list.add(22);
        System.out.println(list);

        //1.subList(1,4) ---> [1,4)
        //2.subList并不是截取出来的新数组而是指向原来的数组

        List<Integer> eList = list.subList(1,4);
        System.out.println(eList);
        System.out.println("=============");
        eList.set(1,133);
        System.out.println("修改截取的 : " + eList);
        System.out.println("原来的 : " + list);
        /*System.out.println(list.indexOf(22));
        System.out.println(list.lastIndexOf(22));

        //list.set(1,100);
        //System.out.println(list);

        /*boolean flg = list.contains(11);
        System.out.println(flg);*/

        /*list.clear();
        System.out.println("============");
        System.out.println(list);*/

        /*int x = list.remove(1);
        System.out.println(x);

        boolean flg = list.remove(list.get(1));
        System.out.println(flg);
        System.out.println(list);

        int x = list.get(0);
        System.out.println(x);*/


    }
    public static void main1(String[] args) {
        //顺序表
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(0,20);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list.addAll(list2);
        System.out.println(list);
        Iterator<Integer> it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
