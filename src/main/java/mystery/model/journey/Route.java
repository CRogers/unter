package mystery.model.journey;

public class Route {
    private final Location pickupLocation;
    private final Location dropoffLocation;

    public Route(Location pickupLocation, Location dropoffLocation) {
        this.pickupLocation = pickupLocation;
        this.dropoffLocation = dropoffLocation;
    }
}
