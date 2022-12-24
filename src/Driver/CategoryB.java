package Driver;

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

    public void startMoving() {

    }

    @Override
    public void refuelCar() {

    }

    @Override
    public void finishMoving() {

    }
}
