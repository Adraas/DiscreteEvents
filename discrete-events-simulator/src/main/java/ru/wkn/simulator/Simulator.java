package ru.wkn.simulator;

import ru.wkn.simulator.machine.initializing.GraphInitializingSession;
import ru.wkn.simulator.machine.scheduling.SchedulingSession;
import ru.wkn.simulator.machine.simulating.GraphCrawlingSession;

import java.util.Objects;

public class Simulator<T> extends Thread {

    private SchedulingSession<T> schedulingSession;
    private GraphInitializingSession<T> graphInitializingSession;
    private GraphCrawlingSession graphCrawlingSession;

    public Simulator(SchedulingSession<T> schedulingSession, GraphInitializingSession<T> graphInitializingSession,
                     GraphCrawlingSession graphCrawlingSession) {
        this.schedulingSession = schedulingSession;
        this.graphInitializingSession = graphInitializingSession;
        this.graphCrawlingSession = graphCrawlingSession;
    }

    @Override
    public void run() {
        schedulingSession.scheduleEventLabels();
        graphInitializingSession.initializeGraph();
        graphCrawlingSession.simulateCrawling();
    }

    public SchedulingSession<T> getSchedulingSession() {
        return schedulingSession;
    }

    public void setSchedulingSession(SchedulingSession<T> schedulingSession) {
        this.schedulingSession = schedulingSession;
    }

    public GraphInitializingSession<T> getGraphInitializingSession() {
        return graphInitializingSession;
    }

    public void setGraphInitializingSession(GraphInitializingSession<T> graphInitializingSession) {
        this.graphInitializingSession = graphInitializingSession;
    }

    public GraphCrawlingSession getGraphCrawlingSession() {
        return graphCrawlingSession;
    }

    public void setGraphCrawlingSession(GraphCrawlingSession graphCrawlingSession) {
        this.graphCrawlingSession = graphCrawlingSession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Simulator<?> simulator = (Simulator<?>) o;
        return Objects.equals(schedulingSession, simulator.schedulingSession) &&
                Objects.equals(graphInitializingSession, simulator.graphInitializingSession) &&
                Objects.equals(graphCrawlingSession, simulator.graphCrawlingSession);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schedulingSession, graphInitializingSession, graphCrawlingSession);
    }

    @Override
    public String toString() {
        return "Simulator{" +
                "schedulingSession=" + schedulingSession +
                ", graphInitializingSession=" + graphInitializingSession +
                ", graphCrawlingSession=" + graphCrawlingSession +
                '}';
    }
}
