package Driver;

public class CategoryC extends Driver {

    public CategoryC(String name) {
        super(name);
    }

    public CategoryC(String name, String driverLicense, int drivingExperience) throws IllegalAccessException {
        super(name, driverLicense, drivingExperience);
        if (drivingExperience < 5) {
            throw new IllegalAccessException("Too little driving experience. It has to be more than 5 years.");
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
