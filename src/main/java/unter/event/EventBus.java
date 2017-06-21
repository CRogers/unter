package unter.event;

import one.util.streamex.EntryStream;
import unter.Event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EventBus {
    private final List<Event> events = new ArrayList<>();
    private final Map<Predicate<Event>, Consumer<Event>> listeners = new HashMap<>();

    public void submitEvent(Event event) {
        events.add(event);
        EntryStream.of(listeners)
                .filterKeys(predicate -> predicate.test(event))
                .values()
                .forEach(consumer -> consumer.accept(event));
    }

    public List<Event> history(Predicate<Event> eventPredicate) {
        return events.stream()
                .filter(eventPredicate)
                .collect(Collectors.toList());
    }

    public <T extends Event> void registerListener(Predicate<T> predicate, Consumer<T> handler) {
        listeners.put((Predicate<Event>) predicate, (Consumer<Event>) handler);
    }
}
