package ru.wkn.simulator.machine.simulating;

import org.apache.commons.graph.DirectedGraph;

import java.util.Arrays;
import java.util.Objects;

public abstract class GraphCrawler implements Runnable {

    private DirectedGraph directedGraph;
    private EventPerformer eventPerformer;
    private Double[] conditionResults;

    public GraphCrawler(DirectedGraph directedGraph, EventPerformer eventPerformer, Double... conditionResults) {
        this.directedGraph = directedGraph;
        this.eventPerformer = eventPerformer;
        this.conditionResults = conditionResults;
    }

    public DirectedGraph getDirectedGraph() {
        return directedGraph;
    }

    public void setDirectedGraph(DirectedGraph directedGraph) {
        this.directedGraph = directedGraph;
    }

    public EventPerformer getEventPerformer() {
        return eventPerformer;
    }

    public void setEventPerformer(EventPerformer eventPerformer) {
        this.eventPerformer = eventPerformer;
    }

    public Double[] getConditionResults() {
        return conditionResults;
    }

    public void setConditionResults(Double[] conditionResults) {
        this.conditionResults = conditionResults;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphCrawler that = (GraphCrawler) o;
        return Objects.equals(directedGraph, that.directedGraph) &&
                Objects.equals(eventPerformer, that.eventPerformer) &&
                Arrays.equals(conditionResults, that.conditionResults);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(directedGraph, eventPerformer);
        result = 31 * result + Arrays.hashCode(conditionResults);
        return result;
    }

    @Override
    public String toString() {
        return "GraphCrawler{" +
                "directedGraph=" + directedGraph +
                ", eventPerformer=" + eventPerformer +
                ", conditionResults=" + Arrays.toString(conditionResults) +
                '}';
    }
}
