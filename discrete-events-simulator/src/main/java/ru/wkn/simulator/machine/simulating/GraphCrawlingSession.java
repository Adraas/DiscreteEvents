package ru.wkn.simulator.machine.simulating;

import java.util.Objects;

public abstract class GraphCrawlingSession {

    private GraphCrawler graphCrawler;

    public GraphCrawlingSession(GraphCrawler graphCrawler) {
        this.graphCrawler = graphCrawler;
    }

    public abstract void simulateCrawling();

    public GraphCrawler getGraphCrawler() {
        return graphCrawler;
    }

    public void setGraphCrawler(GraphCrawler graphCrawler) {
        this.graphCrawler = graphCrawler;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphCrawlingSession that = (GraphCrawlingSession) o;
        return Objects.equals(graphCrawler, that.graphCrawler);
    }

    @Override
    public int hashCode() {
        return Objects.hash(graphCrawler);
    }

    @Override
    public String toString() {
        return "GraphCrawlingSession{" +
                "graphCrawler=" + graphCrawler +
                '}';
    }
}
