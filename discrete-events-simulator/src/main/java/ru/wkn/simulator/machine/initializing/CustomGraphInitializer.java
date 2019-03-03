package ru.wkn.simulator.machine.initializing;

import org.apache.commons.graph.Edge;
import org.apache.commons.graph.Vertex;
import org.apache.commons.graph.contract.Contract;
import ru.wkn.entities.calendar.CalendarEvents;

import java.util.Set;

public class CustomGraphInitializer<T> extends GraphInitializer<T> {

    private CalendarEvents<T> calendarEvents;
    private Contract contract;
    private Vertex startVertex;
    private Set<Edge> edges;

    public CustomGraphInitializer(CalendarEvents<T> calendarEvents, Contract contract, Vertex startVertex, Set<Edge> edges) {
        super(calendarEvents, contract);
        this.calendarEvents = calendarEvents;
        this.contract = contract;
        this.startVertex = startVertex;
        this.edges = edges;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException();
    }
}
