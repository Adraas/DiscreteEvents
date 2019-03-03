package ru.wkn.simulator.machine.initializing;

import org.apache.commons.graph.Edge;
import org.apache.commons.graph.Vertex;
import org.apache.commons.graph.contract.Contract;
import ru.wkn.entities.calendar.CalendarEvents;

import java.util.Set;

public interface GraphInitializerFactoryIF<T> {

    GraphInitializingSession<T> createGraphInitializingSession(GraphInitializingType graphInitializingType,
                                                               CalendarEvents<T> calendarEvents, Contract contract,
                                                               Vertex startVertex, Set<Edge> edges);
}
