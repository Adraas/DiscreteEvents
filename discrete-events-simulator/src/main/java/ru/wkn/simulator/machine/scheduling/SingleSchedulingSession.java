package ru.wkn.simulator.machine.scheduling;

public class SingleSchedulingSession<T> extends SchedulingSession<T> {

    private Scheduler<T> scheduler;

    public SingleSchedulingSession(Scheduler<T> scheduler) {
        super(scheduler);
        this.scheduler = scheduler;
    }

    @Override
    public void scheduleEventLabels() {
        scheduler.run();
    }
}
