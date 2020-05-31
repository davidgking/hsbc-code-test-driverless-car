package org.david.test.driverless;

/**
 * Car Exception
 * @author David Gao
 * @date 2020-05-30 22:12:00
 */
public class CarException extends RuntimeException {
    public CarException() {
        super();
    }

    public CarException(String message) {
        super(message);
    }
}
