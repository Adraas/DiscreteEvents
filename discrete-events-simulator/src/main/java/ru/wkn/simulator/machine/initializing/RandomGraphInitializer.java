package ru.wkn.simulator.machine.initializing;

import org.apache.commons.graph.Edge;
import org.apache.commons.graph.Vertex;
import org.apache.commons.graph.contract.Contract;
import ru.wkn.entities.calendar.CalendarEvents;
import ru.wkn.entities.calendar.EventLabel;
import ru.wkn.entities.calendar.Pair;
import ru.wkn.entities.graph.Condition;
import ru.wkn.entities.graph.ConditionEdge;
import ru.wkn.entities.graph.State;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class RandomGraphInitializer<T> extends GraphInitializer<T> {

    private CalendarEvents<T> calendarEvents;
    private Contract contract;

    public RandomGraphInitializer(CalendarEvents<T> calendarEvents, Contract contract) {
        super(calendarEvents, contract);
        this.calendarEvents = calendarEvents;
        this.contract = contract;
    }

    @Override
    public void run() {
        int size = calendarEvents.getEventLabels().size();
        Set<Vertex> vertices = randomStatesInit(size);
        randomConnectGraph(size, vertices);
    }

    private Set<Vertex> randomStatesInit(int size) {
        Set<Vertex> vertices = new HashSet<>();
        for (int i = 0; i < size; i++) {
            vertices.add(stateInit(i));
        }
        return vertices;
    }

    private Vertex stateInit(int index) {
        Pair<EventLabel, Function<T, Boolean>> pair = calendarEvents.getEventLabels().get(index);
        EventLabel eventLabel = pair.getFirstValue();
        return new State(eventLabel);
    }

    private void randomConnectGraph(int size, Set<Vertex> vertices) {
        Iterator<Vertex> vertexIterator = vertices.iterator();
        List<Function<T, Boolean>> functions = new ArrayList<>();
        calendarEvents.getEventLabels().values().forEach(pair -> functions.add(pair.getSecondValue()));
        while (vertexIterator.hasNext()) {
            Vertex vertex = vertexIterator.next();
            int quantityLinks = (int) Math.round(Math.random() * size);
            for (int i = 0; i < quantityLinks; i++) {
                Vertex targetVertex = getRandomVertex(size, vertices);
                int targetVertexIndex = indexOfTargetVertex(vertices, targetVertex);
                Edge edge = new ConditionEdge(vertex, targetVertex, new Condition<>(functions.get(targetVertexIndex)));
                contract.addEdge(edge, vertex, targetVertex);
            }
        }
    }

    private Vertex getRandomVertex(int size, Set<Vertex> vertices) {
        int coefficient = (int) Math.round(Math.random() * size);
        int index = 0;
        Iterator<Vertex> vertexIterator = vertices.iterator();
        while (index != coefficient && vertexIterator.hasNext()) {
            vertexIterator.next();
            index++;
        }
        if (vertexIterator.hasNext()) {
            return vertexIterator.next();
        } else {
            return getRandomVertex(size, vertices);
        }
    }

    private int indexOfTargetVertex(Set<Vertex> vertices, Vertex targetVertex) {
        int index = 0;
        for (Vertex currentVertex : vertices) {
            if (currentVertex.equals(targetVertex)) {
                return index;
            }
            index++;
        }
        return 0;
    }
}
