package org.david.test.driverless.bdd.step;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.david.test.driverless.*;
import org.junit.Assert;

public class Pilot1Steps {
    private MovementArea carPark;
    private Car driverlessCar;

    @Given("^Build a rectangular car park min X:(\\S*) min Y:(\\S*), max X:(\\S*) max Y:(\\S*) and drive a car in it X:(\\S*) Y:(\\S*), orientation:(\\S*)$")
    public void build_a_rectangular_car_park_movement_area_and_driver_a_car_in_it_position_orientation_EAST(int minPositionX, int minPositionY, int maxPositionX, int maxPositionY, int carPositionX, int carPositionY, String carOrientation) {
        this.carPark = new CarPark(minPositionX, minPositionY, maxPositionX, maxPositionY);
        Position carPosition = new Position(carPositionX, carPositionY);
        this.driverlessCar = new DriverlessCar(this.carPark, carPosition, carOrientation);
    }

    @When("^Input the commands:(\\S*)$")
    public void input_the_Commands_CLOCKWISE_FORWARD_FORWARD_FORWAR_CLOCKWISE(String commands) throws Exception {
        if (StringUtils.isNotBlank(commands)) {
            try {
                this.driverlessCar.move(commands.split(","));
            } catch (CarException e) {
                Assert.assertEquals(e.getMessage(), "OUT OF THE MOVEMENT AREA");
            }
        } else {
            throw new Exception("ILLEGAL PARAMETERS");
        }
    }

    @Then("^The car will be on X:(\\S*) Y:(\\S*), orientation:(\\S*)$")
    public void the_car_will_be_on(int carLastPositionX, int carLastPositionY, String carLastOrientation) {
        Assert.assertEquals(this.driverlessCar.getPositionX(), carLastPositionX);
        Assert.assertEquals(this.driverlessCar.getPositionY(), carLastPositionY);
        Assert.assertEquals(this.driverlessCar.getOrientation(), carLastOrientation);
    }
}
