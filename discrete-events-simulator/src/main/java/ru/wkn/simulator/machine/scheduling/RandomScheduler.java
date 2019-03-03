package ru.wkn.simulator.machine.scheduling;

import ru.wkn.entities.calendar.CalendarEvents;
import ru.wkn.entities.calendar.EventLabel;
import ru.wkn.entities.calendar.EventPriority;
import ru.wkn.entities.calendar.EventType;
import ru.wkn.entities.calendar.Pair;

import java.util.Random;
import java.util.function.Function;

public class RandomScheduler<T> extends Scheduler<T> {

    private CalendarEvents<T> calendarEvents;
    private Function<T, Boolean>[] functions;

    public RandomScheduler(CalendarEvents<T> calendarEvents, Function<T, Boolean>[] functions) {
        super(calendarEvents, null, functions);
        this.calendarEvents = calendarEvents;
        this.functions = functions;
    }

    @Override
    public void run() {
        int quantityEvents = functions.length;
        calendarEvents.getEventLabels().clear();
        for (int i = 0; i < quantityEvents; i++) {
            Pair<EventLabel, Function<T, Boolean>> currentPair = new Pair<>(createRandomEventLabel(i), functions[i]);
            calendarEvents.getEventLabels().put(i, currentPair);
        }
    }

    private EventLabel createRandomEventLabel(int index) {
        EventType eventType = EventType.RANDOM;
        byte timeMillis = (byte) Math.abs((byte) (new Random().nextLong()));
        int priority = (int) Math.round(Math.random() * 3);
        EventPriority eventPriority = priority <= 1 ? EventPriority.LOW
                : priority <= 2 ? EventPriority.MEDIUM
                : EventPriority.HIGH;
        String description = String.valueOf(index);
        return new EventLabel(eventType, timeMillis, eventPriority, description);
    }
}
