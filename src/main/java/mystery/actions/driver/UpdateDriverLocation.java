package mystery.actions.driver;

import mystery.model.driver.Driver;
import mystery.model.journey.Location;

public class UpdateDriverLocation {
    private final Driver driver;
    private final Location location;

    public UpdateDriverLocation(Driver driver, Location location) {
        this.driver = driver;
        this.location = location;
    }

    public void execute() {

    }
}
