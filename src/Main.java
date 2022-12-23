import Transport.Transport;
import Transport.Car;
import Transport.Bus;
import Transport.Truck;

public class Main {
    public static void main(String[] args) {

        Car car1 = new Car ("Lada", "Granta");
        Car car2 = new Car("Audi", "A7");
        Car car3 = new Car("Toyota", "Camry", -2);
        Car car4 = new Car("Mazda", "6", 3.1);

        Bus bus1 = new Bus("NEFAZ", "A11-22-33");
        Bus bus2 = new Bus("KAMAZ", "B00-110");
        Bus bus3 = new Bus("", "09876A");
        Bus bus4 = new Bus("Mercedes-Benz", "0303");

        Truck truck1 = new Truck("KAMAZ", "5511");
        Truck truck2 = new Truck("UAZ", "452");
        Truck truck3 = new Truck("URAL", "4320");
        Truck truck4 = new Truck("MAN", "");

        System.out.println(car3);
        System.out.println(truck4);

        double [] lapTimeCar2 = {13, 13.1, 14, 13.5, 13.4};
        car2.setLapTimes(lapTimeCar2);

        car2.bestLapTime();

        double [] lapSpeedCar3 = {190, 189.5, 200, 201.7, 200.9};
        car3.setLapSpeed(lapSpeedCar3);

        car3.maxSpeed();

        truck2.startMoving();
        truck2.finishMoving();

        bus4.pitStop();
    }
}