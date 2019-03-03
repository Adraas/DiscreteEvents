package ru.wkn.simulator.machine.simulating;

import org.apache.commons.graph.DirectedGraph;

public interface GraphCrawlingSessionFactoryIF {

    GraphCrawlingSession createGraphCrawlingSession(GraphCrawlingType graphCrawlingType, DirectedGraph directedGraph,
                                                    EventPerformer eventPerformer, Double... conditionResults);
}
