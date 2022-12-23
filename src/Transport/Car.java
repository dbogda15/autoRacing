package Transport;

public class Car extends Transport {

    public Car (String brand, String model) {
        this(brand, model, 1.5);
    }

    public Car (String brand, String model, double engineCapacity) {
        super(brand, model, engineCapacity);
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
