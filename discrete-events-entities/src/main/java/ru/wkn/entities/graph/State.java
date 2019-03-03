package ru.wkn.entities.graph;

import org.apache.commons.graph.Vertex;
import ru.wkn.entities.calendar.EventLabel;

import java.util.Objects;

public class State implements Vertex {

    private EventLabel eventLabel;

    public State(EventLabel eventLabel) {
        this.eventLabel = eventLabel;
    }

    public EventLabel getEventLabel() {
        return eventLabel;
    }

    public void setEventLabel(EventLabel eventLabel) {
        this.eventLabel = eventLabel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return Objects.equals(eventLabel, state.eventLabel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventLabel);
    }

    @Override
    public String toString() {
        return "State{" +
                "eventLabel=" + eventLabel +
                '}';
    }
}
