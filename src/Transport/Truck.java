package Transport;

import Driver.CategoryC;
import Driver.Driver;
import Mechanic.Mechanic;

import java.util.List;
import java.util.Objects;

public class Truck<C extends CategoryC> extends Transport {

    private C driver;
    private Mechanic <?> mechanic;
    private LoadCapacity loadCapacity;

public enum LoadCapacity {
    N1(0D, 3.5),
    N2(3.5, 12D),
    N3(12D,null);

    private final Double from;
    private final Double to;

    LoadCapacity(Double from, Double to) {
        this.from = from;
        this.to = to;
    }

    public Double getFrom() {
        return from;
    }

    public Double getTo() {
        return to;
    }
}

    public Truck (String brand, String model) {
        super(brand, model, 15.0);
    }

    public Truck (String brand, String model, double engineCapacity, LoadCapacity loadCapacity) {
        super(brand, model, engineCapacity);
        this.loadCapacity = loadCapacity;
    }

    public void compliance(C driver) {
        System.out.println("\nThe driver " + driver.getName() + " drives " + getBrand() + " " + getModel()
                + " and will participate in the race.");
    }

    @Override
    public void startMoving () {
        System.out.println("\nStart the engine. Your truck is " + getBrand() + " " + getModel());
        System.out.println("Warm up the engine for 10 minutes");
        System.out.println("Make sure the traffic is safe");
        System.out.println("Start moving");
    }

    @Override
    public void finishMoving () {
        System.out.println("\nStop the truck. Your truck is " + getBrand() + " " + getModel());
        System.out.println("Make sure the truck parking is safe");
        System.out.println("Turn off the engine");
    }

    @Override
    public void printType() {
        if (Objects.isNull(loadCapacity)) {
            System.out.println("\nThere is not enough data about " + getBrand() + " " + getModel());
        } else {
            String from = loadCapacity.getFrom() == null ? "" : " from " + loadCapacity.getFrom() + " ton ";
            String to = loadCapacity.getTo() == null ? "" : "to " + loadCapacity.getTo() + " ton ";
            System.out.println("\nLoad capacity of " + getBrand() + " " + getModel() + from + to);
        }
    }

    @Override
    public void passDiagnostic() {
        System.out.println("\n" + getBrand() + " " + getModel() + " can be diagnosed.");
    }

    public C getDriver() {
        return driver;
    }

    public void setDriver(C driver) {
        this.driver = driver;
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
            for (Mechanic mechanic : getMechanicList()) {
                if (mechanic.getAccess() == Mechanic.Access.TRUCK || mechanic.getAccess() == Mechanic.Access.ALL) {
                    System.out.println("* " + getMechanicList());
                }
            }
        }

    @Override
    public void fixTheVehicle() {
        System.out.println("\nWho can fix " + getBrand () + " " + getModel ()+ ": ");
        for (Mechanic mechanic : getMechanicList()) {
            if (mechanic.getAccess() == Mechanic.Access.TRUCK || mechanic.getAccess() == Mechanic.Access.ALL) {
                System.out.println("* " + getMechanic());
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
