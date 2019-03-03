package ru.wkn.simulator.machine.initializing;

import org.apache.commons.graph.contract.Contract;
import ru.wkn.entities.calendar.CalendarEvents;

import java.util.Objects;

public abstract class GraphInitializer<T> implements Runnable {

    private CalendarEvents<T> calendarEvents;
    private Contract contract;

    public GraphInitializer(CalendarEvents<T> calendarEvents, Contract contract) {
        this.calendarEvents = calendarEvents;
        this.contract = contract;
    }

    public CalendarEvents<T> getCalendarEvents() {
        return calendarEvents;
    }

    public void setCalendarEvents(CalendarEvents<T> calendarEvents) {
        this.calendarEvents = calendarEvents;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphInitializer<?> that = (GraphInitializer<?>) o;
        return Objects.equals(calendarEvents, that.calendarEvents) &&
                Objects.equals(contract, that.contract);
    }

    @Override
    public int hashCode() {
        return Objects.hash(calendarEvents, contract);
    }

    @Override
    public String toString() {
        return "GraphInitializer{" +
                "calendarEvents=" + calendarEvents +
                ", contract=" + contract +
                '}';
    }
}
