package ru.wkn.entities.calendar;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class CalendarEvents<T> {

    private Map<Integer, Pair<EventLabel, Function<T, Boolean>>> eventLabels;

    public CalendarEvents() {
        eventLabels = new HashMap<>();
    }

    public Map<Integer, Pair<EventLabel, Function<T, Boolean>>> getEventLabels() {
        return eventLabels;
    }
}
