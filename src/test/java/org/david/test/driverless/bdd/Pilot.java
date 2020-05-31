package org.david.test.driverless.bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Pilot
 * @author David Gao
 * @date 2020-05-30 22:12:00
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
                 tags = {"@Pilot"},
                 glue = {"org/david/test/driverless/bdd/step"})
public class Pilot {
}
