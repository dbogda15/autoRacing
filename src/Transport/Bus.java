package Transport;

import Driver.CategoryD;

public class Bus<D extends CategoryD> extends Transport {

    private D driver;

    public Bus (String brand, String model) {
        super(brand, model, 3.0);
    }

    public Bus(String brand, String model, double engineCapacity) {
        super(brand, model, engineCapacity);
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

    public void pitStop() {
        System.out.println("\nReplace " + getBrand() + " " + getModel() + " tires.");
        System.out.println("Refuel.");
        System.out.println("Check the oil level");
        System.out.println("Check your passengers. You must have 20 of them!");
    }
}
