package Transport;

import Driver.CategoryB;

import java.util.Objects;

public class Car <B extends CategoryB> extends Transport {

    public B driver;
    public BodyType bodyType;

    public enum BodyType {
        SEDAN ("Седан"),
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


    public Car (String brand, String model) {
        this(brand, model, 1.5, null);
    }

    public Car (String brand, String model, double engineCapacity, BodyType bodyType) {
        super(brand, model, engineCapacity);
        this.bodyType = bodyType;
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
    public void printType () {
        if (bodyType == null) {
            System.out.println("\nThere is not enough data about " + getBrand() + " " + getModel());
        } else {
            System.out.println("\nBody type of " + getBrand() + " " + getModel() + ": " + bodyType);
        }
    }
}
