package ru.wkn.entities.status;

import java.util.Map;
import java.util.Objects;

public class MachineStatus {

    private volatile Map<String, String> parameters;

    public MachineStatus(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MachineStatus that = (MachineStatus) o;
        return Objects.equals(parameters, that.parameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parameters);
    }

    @Override
    public String toString() {
        return "MachineStatus{" +
                "parameters=" + parameters +
                '}';
    }
}
