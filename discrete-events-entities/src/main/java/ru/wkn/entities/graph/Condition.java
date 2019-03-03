package ru.wkn.entities.graph;

import java.util.Objects;
import java.util.function.Function;

public class Condition<T> {

    private Function<T, Boolean> function;

    public Condition(Function<T, Boolean> function) {
        this.function = function;
    }

    public Boolean conditionIsComplete(T value) {
        return function.apply(value);
    }

    public Function<T, Boolean> getFunction() {
        return function;
    }

    public void setFunction(Function<T, Boolean> function) {
        this.function = function;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "function=" + function +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Condition<?> condition = (Condition<?>) o;
        return Objects.equals(function, condition.function);
    }

    @Override
    public int hashCode() {
        return Objects.hash(function);
    }
}
