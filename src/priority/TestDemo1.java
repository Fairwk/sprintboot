package priority;

import java.util.*;

/*
对象之间的比较(对于自定义类型来说)
第一种方法实现接口重写compareTo方法(这种方法侵占性太强)
implements Comparable<student>

@Override
    public int compareTo(student o) {
        return o.age-age;
    }
第二种方法:实现比较器
class AgeComparator implements Comparator<student>
 */
class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
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
        return "student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        //是不是两个引用同时指向一个对象
        if (this == o) return true;
        //是null肯定不相同
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        //两个相同的对象必须是年龄相同并且名字相同
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
class AgeComparator implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAge()-o2.getAge();
    }
}
class NameComparator implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
public class TestDemo1 {
    public static void main(String[] args) {
        Student student1 = new Student("bit",1);
        Student student2 = new Student("bit",1);
        System.out.println(student1 == student2);//这是比较两个变量的地址
        System.out.println(student1.equals(student2));
    }
    public static void  topk(int[] array,int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;//如果是o1-o2就是小堆用来求前k个最大元素
            }
        });
        //大堆
        for (int i = 0; i < array.length; i++) {
            if(maxHeap.size() < k){//说明还没放元素
                maxHeap.offer(array[i]);
            }else{//走到这一步说明堆中放满了,现在遍历后面的进行比较置换
                int top = maxHeap.peek();
                if(top > array[i]){//如果变成>号就会变成求前k个最大元素
                    maxHeap.poll();
                    maxHeap.offer(array[i]);
                }
            }
        }
        System.out.println(maxHeap);
    }
    public static void main3(String[] args) {
        int[] array = {1,31,2,10,7,35,21,19,56};//找前三个最小的数据
        topk(array,3);
    }
    public static void main1(String[] args) {
        Student[] students = new Student[2];
        students[0] = new Student("bit",12);
        students[1] = new Student("kun",18);
        Arrays.sort(students,new NameComparator());
        System.out.println(Arrays.toString(students));
    }
    public static void main2(String[] args) {
        //向上调整中的compare的第一个参数是插入的元素
        PriorityQueue<Student> priorityQueue= new PriorityQueue<>(new AgeComparator());
        priorityQueue.offer(new Student("bit",12));
        priorityQueue.offer(new Student("kun",8));
        System.out.println(priorityQueue);
    }
    //给定两个数组进行匹配,找到前k个和最小的组合
    public List<List<Integer>> kSmallestPairs(int[] nums1,int[] nums2,int k){
        PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<>(k, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                //return o2-o1;
                return(o2.get(0)+o2.get(1)) - (o1.get(0)+o1.get(1));
            }
        });
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){

                if(maxHeap.size() < k){//说明堆中没有k个元素
                    List<Integer> pair = new ArrayList<>();
                    pair.add(nums1[i]);
                    pair.add(nums2[j]);
                    maxHeap.offer(pair);

                }else{//说明已建成k的大堆,现在遍历剩下数组进行交换
                    List<Integer> top = new ArrayList<>();
                    //如果当前元素比堆顶元素小,就弹出堆顶元素,然后将小的数据放入堆中
                    int topValue = top.get(0) + top.get(1);
                    if(topValue > nums1[i] + nums2[j]){
                        maxHeap.poll();
                        List<Integer> pair = new ArrayList<>();
                        pair.add(nums1[i]);
                        pair.add(nums2[j]);
                        maxHeap.offer(pair);
                    }

                }
            }
        }
        List<List<Integer>> ret = new ArrayList<>();
        //堆中放的就是所求的数据
        for(int i = 0; i < k && !maxHeap.isEmpty(); i++){
            ret.add(maxHeap.poll());
        }
        return ret;
    }
}
