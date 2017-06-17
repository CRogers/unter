package mystery.actions.passenger;

import mystery.model.journey.Journey;
import mystery.model.passenger.Passenger;
import mystery.model.journey.Route;
import mystery.model.driver.Driver;
import mystery.model.driver.DriverFinder;

public class RequestJourney {
    private final Passenger passenger;
    private final Route route;

    public RequestJourney(Passenger passenger, Route route) {
        this.passenger = passenger;
        this.route = route;
    }

    public void execute() {
        Driver driver = new DriverFinder().findDriverFor(route);
        Journey journey = new Journey(
                passenger,
                driver,
                route
        );
    }

}
