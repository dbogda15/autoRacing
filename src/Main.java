import Driver.CategoryB;
import Driver.CategoryC;
import Driver.CategoryD;
import Transport.Bus;
import Transport.Car;
import Transport.DriversException;
import Transport.Truck;

import static Driver.Driver.checkDriversLicence;
import static Transport.Transport.diagnostic;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, DriversException {

        Car<CategoryB> car1 = new Car<>("Lada", "Granta", 1, null);
        Car<CategoryB> car2 = new Car<>("Audi", "A7", 15, Car.BodyType.SEDAN);
        Car<CategoryB> car3 = new Car<>("Toyota", "Camry", -2, Car.BodyType.SEDAN);
        Car<CategoryB> car4 = new Car<>("Mazda", "6", 3.1, Car.BodyType.SEDAN);

        Bus<CategoryD> bus1 = new Bus<>("NEFAZ", "A11-22-33");
        Bus<CategoryD> bus2 = new Bus<>("KAMAZ", "B00-110", 66, Bus.Capacity.EXTRA_LARGE);
        Bus<CategoryD> bus3 = new Bus<>("", "09876A", 88, Bus.Capacity.LARGE);
        Bus<CategoryD> bus4 = new Bus<>("Mercedes-Benz", "0303", 65, Bus.Capacity.EXTRA_SMALL);

        Truck<CategoryC> truck1 = new Truck<>("KAMAZ", "5511");
        Truck<CategoryC> truck2 = new Truck<>("UAZ", "452", 44, Truck.LoadCapacity.N3);
        Truck<CategoryC> truck3 = new Truck<>("URAL", "4320", 55, Truck.LoadCapacity.N2);
        Truck<CategoryC> truck4 = new Truck<>("MAN", "", 77, Truck.LoadCapacity.N1);

        CategoryB dima = new CategoryB("Dima", "yes", 5);
        CategoryC diana = new CategoryC("Diana", "yes", 6);
        CategoryD dasha = new CategoryD("Dasha");

        diagnostic(car1, bus1, truck3);
        checkDriversLicence(dima,dasha,diana);
    }
}
