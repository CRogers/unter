package mystery.actions.passenger;

import mystery.model.journey.Location;
import mystery.model.passenger.Passenger;

public class UpdatePassengerLocation {
    private final Passenger passenger;
    private final Location location;

    public UpdatePassengerLocation(Passenger passenger, Location location) {
        this.passenger = passenger;
        this.location = location;
    }


}
