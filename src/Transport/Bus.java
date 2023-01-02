package Transport;

import Driver.CategoryD;

import java.util.Objects;

public class Bus<D extends CategoryD> extends Transport {

    private D driver;
    private Capacity capacity;
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

    public void pitStop() {
        System.out.println("\nReplace " + getBrand() + " " + getModel() + " tires.");
        System.out.println("Refuel.");
        System.out.println("Check the oil level");
        System.out.println("Check your passengers. You must have 20 of them!");
    }
}
