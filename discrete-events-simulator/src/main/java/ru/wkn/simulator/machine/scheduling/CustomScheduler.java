package ru.wkn.simulator.machine.scheduling;

import ru.wkn.entities.calendar.CalendarEvents;
import ru.wkn.entities.calendar.EventLabel;

import java.util.List;
import java.util.function.Function;

public class CustomScheduler<T> extends Scheduler<T> {

    private CalendarEvents<T> calendarEvents;
    private List<EventLabel> eventLabels;
    private Function<T, Boolean>[] functions;

    public CustomScheduler(CalendarEvents<T> calendarEvents, List<EventLabel> eventLabels, Function<T, Boolean>[] functions) {
        super(calendarEvents, eventLabels, functions);
        this.calendarEvents = calendarEvents;
        this.eventLabels = eventLabels;
        this.functions = functions;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException();
    }
}
