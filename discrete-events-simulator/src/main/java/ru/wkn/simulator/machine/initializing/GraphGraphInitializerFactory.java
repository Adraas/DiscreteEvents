package ru.wkn.simulator.machine.initializing;

import org.apache.commons.graph.Edge;
import org.apache.commons.graph.Vertex;
import org.apache.commons.graph.contract.Contract;
import ru.wkn.entities.calendar.CalendarEvents;

import java.util.Set;

public class GraphGraphInitializerFactory<T> implements GraphInitializerFactoryIF<T> {

    @Override
    public GraphInitializingSession<T> createGraphInitializingSession(GraphInitializingType graphInitializingType,
                                                                      CalendarEvents<T> calendarEvents, Contract contract,
                                                                      Vertex startVertex, Set<Edge> edges) {
        GraphInitializer<T> graphInitializer = createGraphInitializer(calendarEvents, contract, startVertex, edges);
        return graphInitializingType.equals(GraphInitializingType.SINGLE) ? new SingleGraphInitializingSession<>(graphInitializer)
                : graphInitializingType.equals(GraphInitializingType.MULTIPLE) ? new MultipleGraphInitializingSession<>(graphInitializer)
                : null;
    }

    private GraphInitializer<T> createGraphInitializer(CalendarEvents<T> calendarEvents, Contract contract,
                                                       Vertex startVertex, Set<Edge> edges) {
        return checkParameters(startVertex, edges) ? new CustomGraphInitializer<>(calendarEvents, contract, startVertex, edges)
                : new RandomGraphInitializer<>(calendarEvents, contract);
    }

    private boolean checkParameters(Vertex startVertex, Set<Edge> edges) {
        if (startVertex == null) {
            return false;
        }
        if (edges == null) {
            return false;
        } else {
            return !edges.isEmpty();
        }
    }
}
