package test3;

public class MaxNum {
    public static void main(String[] args) {
        int[] data = {56,77,95,26,53,58,20};
        if(data.length > 0){
            int data_Max = data[0];
            int data_index = 0;
            for(int i = 0; i < data.length; i++){
                if(data[i] > data_Max){
                    data_Max = data[i];
                    data_index = i;
                }
            }
            System.out.println("data中最大的元素为:" + data_Max + "下标是:" + data_index);
        }
    }


}
