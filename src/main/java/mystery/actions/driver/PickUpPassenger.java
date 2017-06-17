package mystery.actions.driver;

import mystery.model.journey.Journey;

public class PickUpPassenger {
    private final Journey journey;

    public PickUpPassenger(Journey journey) {
        this.journey = journey;
    }

    public void execute() {
        journey.start();
    }
}
