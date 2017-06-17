package mystery.model.journey;

import mystery.model.passenger.Passenger;
import mystery.model.driver.Driver;
import mystery.model.payment.Money;
import mystery.model.payment.PaymentCalculator;

public class Journey {
    private final Passenger passenger;
    private final Driver driver;
    private final Route route;

    public Journey(Passenger passenger, Driver driver, Route route) {
        this.passenger = passenger;
        this.driver = driver;
        this.route = route;
    }

    public void start() {

    }

    public void end() {
        Money amount = new PaymentCalculator().forRoute(route);
        passenger.charge(amount);
    }
}
