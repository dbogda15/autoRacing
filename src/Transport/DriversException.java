package Transport;

import Driver.Driver;

import java.util.Objects;

public class DriversException extends Exception {
    private final Driver driver;

    public Driver getDriver() {
        return driver;
    }

    public DriversException (String message, Driver driver) {
        super(message);
        this.driver = driver;
    }
    }

