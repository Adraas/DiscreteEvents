package ru.wkn.entities.graph;

import org.apache.commons.graph.Edge;
import org.apache.commons.graph.Vertex;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ConditionEdge<T> implements Edge {

    private Vertex firstVertex;
    private Vertex secondVertex;
    private Condition<T> condition;

    public ConditionEdge(Vertex firstVertex, Vertex secondVertex, Condition<T> condition) {
        this.firstVertex = firstVertex;
        this.secondVertex = secondVertex;
        this.condition = condition;
    }

    public Set<Vertex> getVertices() {
        Set<Vertex> vertices = new HashSet<>();
        vertices.add(firstVertex);
        vertices.add(secondVertex);
        return vertices;
    }

    public Vertex getFirstVertex() {
        return firstVertex;
    }

    public void setFirstVertex(Vertex firstVertex) {
        this.firstVertex = firstVertex;
    }

    public Vertex getSecondVertex() {
        return secondVertex;
    }

    public void setSecondVertex(Vertex secondVertex) {
        this.secondVertex = secondVertex;
    }

    public Condition<T> getCondition() {
        return condition;
    }

    public void setCondition(Condition<T> condition) {
        this.condition = condition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConditionEdge<?> that = (ConditionEdge<?>) o;
        return Objects.equals(firstVertex, that.firstVertex) &&
                Objects.equals(secondVertex, that.secondVertex) &&
                Objects.equals(condition, that.condition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstVertex, secondVertex, condition);
    }

    @Override
    public String toString() {
        return "ConditionEdge{" +
                "firstVertex=" + firstVertex +
                ", secondVertex=" + secondVertex +
                ", condition=" + condition +
                '}';
    }
}
