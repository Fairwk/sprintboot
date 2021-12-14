package day20211108;

class Vehicle{
    protected int wheels;
    protected double weight;
    public Vehicle(int wheels,double weight){
        this.wheels = wheels;
        this.weight = weight;
    }

    public int getWheels() {

        return wheels;
    }

    public void setWheels(int wheels) {

        this.wheels = wheels;
    }

    public double getWeight() {

        return weight;
    }

    public void setWeight(double weight) {

        this.weight = weight;
    }
    @Override
    public String toString(){
        return "Vehicle[wheels = " + wheels + ", " +
                "weight = " + weight + "]";
    }
}
class Car extends Vehicle{
    protected int loader;

    public Car(int wheels, double weight,int loader) {
        super(wheels, weight);
        this.loader = loader;
    }
    public int getLoader(){
        return loader;
    }
    public void setLoader(int loader){
        this.loader = loader;
    }
    @Override
    public String toString(){
        return "Car[loader = " + loader + ", wheels = " +
                wheels + ", weight = " + weight + " ]";
    }
}
public class Test {
    public static void main(String[] args) {
        Car car = new Car(4,200,5);
        System.out.println(car);
        Vehicle vehicle = new Vehicle(3,300);
        System.out.println(vehicle);
    }

}
