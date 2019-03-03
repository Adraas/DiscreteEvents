package ru.wkn.simulator.machine.simulating;

public class MultipleGraphCrawlingSession extends GraphCrawlingSession {

    private GraphCrawler graphCrawler;

    public MultipleGraphCrawlingSession(GraphCrawler graphCrawler) {
        super(graphCrawler);
    }

    @Override
    public void simulateCrawling() {
        Thread thread = new Thread(graphCrawler);
        thread.start();
    }
}
