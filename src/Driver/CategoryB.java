package Driver;

import Transport.DriversException;

import java.util.Objects;

public class CategoryB extends Driver {

    public CategoryB (String name) {
        super(name);
    }

    public CategoryB (String name, String driverLicense, int drivingExperience) throws IllegalAccessException {
        super(name, driverLicense, drivingExperience);

        if (drivingExperience < 3) {
            throw new IllegalAccessException("Too little driving experience. It has to be more than 3 years.");
        }
        this.drivingExperience = drivingExperience;
    }

    @Override
    public void startMoving() {

    }

    @Override
    public void refuelCar() {

    }

    @Override
    public void finishMoving() {

    }

    @Override
    public  void checkDrivers() throws DriversException {
            if (Objects.isNull(getDriverLicense()) || getDriverLicense().isBlank()) {
                throw new DriversException("\nThere is not data about driver's license of " + getName(), this);
            } else {
                System.out.println("\nThere is no problem with " + this.getName() + "'s driver's license info");
            }
    }
}
