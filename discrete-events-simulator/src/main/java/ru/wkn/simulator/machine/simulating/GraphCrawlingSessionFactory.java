package ru.wkn.simulator.machine.simulating;

import org.apache.commons.graph.DirectedGraph;

public class GraphCrawlingSessionFactory implements GraphCrawlingSessionFactoryIF {

    private DirectedGraph directedGraph;
    private EventPerformer eventPerformer;

    @Override
    public GraphCrawlingSession createGraphCrawlingSession(GraphCrawlingType graphCrawlingType, DirectedGraph directedGraph,
                                                   EventPerformer eventPerformer, Double... conditionResults) {
        GraphCrawler graphCrawler = createGraphCrawler(directedGraph, eventPerformer, conditionResults);
        return graphCrawlingType.equals(GraphCrawlingType.SINGLE) ? new SingleGraphCrawlingSession(graphCrawler)
                : graphCrawlingType.equals(GraphCrawlingType.MULTIPLE) ? new MultipleGraphCrawlingSession(graphCrawler)
                : null;
    }

    private GraphCrawler createGraphCrawler(DirectedGraph directedGraph, EventPerformer eventPerformer,
                                            Double... conditionResults) {
        return (conditionResults == null || conditionResults.length == 0) ? new RandomGraphCrawler(directedGraph, eventPerformer)
                : new CustomGraphCrawler(directedGraph, eventPerformer, conditionResults);
    }
}
