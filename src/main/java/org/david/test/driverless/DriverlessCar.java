package org.david.test.driverless;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * Driverless car
 * @author David Gao
 * @date 2020-05-30 22:12:00
 */
public class DriverlessCar implements Car {
    public DriverlessCar(MovementArea movementArea, Position carPosition, String orientation) {
        this.initMovementArea(movementArea);
        this.initPosition(carPosition);
        this.initOrientation(orientation);
    }

    public static String CLOCKWISE_COMMAND = "C";
    public static String FORWARD_COMMAND = "F";

    public static String NORTH_ORIENTATION = "NORTH";
    public static String EAST_ORIENTATION = "EAST";
    public static String SOUTH_ORIENTATION = "SOUTH";
    public static String WEST_ORIENTATION = "WEST";

    private static String[] ORIENTATIONS = {NORTH_ORIENTATION, EAST_ORIENTATION, SOUTH_ORIENTATION, WEST_ORIENTATION};

    private MovementArea movementArea;

    private Position carPosition;

    private int orientationIndex;

    @Override
    public void initMovementArea(MovementArea movementArea) {
        if (movementArea != null) {
            if (movementArea.getMaxPositionX() != movementArea.getMinPositionX() && movementArea.getMaxPositionY() != movementArea.getMinPositionY()) {
                this.movementArea = movementArea;
                return;
            }
        }
        throw new CarException("ILLEGAL AREA");
    }

    @Override
    public void initPosition(Position carPosition) {
        if (carPosition != null) {
            if (carPosition.getX() > this.movementArea.getMinPositionX() && carPosition.getX() < this.movementArea.getMaxPositionX()
             && carPosition.getY() > this.movementArea.getMinPositionY() && carPosition.getY() < this.movementArea.getMaxPositionY()) {
                this.carPosition = carPosition;
                return;
            }
        }
        throw new CarException("ILLEGAL POSITION");
    }

    @Override
    public void initOrientation(String orientation) {
        if (NORTH_ORIENTATION.equalsIgnoreCase(orientation)) {
            this.orientationIndex = 0;
        } else if (EAST_ORIENTATION.equalsIgnoreCase(orientation)) {
            this.orientationIndex = 1;
        } else if (SOUTH_ORIENTATION.equalsIgnoreCase(orientation)) {
            this.orientationIndex = 2;
        } else if (WEST_ORIENTATION.equalsIgnoreCase(orientation)) {
            this.orientationIndex = 3;
        } else {
            throw new CarException("UNKNOWN ORIENTATION");
        }
    }

    @Override
    public void move(String command) {
        if (StringUtils.isNotBlank(command)) {
            if (command.equalsIgnoreCase(CLOCKWISE_COMMAND)) {
                this.orientationIndex = this.orientationIndex == 3? 0 : this.orientationIndex + 1;
                return;
            } else if (command.equalsIgnoreCase(FORWARD_COMMAND)) {
                switch (this.orientationIndex) {
                    case 0: {
                        if (this.carPosition.getY() + 1 < this.movementArea.getMaxPositionY()) {
                            this.carPosition.setY(this.carPosition.getY() + 1);
                        } else {
                            throw new CarException("OUT OF THE MOVEMENT AREA");
                        }
                        break;
                    }
                    case 1: {
                        if (this.carPosition.getX() + 1 < this.movementArea.getMaxPositionX()) {
                            this.carPosition.setX(this.carPosition.getX() + 1);
                        } else {
                            throw new CarException("OUT OF THE MOVEMENT AREA");
                        }
                        break;
                    }
                    case 2: {
                        if (this.carPosition.getY() - 1 > this.movementArea.getMinPositionY()) {
                            this.carPosition.setY(this.carPosition.getY() - 1);
                        } else {
                            throw new CarException("OUT OF THE MOVEMENT AREA");
                        }
                        break;
                    }
                    case 3: {
                        if (this.carPosition.getX() - 1 > this.movementArea.getMinPositionX()) {
                            this.carPosition.setX(this.carPosition.getX() - 1);
                        } else {
                            throw new CarException("OUT OF THE MOVEMENT AREA");
                        }
                        break;
                    }
                    default: break;
                }
                return;
            }
        }
        throw new CarException("UNKNOWN COMMAND");
    }

    @Override
    public void move(String[] commands) {
        if (commands != null) {
            Arrays.stream(commands).forEach(command -> {
                this.move(command);
            });
        }
    }

    /**
     * Get Position X
     * @return int
     */
    @Override
    public int getPositionX() {
        return this.carPosition.getX();
    }

    /**
     * Get Position Y
     * @return int
     */
    @Override
    public int getPositionY() {
        return this.carPosition.getY();
    }

    /**
     * Get orientation
     * @return String
     */
    @Override
    public String getOrientation() {
        return ORIENTATIONS[this.orientationIndex];
    }
}
