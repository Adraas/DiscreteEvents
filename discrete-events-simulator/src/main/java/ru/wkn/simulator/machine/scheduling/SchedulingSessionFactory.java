package ru.wkn.simulator.machine.scheduling;

import ru.wkn.entities.calendar.CalendarEvents;
import ru.wkn.entities.calendar.EventLabel;

import java.util.List;
import java.util.function.Function;

public class SchedulingSessionFactory<T> implements SchedulingSessionFactoryIF<T> {

    @Override
    public SchedulingSession<T> createSchedulingSession(SchedulingType schedulingType, CalendarEvents<T> calendarEvents,
                                                List<EventLabel> eventLabels, Function<T, Boolean>[] functions) {
        Scheduler<T> scheduler = createScheduler(calendarEvents, eventLabels, functions);
        return schedulingType.equals(SchedulingType.SINGLE) ? new SingleSchedulingSession<>(scheduler)
                : schedulingType.equals(SchedulingType.MULTIPLE) ? new MultipleSchedulingSession<>(scheduler)
                : null;
    }

    private Scheduler<T> createScheduler(CalendarEvents<T> calendarEvents, List<EventLabel> eventLabels, Function<T, Boolean>[] functions) {
        if (calendarEvents != null && functions != null) {
            if (eventLabels != null) {
                return new CustomScheduler<>(calendarEvents, eventLabels, functions);
            } else {
                return new RandomScheduler<>(calendarEvents, functions);
            }
        }
        return null;
    }
}
