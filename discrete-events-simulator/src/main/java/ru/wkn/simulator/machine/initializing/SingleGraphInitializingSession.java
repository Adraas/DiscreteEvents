package ru.wkn.simulator.machine.initializing;

public class SingleGraphInitializingSession<T> extends GraphInitializingSession<T> {

    private GraphInitializer<T> graphInitializer;

    public SingleGraphInitializingSession(GraphInitializer<T> graphInitializer) {
        super(graphInitializer);
        this.graphInitializer = graphInitializer;
    }

    @Override
    public void initializeGraph() {
        graphInitializer.run();
    }
}
