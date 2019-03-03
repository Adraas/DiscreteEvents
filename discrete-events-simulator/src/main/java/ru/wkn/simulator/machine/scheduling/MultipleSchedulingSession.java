package ru.wkn.simulator.machine.scheduling;

public class MultipleSchedulingSession<T> extends SchedulingSession<T> {

    private Scheduler<T> scheduler;

    public MultipleSchedulingSession(Scheduler<T> scheduler) {
        super(scheduler);
        this.scheduler = scheduler;
    }

    @Override
    public void scheduleEventLabels() {
        Thread thread = new Thread(scheduler);
        thread.start();
    }
}
