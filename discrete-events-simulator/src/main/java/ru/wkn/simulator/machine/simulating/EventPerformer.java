package ru.wkn.simulator.machine.simulating;

import org.apache.commons.graph.Vertex;
import ru.wkn.entities.graph.State;
import ru.wkn.entities.status.MachineStatus;
import ru.wkn.entities.status.access.policy.AccessPolicy;

import java.util.Objects;

public class EventPerformer {

    private MachineStatus machineStatus;
    private AccessPolicy accessPolicy;

    public EventPerformer(MachineStatus machineStatus, AccessPolicy accessPolicy) {
        this.machineStatus = machineStatus;
        this.accessPolicy = accessPolicy;
    }

    public void runProcess(Vertex currentVertex) throws InterruptedException {
        String eventType = ((State) currentVertex).getEventLabel().getEventType().toString();
        String eventTime = String.valueOf(((State) currentVertex).getEventLabel().getTimeMillis());
        String eventPriority = ((State) currentVertex).getEventLabel().getEventPriority().toString();
        String eventDescription = ((State) currentVertex).getEventLabel().getDescription();
        if (machineStatus.getParameters().isEmpty()) {
            machineStatus.getParameters().replace("Type", eventType);
            machineStatus.getParameters().replace("Time", eventTime);
            machineStatus.getParameters().replace("EventPriority", eventPriority);
            machineStatus.getParameters().replace("Description", eventDescription);
        } else {
            machineStatus.getParameters().put("Type", eventType);
            machineStatus.getParameters().put("Time", eventTime);
            machineStatus.getParameters().put("EventPriority", eventPriority);
            machineStatus.getParameters().put("Description", eventDescription);
        }
        accessPolicy.checkAccess();
        Thread.sleep(Byte.parseByte(eventTime));
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventPerformer that = (EventPerformer) o;
        return Objects.equals(machineStatus, that.machineStatus) &&
                Objects.equals(accessPolicy, that.accessPolicy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(machineStatus, accessPolicy);
    }

    @Override
    public String toString() {
        return "EventPerformer{" +
                "machineStatus=" + machineStatus +
                ", accessPolicy=" + accessPolicy +
                '}';
    }
}
