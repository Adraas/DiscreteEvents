package ru.wkn.simulator.machine.initializing;

public class MultipleGraphInitializingSession<T> extends GraphInitializingSession<T> {

    private GraphInitializer<T> graphInitializer;

    public MultipleGraphInitializingSession(GraphInitializer<T> graphInitializer) {
        super(graphInitializer);
        this.graphInitializer = graphInitializer;
    }

    @Override
    public void initializeGraph() {
        Thread thread = new Thread(graphInitializer);
        thread.start();
    }
}
