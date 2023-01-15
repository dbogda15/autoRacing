package Transport;

import Driver.CategoryB;
import Driver.Driver;
import Mechanic.Mechanic;

import java.util.List;
import java.util.Objects;

public class Car <B extends CategoryB> extends Transport {

    public B driver;
    public BodyType bodyType;
    public Mechanic<?> mechanic;


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

    public Car(String brand, String model, double engineCapacity, List<Driver> driverList, List<Mechanic> mechanicList, BodyType bodyType) {
        super(brand, model, engineCapacity, driverList, mechanicList);
        this.bodyType = bodyType;
    }

    public B getDriver() {
        return driver;
    }

    public void setDriver(B driver) {
        this.driver = driver;
    }

    public Mechanic<?> getMechanic() {
        return mechanic;
    }

    public void setMechanic(Mechanic<?> mechanic) {
        this.mechanic = mechanic;
    }

    public void compliance(B driver) {
        System.out.println("\nThe driver " + driver.getName() + " drives " + getBrand() + " " + getModel()
                + " and will participate in the race.");
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

    @Override
    public void performMaintenance() {
        System.out.println("\nWho can perform maintenance " + getBrand() + " " + getModel() + " : ");
            for (Mechanic<?> mechanic : getMechanicList()) {
                if (mechanic.getAccess() == Mechanic.Access.CAR || mechanic.getAccess() == Mechanic.Access.ALL) {
                    System.out.println("* " + mechanic.getLastName() + " " + mechanic.getName());
                }
            }
    }

    @Override
    public void fixTheVehicle() {
        System.out.println("\nWho can fix " + getBrand() + " " + getModel() + ": ");
        for (Mechanic<?> mechanic : getMechanicList()) {
            if (mechanic.getAccess() == Mechanic.Access.CAR || mechanic.getAccess() == Mechanic.Access.ALL) {
                System.out.println("* " + mechanic.getLastName() + " " + mechanic.getName());
            }
        }
    }

    @Override
    public void racingTeamInfo() {
        System.out.println("\nRace team of " + getBrand() + " " + getModel() + ": ");
        if (mechanic != null || driver != null) {
            for (Mechanic<?> mechanic : getMechanicList()) {
                if (Objects.equals(mechanic.getName(), getMechanic().getName())) {
                    System.out.println("* Mechanic " + mechanic.getLastName() + " " + mechanic.getName());
                }
            }
            for (Driver driver : getDriverList()) {
                if (Objects.equals(driver.getName(), getDriver().getName())) {
                    System.out.println("* Driver " + getDriver().getName());
                }
            }
        }
    }
}
