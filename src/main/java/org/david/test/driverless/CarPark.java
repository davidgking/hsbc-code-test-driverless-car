package org.david.test.driverless;

/**
 * Car park
 * @author David Gao
 * @date 2020-05-30 22:12:00
 */
public class CarPark implements MovementArea{
    public CarPark() {}

    public CarPark(int minPositionX, int minPositionY, int maxPositionX, int maxPositionY) {
        this.minPositionX = minPositionX;
        this.minPositionY = minPositionY;
        this.maxPositionX = maxPositionX;
        this.maxPositionY = maxPositionY;
    }

    private int minPositionX;

    private int minPositionY;

    private int maxPositionX;

    private int maxPositionY;

    @Override
    public int getMaxPositionX() {
        return maxPositionX;
    }

    public void setMaxPositionX(int maxPositionX) {
        this.maxPositionX = maxPositionX;
    }

    @Override
    public int getMinPositionX() {
        return minPositionX;
    }

    public void setMinPositionX(int minPositionX) {
        this.minPositionX = minPositionX;
    }

    @Override
    public int getMaxPositionY() {
        return maxPositionY;
    }

    public void setMaxPositionY(int maxPositionY) {
        this.maxPositionY = maxPositionY;
    }

    @Override
    public int getMinPositionY() {
        return minPositionY;
    }

    public void setMinPositionY(int minPositionY) {
        this.minPositionY = minPositionY;
    }
}
