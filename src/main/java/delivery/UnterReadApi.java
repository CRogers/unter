package delivery;

import unter.read.Timeline;

import java.util.List;

public class UnterReadApi {
    private final Timeline timeline;

    public UnterReadApi(Timeline timeline) {
        this.timeline = timeline;
    }

    public List<Message> timelineFor(Username user) {
        return timeline.timelineFor(user);
    }
}
