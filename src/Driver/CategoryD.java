package Driver;

public class CategoryD extends Driver {

    public CategoryD (String name) {
        super(name);
    }

    public CategoryD (String name, String driverLicense, int drivingExperience) throws IllegalAccessException {
        super(name, driverLicense, drivingExperience);
        if (drivingExperience < 4) {
            throw new IllegalAccessException("Too little driving experience. It has to be more than 4 years.");
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
}
