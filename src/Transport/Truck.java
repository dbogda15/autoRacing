package Transport;

import Driver.CategoryC;

public class Truck<C extends CategoryC> extends Transport {

private C driver;

    public Truck (String brand, String model) {
        super(brand, model, 15.0);
    }

    public Truck (String brand, String model, double engineCapacity) {
        super(brand, model, engineCapacity);
    }

    public void compliance(C driver) {
        System.out.println("\nThe driver " + driver.getName() + " drives " + getBrand() + " " + getModel()
                + " and will participate in the race.");
    }

    public void startMoving () {
        System.out.println("\nStart the engine. Your truck is " + getBrand() + " " + getModel());
        System.out.println("Warm up the engine for 10 minutes");
        System.out.println("Make sure the traffic is safe");
        System.out.println("Start moving");
    }

    public void finishMoving () {
        System.out.println("\nStop the truck. Your truck is " + getBrand() + " " + getModel());
        System.out.println("Make sure the truck parking is safe");
        System.out.println("Turn off the engine");
    }
}
