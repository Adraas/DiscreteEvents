package ru.wkn.simulator.machine.simulating;

public class SingleGraphCrawlingSession extends GraphCrawlingSession {

    private GraphCrawler graphCrawler;

    public SingleGraphCrawlingSession(GraphCrawler graphCrawler) {
        super(graphCrawler);
        this.graphCrawler = graphCrawler;
    }

    @Override
    public void simulateCrawling() {
        graphCrawler.run();
    }
}
