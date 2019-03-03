package ru.wkn.simulator.machine.scheduling;

import java.util.Objects;

public abstract class SchedulingSession<T> {

    private Scheduler<T> scheduler;

    public SchedulingSession(Scheduler<T> scheduler) {
        this.scheduler = scheduler;
    }

    public abstract void scheduleEventLabels();

    public Scheduler getScheduler() {
        return scheduler;
    }

    public void setScheduler(Scheduler<T> scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchedulingSession<?> that = (SchedulingSession<?>) o;
        return Objects.equals(scheduler, that.scheduler);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scheduler);
    }

    @Override
    public String toString() {
        return "SchedulingSession{" +
                "scheduler=" + scheduler +
                '}';
    }
}
