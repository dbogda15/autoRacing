import Transport.Car;
import Transport.Bus;
import Transport.Truck;
import Driver.CategoryB;
import Driver.CategoryC;
import Driver.CategoryD;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {

        Car<CategoryB> car1 = new Car<> ("Lada", "Granta");
        Car<CategoryB> car2 = new Car<>("Audi", "A7");
        Car<CategoryB> car3 = new Car<>("Toyota", "Camry", -2);
        Car<CategoryB> car4 = new Car<>("Mazda", "6", 3.1);

        Bus<CategoryD> bus1 = new Bus<>("NEFAZ", "A11-22-33");
        Bus<CategoryD> bus2 = new Bus<>("KAMAZ", "B00-110");
        Bus<CategoryD> bus3 = new Bus<>("", "09876A");
        Bus<CategoryD> bus4 = new Bus<>("Mercedes-Benz", "0303");

        Truck<CategoryC> truck1 = new Truck<>("KAMAZ", "5511");
        Truck<CategoryC> truck2 = new Truck<>("UAZ", "452");
        Truck<CategoryC> truck3 = new Truck<>("URAL", "4320");
        Truck<CategoryC> truck4 = new Truck<>("MAN", "");

        System.out.println(car3);
        System.out.println(truck4);

        double [] lapTimeCar2 = {13, 13.1, 14, 13.5, 13.4};
        car2.setLapTimes(lapTimeCar2);
        car2.bestLapTime();

        double [] lapSpeedCar3 = {190, 189.5, 200, 201.7, 200.9};
        car3.setLapSpeed(lapSpeedCar3);
        car3.maxSpeed();

        double [] lapSpeedTruck3 = {150, 145, 144.9, 154.4, 153.9};
        truck3.setLapSpeed(lapSpeedTruck3);
        truck3.maxSpeed();

        truck2.startMoving();
        truck2.finishMoving();

        bus4.pitStop();

        CategoryB dima = new CategoryB("Dima", "yes", 5);
        System.out.println(dima);

        CategoryC maxim = new CategoryC("Maxim");
        System.out.println(maxim);

        CategoryD olga = new CategoryD("Olga", "yes", 15);

        car4.compliance(dima);
        bus2.compliance(olga);
        truck1.compliance(maxim);

        CategoryC diana = new CategoryC("Diana", "yes", 4);
        System.out.println(diana);

    }
}