package mystery.actions.driver;

import mystery.model.journey.Journey;

public class DropOffPassenger {
    private final Journey journey;

    public DropOffPassenger(Journey journey) {
        this.journey = journey;
    }

    public void execute() {
        journey.end();
    }
}
