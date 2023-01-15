package Transport;

import Driver.CategoryD;
import Driver.Driver;
import Mechanic.Mechanic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bus<D extends CategoryD> extends Transport {

    private D driver;
    private Capacity capacity;
    private Mechanic <?> mechanic;
    public enum Capacity {
        EXTRA_SMALL(0,10),
        SMALL(10, 25),
        MEDIUM(40,50),
        LARGE(60,80),
        EXTRA_LARGE(100,120);

        private final int from;
        private final int to;

        Capacity(int from, int to) {
            this.from = from;
            this.to = to;
        }

        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }
    }

    public Bus (String brand, String model) {
        super(brand, model, 3.0);
    }

    public Bus(String brand, String model, double engineCapacity, Capacity capacity) {
        super(brand, model, engineCapacity);
        this.capacity = capacity;
    }

    public D getDriver() {
        return driver;
    }

    public void setDriver(D driver) {
        this.driver = driver;
    }

    public void compliance(D driver) {
        System.out.println("\nThe driver " + driver.getName() + " drives " + getBrand() + " " + getModel()
                    + " and will participate in the race.");
    }

    public void startMoving () {
        System.out.println("\nStart the engine.");
        System.out.println("Warm up the engine for 2 minutes");
        System.out.println("Start moving");
    }

    public void finishMoving () {
        System.out.println("\nStop the " + getBrand() + " " + getModel() + " bus");
        System.out.println("Put on the handbrake");
        System.out.println("Turn off the engine");
    }

    @Override
    public void printType() {
        if (Objects.nonNull(capacity)) {
            System.out.println("\nCapacity of " + getModel() + " " + getBrand() + " : from " + capacity.from + " p. to " + capacity.to + " p." );
        } else {
            System.out.println("\nThere is not enough data about " + getModel() + " " + getBrand());
        }
    }

    @Override
    public void passDiagnostic() {
        throw new UnsupportedOperationException (getBrand() + " " + getModel() + " can't be diagnosed.");
    }

    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        if (mechanic != null) {
            this.mechanic = mechanic;
        }
    }

    @Override
    public void performMaintenance() {
            System.out.println("\nWho can perform maintenance " + getBrand () + " " + getModel () + " : ");
            for (Mechanic mechanic : mechanicList) {
                if (mechanic.getAccess() == Mechanic.Access.BUS || mechanic.getAccess() == Mechanic.Access.ALL) {
                    System.out.println("* " + getMechanicList());
                }
            }
    }

    @Override
    public void fixTheVehicle() {
        System.out.println("\nWho can fix " + getBrand () + " " + getModel ()+ ": ");
        for (Mechanic mechanic : getMechanicList()) {
            if (mechanic.getAccess() == Mechanic.Access.BUS || mechanic.getAccess() == Mechanic.Access.ALL) {
                System.out.println("* " + getMechanic());
            }
        }
    }

    @Override
    public void racingTeamInfo(List<Driver> driverList, List<Mechanic> mechanicList) {
        System.out.println("\nRace team of Bus " + getBrand() + " " + getModel() + ": ");
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

    public void pitStop() {
        System.out.println("\nReplace " + getBrand() + " " + getModel() + " tires.");
        System.out.println("Refuel.");
        System.out.println("Check the oil level");
        System.out.println("Check your passengers. You must have 20 of them!");
    }
}
