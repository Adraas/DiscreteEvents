package ru.wkn.simulator.machine.scheduling;

import ru.wkn.entities.calendar.CalendarEvents;
import ru.wkn.entities.calendar.EventLabel;

import java.util.List;
import java.util.function.Function;

public interface SchedulingSessionFactoryIF<T> {

    SchedulingSession<T> createSchedulingSession(SchedulingType schedulingType, CalendarEvents<T> calendarEvents,
                                                 List<EventLabel> eventLabels, Function<T, Boolean>[] functions);
}
