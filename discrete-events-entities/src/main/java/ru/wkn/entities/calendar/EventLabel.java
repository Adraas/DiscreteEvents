package ru.wkn.entities.calendar;

import java.util.Objects;

public class EventLabel {

    private EventType eventType;
    private byte timeMillis;
    private EventPriority eventPriority;
    private String description;

    public EventLabel(EventType eventType, byte timeMillis, EventPriority eventPriority, String description) {
        this.eventType = eventType;
        this.timeMillis = timeMillis;
        this.eventPriority = eventPriority;
        this.description = description;
    }

    public EventType getEventType() {
        return eventType;
    }

    public long getTimeMillis() {
        return timeMillis;
    }

    public EventPriority getEventPriority() {
        return eventPriority;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "EventLabel{" +
                "eventType=" + eventType +
                ", timeMillis=" + timeMillis +
                ", eventPriority=" + eventPriority +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventLabel that = (EventLabel) o;
        return timeMillis == that.timeMillis &&
                eventType == that.eventType &&
                eventPriority == that.eventPriority &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventType, timeMillis, eventPriority, description);
    }
}
