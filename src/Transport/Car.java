package Transport;

import Driver.CategoryB;
import Driver.Driver;
import Mechanic.Mechanic;

import java.util.List;
import java.util.Objects;

public class Car <B extends CategoryB> extends Transport {

    public B driver;
    public BodyType bodyType;
    public Mechanic mechanic;
    public List<Mechanic> mechanicList;
    public List<Driver> driverList;


    public enum BodyType {
        SEDAN("Седан"),
        HATCHBACK("Хетчбек"),
        COUPE("Купе"),
        STATION_WAGON("Универсал"),
        SUV("Внедорожник"),
        CROSSOVER("Кроссовер"),
        PICKUP_TRUCK("Пикап"),
        VAN("Фургон"),
        MINIVAN("Минивэн");

        private final String bodyType;

        BodyType(String bodyType) {
            this.bodyType = bodyType;
        }

        public String getBodyType() {
            return bodyType;
        }
    }

    public Car(String brand, String model, double engineCapacity, BodyType bodyType) {
        super(brand, model, engineCapacity);
        this.bodyType = bodyType;
    }

    public void compliance(B driver) {
        System.out.println("\nThe driver " + driver.getName() + " drives " + getBrand() + " " + getModel()
                + " and will participate in the race.");
    }

    public B getDriver() {
        return driver;
    }

    public void setDriver(B driver) {
        this.driver = driver;
    }

    public void startMoving() {
        System.out.println("\nStart the engine. Your car is" + getBrand() + " " + getModel());
        System.out.println("Warm up the engine for 1 minutes");
        System.out.println("Start moving");
    }

    public void finishMoving() {
        System.out.println("\nStop the car. Your car is " + getBrand() + " " + getModel());
        System.out.println("Put on the handbrake");
        System.out.println("Turn off the engine");
    }

    public void printType() {
        if (bodyType == null) {
            System.out.println("\nThere is not enough data about " + getBrand() + " " + getModel());
        } else {
            System.out.println("\nBody type of " + getBrand() + " " + getModel() + ": " + bodyType);
        }
    }

    @Override
    public void passDiagnostic() {
        System.out.println("\n" + getBrand() + " " + getModel() + " can be diagnosed.");
    }

    public Mechanic getMechanic() {
            return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
            this.mechanic = mechanic;
    }

    @Override
    public void performMaintenance(List<Mechanic> mechanicList) {
        System.out.println("\nWho can perform maintenance " + getBrand() + " " + getModel() + " : ");
            for (Mechanic mechanic : mechanicList) {
                if (mechanic.getAccess() == Mechanic.Access.CAR || mechanic.getAccess() == Mechanic.Access.ALL) {
                    System.out.println("* " + mechanic);
                }
            }
    }

    @Override
    public void fixTheVehicle(List<Mechanic> mechanicList) {
        System.out.println("\nWho can fix " + getBrand() + " " + getModel());
        for (Mechanic mechanic : mechanicList) {
            if (mechanic.getAccess() == Mechanic.Access.CAR || mechanic.getAccess() == Mechanic.Access.ALL) {
                System.out.println("* " + mechanic);
            }
        }
    }

    @Override
    public void racingTeamInfo(List<Driver> driverList, List<Mechanic> mechanicList) {
        System.out.println("\nRace team of " + getBrand() + " " + getModel() + ": ");
        if (mechanic != null || driver != null) {
            for (Mechanic mechanic : mechanicList) {
                if (Objects.equals(mechanic.getName(), getMechanic().getName())) {
                    System.out.println("* Mechanic " + mechanic.getLastName() + " " + mechanic.getName());
                }
            }
            for (Driver driver : driverList) {
                if (Objects.equals(driver.getName(), getDriver().getName())) {
                    System.out.println("* Driver " + getDriver().getName());
                }
            }
        }
    }
}
