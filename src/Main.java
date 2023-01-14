import Driver.CategoryB;
import Driver.CategoryC;
import Driver.CategoryD;
import Driver.Driver;
import Mechanic.Mechanic;
import Transport.*;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IllegalAccessException, DriversException {

        Car<CategoryB> car1 = new Car<CategoryB>("Lada", "Granta", 1, Car.BodyType.SEDAN);
        Car<CategoryB> car2 = new Car<CategoryB>("Audi", "A7", 15, Car.BodyType.SEDAN);
        Car<CategoryB> car3 = new Car<CategoryB>("Toyota", "Camry", -2, Car.BodyType.SEDAN);
        Car<CategoryB> car4 = new Car<CategoryB>("Mazda", "6", 3.1, Car.BodyType.SEDAN);

        Bus<CategoryD> bus1 = new Bus<CategoryD>("NEFAZ", "A11-22-33", 88, Bus.Capacity.EXTRA_SMALL);
        Bus<CategoryD> bus2 = new Bus<CategoryD>("KAMAZ", "B00-110", 66, Bus.Capacity.EXTRA_LARGE);
        Bus<CategoryD> bus3 = new Bus<CategoryD>("", "09876A", 88, Bus.Capacity.LARGE);
        Bus<CategoryD> bus4 = new Bus<CategoryD>("Mercedes-Benz", "0303", 65, Bus.Capacity.EXTRA_SMALL);

        Truck<CategoryC> truck1 = new Truck<CategoryC>("KAMAZ", "5511", 45, Truck.LoadCapacity.N3);
        Truck<CategoryC> truck2 = new Truck<CategoryC>("UAZ", "452", 44, Truck.LoadCapacity.N3);
        Truck<CategoryC> truck3 = new Truck<CategoryC>("URAL", "4320", 55, Truck.LoadCapacity.N2);
        Truck<CategoryC> truck4 = new Truck<CategoryC>("MAN", "", 77, Truck.LoadCapacity.N1);

        CategoryB dima = new CategoryB("Dima", "yes", 5);
        CategoryC diana = new CategoryC("Diana", "yes", 6);
        CategoryD dasha = new CategoryD("Dasha", "yes", 6);
        CategoryB alesha = new CategoryB("Alesha", "yes", 5);
        CategoryC misha = new CategoryC("Misha");

        Mechanic maxim = new Mechanic("Maxim", "Maximov", "horns and hooves", Mechanic.Access.ALL);
        Mechanic oleg = new Mechanic("Oleg", "Olegov", "Auto", Mechanic.Access.BUS);
        Mechanic masha = new Mechanic("Masha", "Shishkina", "Strong and independent", Mechanic.Access.TRUCK);
        Mechanic egor = new Mechanic("Egor", "Egorov", "Egorov company", Mechanic.Access.CAR);
        Mechanic andrey = new Mechanic("Andrey", "Petrov", "The fifth wheel", Mechanic.Access.CAR);

        List<Transport> transportsList = new ArrayList<>();
        transportsList.add(car1);
        transportsList.add(car2);
        transportsList.add(car3);
        transportsList.add(car4);
        transportsList.add(bus1);
        transportsList.add(bus2);
        transportsList.add(bus3);
        transportsList.add(bus4);
        transportsList.add(truck1);
        transportsList.add(truck2);
        transportsList.add(truck3);
        transportsList.add(truck4);

        List<Driver> driverList = new ArrayList<>();
        driverList.add(dima);
        driverList.add(diana);
        driverList.add(dasha);
        driverList.add(alesha);
        driverList.add(misha);

        List<Mechanic> mechanicList = new ArrayList<>();
        mechanicList.add(maxim);
        mechanicList.add(oleg);
        mechanicList.add(masha);
        mechanicList.add(egor);
        mechanicList.add(andrey);


        car3.performMaintenance(mechanicList);
        bus1.performMaintenance(mechanicList);
        truck2.performMaintenance(mechanicList);

         car3.setDriver(dima);
         car3.setMechanic(andrey);

         bus1.setDriver(dasha);
         bus1.setMechanic(maxim);

         truck2.setDriver(diana);
         truck2.setMechanic(masha);

         car3.racingTeamInfo(driverList, mechanicList);
         bus1.racingTeamInfo(driverList, mechanicList);
         truck2.racingTeamInfo(driverList, mechanicList);

    }
}
