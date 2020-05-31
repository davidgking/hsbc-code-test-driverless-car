package org.david.test.driverless;

/**
 * Car
 * @author David Gao
 * @date 2020-05-30 22:12:00
 */
public interface Car {
    void initMovementArea(MovementArea movementArea);

    void initPosition(Position position);

    void initOrientation(String orientation);

    void move(String command);

    void move(String[] commands);

    int getPositionX();

    int getPositionY();

    String getOrientation();
}
