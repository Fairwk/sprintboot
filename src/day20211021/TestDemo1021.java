package day20211021;

public class TestDemo1021 {
    public static void main(String[] args) {
        boolean a,b,c;
        a=(4>1);
        b=(a == true);
        System.out.println("a="+a+"b="+b);
        c=(b==false);
        System.out.println("b="+b+"c="+c);
    }

    public static void main1(String[] args) {
        MyArrayList myArrayList1 = new MyArrayList();
        //myArrayList1.add(0,12);
        //myArrayList1.add(1,22);
        //myArrayList1.add(2,32);
        //myArrayList1.add(3,42);
        for(int i = 0; i < 10; i++){
            myArrayList1.add(i,i);
        }
        myArrayList1.display();
        myArrayList1.add(10,112);
        myArrayList1.display();
        System.out.println("==================");
        System.out.println(myArrayList1.search(51));
        System.out.println(myArrayList1.contains(15));
        System.out.println(myArrayList1.getPos(4));
        myArrayList1.remove(4);
        myArrayList1.display();
        myArrayList1.clear();
        myArrayList1.display();
    }
}
