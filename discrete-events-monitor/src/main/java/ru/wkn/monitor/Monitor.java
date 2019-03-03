package ru.wkn.monitor;

import ru.wkn.entities.status.MachineStatus;
import ru.wkn.entities.status.access.policy.AccessPolicy;

import java.io.Writer;
import java.util.Objects;
import java.util.function.Consumer;

public class Monitor implements Runnable {

    private MachineStatus machineStatus;
    private AccessPolicy accessPolicy;
    private Writer writer;
    private Consumer<Writer> writerConsumer;

    public Monitor(MachineStatus machineStatus, AccessPolicy accessPolicy, Writer writer, Consumer<Writer> writerConsumer) {
        this.machineStatus = machineStatus;
        this.accessPolicy = accessPolicy;
        this.writer = writer;
        this.writerConsumer = writerConsumer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                writerConsumer.accept(writer);
                accessPolicy.checkAccess();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public MachineStatus getMachineStatus() {
        return machineStatus;
    }

    public void setMachineStatus(MachineStatus machineStatus) {
        this.machineStatus = machineStatus;
    }

    public AccessPolicy getAccessPolicy() {
        return accessPolicy;
    }

    public void setAccessPolicy(AccessPolicy accessPolicy) {
        this.accessPolicy = accessPolicy;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    public Consumer<Writer> getWriterConsumer() {
        return writerConsumer;
    }

    public void setWriterConsumer(Consumer<Writer> writerConsumer) {
        this.writerConsumer = writerConsumer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monitor monitor = (Monitor) o;
        return Objects.equals(machineStatus, monitor.machineStatus) &&
                Objects.equals(accessPolicy, monitor.accessPolicy) &&
                Objects.equals(writer, monitor.writer) &&
                Objects.equals(writerConsumer, monitor.writerConsumer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(machineStatus, accessPolicy, writer, writerConsumer);
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "machineStatus=" + machineStatus +
                ", accessPolicy=" + accessPolicy +
                ", writer=" + writer +
                ", writerConsumer=" + writerConsumer +
                '}';
    }
}
