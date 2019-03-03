package ru.wkn.simulator.machine.initializing;

import java.util.Objects;

public abstract class GraphInitializingSession<T> {

    private GraphInitializer<T> graphInitializer;

    public GraphInitializingSession(GraphInitializer<T> graphInitializer) {
        this.graphInitializer = graphInitializer;
    }

    public abstract void initializeGraph();

    public GraphInitializer<T> getGraphInitializer() {
        return graphInitializer;
    }

    public void setGraphInitializer(GraphInitializer<T> graphInitializer) {
        this.graphInitializer = graphInitializer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphInitializingSession<?> that = (GraphInitializingSession<?>) o;
        return Objects.equals(graphInitializer, that.graphInitializer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(graphInitializer);
    }

    @Override
    public String toString() {
        return "GraphInitializingSession{" +
                "graphInitializer=" + graphInitializer +
                '}';
    }
}
