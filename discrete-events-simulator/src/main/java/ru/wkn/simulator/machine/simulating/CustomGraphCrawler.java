package ru.wkn.simulator.machine.simulating;

import org.apache.commons.graph.DirectedGraph;

public class CustomGraphCrawler extends GraphCrawler {

    private DirectedGraph directedGraph;
    private EventPerformer eventPerformer;
    private Double[] conditionResults;

    public CustomGraphCrawler(DirectedGraph directedGraph, EventPerformer eventPerformer, Double... conditionResults) {
        super(directedGraph, eventPerformer, conditionResults);
        this.directedGraph = directedGraph;
        this.eventPerformer = eventPerformer;
        this.conditionResults = conditionResults;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException();
    }
}
