import Driver.CategoryB;
import Driver.CategoryC;
import Driver.CategoryD;
import Driver.Driver;
import Mechanic.Mechanic;
import Transport.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, DriversException {

        List<Driver> driverList = new ArrayList<>();
        CategoryB dima = new CategoryB("Dima", "yes", 5);
        CategoryC diana = new CategoryC("Diana", "yes", 6);
        CategoryD dasha = new CategoryD("Dasha", "yes", 6);
        CategoryB alesha = new CategoryB("Alesha", "yes", 5);
        CategoryC misha = new CategoryC("Misha");

        driverList.add(dima);
        driverList.add(diana);
        driverList.add(dasha);
        driverList.add(alesha);
        driverList.add(misha);

        List<Mechanic> mechanicList = new ArrayList<>();
        Mechanic<?> maxim = new Mechanic("Maxim", "Maximov", "horns and hooves", Mechanic.Access.ALL);
        Mechanic<?> oleg = new Mechanic("Oleg", "Olegov", "Auto", Mechanic.Access.BUS);
        Mechanic<?> masha = new Mechanic("Masha", "Shishkina", "Strong and independent", Mechanic.Access.TRUCK);
        Mechanic<?> egor = new Mechanic("Egor", "Egorov", "Egorov company", Mechanic.Access.CAR);
        Mechanic<?> andrey = new Mechanic("Andrey", "Petrov", "The fifth wheel", Mechanic.Access.CAR);

        mechanicList.add(maxim);
        mechanicList.add(oleg);
        mechanicList.add(masha);
        mechanicList.add(egor);
        mechanicList.add(andrey);

        List<Transport> transportsList = new ArrayList<>();

        Car<CategoryB> car1 = new Car<CategoryB>("Lada", "Granta", 1, driverList, mechanicList, Car.BodyType.SEDAN);
        Car<CategoryB> car2 = new Car<CategoryB>("Audi", "A7", 15, driverList, mechanicList, Car.BodyType.SEDAN);
        Car<CategoryB> car3 = new Car<CategoryB>("Toyota", "Camry", -2, driverList, mechanicList, Car.BodyType.SEDAN);
        Car<CategoryB> car4 = new Car<CategoryB>("Mazda", "6", 3.1, driverList, mechanicList, Car.BodyType.SEDAN);

        Bus<CategoryD> bus1 = new Bus<CategoryD>("NEFAZ", "A11-22-33", 88, driverList, mechanicList, Bus.Capacity.EXTRA_SMALL);
        Bus<CategoryD> bus2 = new Bus<CategoryD>("KAMAZ", "B00-110", 66, driverList, mechanicList, Bus.Capacity.EXTRA_LARGE);
        Bus<CategoryD> bus3 = new Bus<CategoryD>("MAZ", "09876A", 88, driverList, mechanicList, Bus.Capacity.LARGE);
        Bus<CategoryD> bus4 = new Bus<CategoryD>("Mercedes-Benz", "0303", 65, driverList, mechanicList, Bus.Capacity.EXTRA_SMALL);

        Truck<CategoryC> truck1 = new Truck<CategoryC>("KAMAZ", "5511", 45, driverList, mechanicList, Truck.LoadCapacity.N3);
        Truck<CategoryC> truck2 = new Truck<CategoryC>("UAZ", "452", 44, driverList, mechanicList, Truck.LoadCapacity.N3);
        Truck<CategoryC> truck3 = new Truck<CategoryC>("URAL", "4320", 55, driverList, mechanicList, Truck.LoadCapacity.N2);
        Truck<CategoryC> truck4 = new Truck<CategoryC>("MAN", "", 77, driverList, mechanicList, Truck.LoadCapacity.N1);

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

//        car3.setMechanic(andrey);
//        car3.setDriver(dima);
//        car3.racingTeamInfo();

        HashMap<Transport, Mechanic<?>> maintenanceMap = new HashMap<>();
        maintenanceMap.put(car1, andrey);
        maintenanceMap.put(car2, egor);
        maintenanceMap.put(car3, andrey);
        maintenanceMap.put(car4, maxim);
        maintenanceMap.put(bus1, maxim);
        maintenanceMap.put(bus2, oleg);
        maintenanceMap.put(bus3, oleg);
        maintenanceMap.put(bus4, maxim);
        maintenanceMap.put(truck1, masha);
        maintenanceMap.put(truck2, masha);
        maintenanceMap.put(truck3, maxim);
        maintenanceMap.put(truck4, maxim);
        maintenanceMap.put(truck4, maxim); // проверка на дублирование
        maintenanceMap.put(truck4, maxim);
        maintenanceMap.put(truck4, maxim);


        printMaintenanceMap(maintenanceMap);
    }

    public static void printMaintenanceMap (HashMap<Transport, Mechanic<?>> maintenanceMap) {
        System.out.println("\n List of mechanics and vehicles: ");
        for (Map.Entry<Transport, Mechanic<?>> value : maintenanceMap.entrySet()) {
            System.out.println(value.getValue().getName() + " " + value.getValue().getLastName() + " maintains " + value.getKey().getClass().getSimpleName() + " " + value.getKey().getBrand() + " " + value.getKey().getModel());
        }
    }
}
