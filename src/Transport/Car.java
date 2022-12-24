package Transport;

import Driver.CategoryB;

public class Car <B extends CategoryB> extends Transport {

    public B driver;

    public Car (String brand, String model) {
        this(brand, model, 1.5);
    }

    public Car (String brand, String model, double engineCapacity) {
        super(brand, model, engineCapacity);
    }

    public void compliance (B driver) {
        System.out.println("\nThe driver " + driver.getName() + " drives " + getBrand() + " " + getModel()
                + " and will participate in the race.");
    }

    public B getDriver() {
        return driver;
    }

    public void setDriver(B driver) {
        this.driver = driver;
    }

    public void startMoving () {
        System.out.println("\nStart the engine. Your car is" + getBrand() + " " + getModel());
        System.out.println("Warm up the engine for 1 minutes");
        System.out.println("Start moving");
    }

    public void finishMoving () {
        System.out.println("\nStop the car. Your car is " + getBrand() + " " + getModel());
        System.out.println("Put on the handbrake");
        System.out.println("Turn off the engine");
    }
}
