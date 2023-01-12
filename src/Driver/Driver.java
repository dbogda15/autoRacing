package Driver;


import Transport.DriversException;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Driver {
    private final String name;
    private String driverLicense;
    public int drivingExperience;
    private int yearDriverLicense;

    public Driver(String name) {
        this(name, null, 3);
    }

    public Driver(String name, String driverLicense, int drivingExperience) {

        if (Objects.isNull(name) || name.isBlank()) {
            this.name = "*Undetermined name*";
        } else {
            this.name = name;
        }

        try {
            setDriverLicense(driverLicense);
        } catch (DriversException e) {
            throw new RuntimeException(e);
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

    public abstract void startMoving();

    public abstract void finishMoving();

    public abstract void refuelCar();

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

    public void setDriverLicense(String driverLicense) throws DriversException {
        this.driverLicense = driverLicense;
    }

    public abstract void checkDrivers () throws DriversException;

    public static void checkDriversLicence (Driver...drivers) {
        for (Driver driver : drivers) {
            try {
                driver.checkDrivers();
            } catch (DriversException e) {
                System.out.println(e.getMessage());
                System.out.println("Please enter the information about " + driver.getName() + "'s driver's license!");
            }
        }
    }

    public void setDrivingExperience(int drivingExperience) {
        this.drivingExperience = drivingExperience;
    }

    public void setYearDriverLicense(int yearDriverLicense) {
        this.yearDriverLicense = yearDriverLicense;
    }

    @Override
    public String toString() {
        return "\nDriver: " + getName() + ". Driver license: " + driverLicense +
                ". The year of issue of the driver's license: " + getYearDriverLicense() +
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

