package ru.wkn.simulator.machine.scheduling;

import ru.wkn.entities.calendar.CalendarEvents;
import ru.wkn.entities.calendar.EventLabel;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public abstract class Scheduler<T> implements Runnable {

    private CalendarEvents<T> calendarEvents;
    private List<EventLabel> eventLabels;
    private Function<T, Boolean>[] functions;

    public Scheduler(CalendarEvents<T> calendarEvents, List<EventLabel> eventLabels, Function<T, Boolean>[] functions) {
        this.calendarEvents = calendarEvents;
        this.eventLabels = eventLabels;
        this.functions = functions;
    }

    public CalendarEvents<T> getCalendarEvents() {
        return calendarEvents;
    }

    public void setCalendarEvents(CalendarEvents<T> calendarEvents) {
        this.calendarEvents = calendarEvents;
    }

    public List<EventLabel> getEventLabels() {
        return eventLabels;
    }

    public void setEventLabels(List<EventLabel> eventLabels) {
        this.eventLabels = eventLabels;
    }

    public Function<T, Boolean>[] getFunctions() {
        return functions;
    }

    public void setFunctions(Function<T, Boolean>[] functions) {
        this.functions = functions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scheduler<?> scheduler = (Scheduler<?>) o;
        return Objects.equals(calendarEvents, scheduler.calendarEvents) &&
                Objects.equals(eventLabels, scheduler.eventLabels) &&
                Arrays.equals(functions, scheduler.functions);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(calendarEvents, eventLabels);
        result = 31 * result + Arrays.hashCode(functions);
        return result;
    }

    @Override
    public String toString() {
        return "Scheduler{" +
                "calendarEvents=" + calendarEvents +
                ", eventLabels=" + eventLabels +
                ", functions=" + Arrays.toString(functions) +
                '}';
    }
}
