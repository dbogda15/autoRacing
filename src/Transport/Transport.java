package Transport;
import java.util.Objects;

public abstract class Transport implements Competing {

    public final String brand;
    public final String model;
    public double engineCapacity;

    public double [] lapTimes;

    public double [] lapSpeed;

    public Transport (String brand, String model, double engineCapacity) {

        if (Objects.isNull(brand) || brand.isBlank()) {
            this.brand = "*Undetermined transport*";
        } else {
            this.brand = brand;
        }

        if (Objects.isNull(model) || model.isBlank()) {
            this.model = "*Undetermined model*";
        } else {
            this.model = model;
        }

        if (engineCapacity < 0) {
            this.engineCapacity = Math.abs(engineCapacity);
        } else {
            this.engineCapacity = engineCapacity;
        }
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public double[] getLapTimes() {
        return lapTimes;
    }

    public void setLapTimes(double[] lapTimes) {
        this.lapTimes = lapTimes;
    }

    public void setLapSpeed(double[] lapSpeed) {
        this.lapSpeed = lapSpeed;
    }

    public double[] getLapSpeed() {
        return lapSpeed;
    }


    public void compliance() {

    };

    public abstract void startMoving ();

    public abstract void finishMoving ();


    @Override
    public void pitStop() {
        System.out.println("\nReplace tires. Your transport is " + getBrand() + " " + getModel());
        System.out.println("Refuel.");
        System.out.println("Check the oil level");
    }

    @Override
    public void bestLapTime() {
        double bestTime = 10000;
        for (double lapTime : lapTimes) {
            if (lapTime < bestTime) {
                bestTime = lapTime;
            }
        }
        System.out.println("\n" + getBrand() + " " + getModel() + "'s best lap time is " + bestTime);
    }

    @Override
    public void maxSpeed() {
        double maxSpeed = 0;
        for (double j : lapSpeed) {
            if (j > maxSpeed) {
                maxSpeed = j;
            }
        }
        System.out.println("\n" + getBrand() + " " + getModel() + "'s max speed is " + maxSpeed);
    }

    @Override
    public String toString() {
        return "\n" + getBrand() + ' ' + getModel() + ", engineCapacity = " + getEngineCapacity() + '.';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return Double.compare(transport.engineCapacity, engineCapacity) == 0 && Objects.equals(brand, transport.brand) && Objects.equals(model, transport.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engineCapacity);
    }
}
