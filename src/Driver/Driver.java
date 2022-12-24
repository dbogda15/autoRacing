package Driver;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Driver {
    public String name;
    public String driverLicense;
    public int drivingExperience;
    public int yearDriverLicense;

    public Driver(String name) {
        this(name, "*please, enter the info about driver license*", 3);
    }

    public Driver(String name, String driverLicense, int drivingExperience) {

        if (Objects.isNull(name) || name.isBlank()) {
            this.name = "*Undetermined name*";
        } else {
            this.name = name;
        }

        if (Objects.isNull(driverLicense) || driverLicense.isBlank()) {
            this.driverLicense = "*please, enter the info about driver license*";
        } else {
            this.driverLicense = driverLicense;
        }

        if (drivingExperience < 0) {
            this.drivingExperience = Math.abs(drivingExperience);
        } else {
            this.drivingExperience = drivingExperience;
        }

        if (drivingExperience >= 0) {
            this.yearDriverLicense = LocalDate.now().getYear() - drivingExperience;
        } else {
            this.yearDriverLicense = LocalDate.now().getYear() - Math.abs(drivingExperience);
        }
    }

    public void startMoving () {

    };

    public void finishMoving () {

    };

    public void refuelCar () {

    };

    public String getName() {
        return name;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public int getDrivingExperience() {
        return drivingExperience;
    }

    public int getYearDriverLicense() {
        return yearDriverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    public void setDrivingExperience(int drivingExperience) {
        this.drivingExperience = drivingExperience;
    }

    public void setYearDriverLicense(int yearDriverLicense) {
        this.yearDriverLicense = yearDriverLicense;
    }

    @Override
    public String toString() {
        return "\nDriver: " + getName() + ". Driver license: " + getDriverLicense() +
                ". The year of issue of the driver's license: " + getYearDriverLicense()  +
                ", driving experience = " + getDrivingExperience() + " years.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return drivingExperience == driver.drivingExperience && yearDriverLicense == driver.yearDriverLicense && Objects.equals(name, driver.name) && Objects.equals(driverLicense, driver.driverLicense);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, driverLicense, drivingExperience, yearDriverLicense);
    }
}
