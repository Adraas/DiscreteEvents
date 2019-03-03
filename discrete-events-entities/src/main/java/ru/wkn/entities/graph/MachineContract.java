package ru.wkn.entities.graph;

import org.apache.commons.graph.DirectedGraph;
import org.apache.commons.graph.Edge;
import org.apache.commons.graph.Vertex;
import org.apache.commons.graph.contract.Contract;
import org.apache.commons.graph.exception.GraphException;

import java.util.Objects;

public class MachineContract implements Contract {

    private DirectedGraph directedGraph;

    public MachineContract(DirectedGraph directedGraph) {
        this.directedGraph = directedGraph;
    }

    public DirectedGraph getDirectedGraph() {
        return directedGraph;
    }

    @Override
    public void setImpl(DirectedGraph directedGraph) {
        this.directedGraph = directedGraph;
    }

    @Override
    public Class getInterface() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void verify() throws GraphException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addEdge(Edge edge, Vertex firstVertex, Vertex secondVertex) throws GraphException {
        ((StateMachine) directedGraph).getEdges().add(edge);
        if (((StateMachine) directedGraph).getStartVertex() == null) {
            ((StateMachine) directedGraph).setStartVertex(firstVertex);
        }
        addVertex(firstVertex);
        addVertex(secondVertex);
    }

    @Override
    public void addVertex(Vertex vertex) throws GraphException {
        ((StateMachine) directedGraph).getVertices().add(vertex);
        if (((StateMachine) directedGraph).getStartVertex() == null) {
            ((StateMachine) directedGraph).setStartVertex(vertex);
        }
        ((StateMachine) directedGraph).mapEdgesInit(((StateMachine) directedGraph).getEdges());
    }

    @Override
    public void removeEdge(Edge edge) throws GraphException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeVertex(Vertex vertex) throws GraphException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MachineContract that = (MachineContract) o;
        return Objects.equals(directedGraph, that.directedGraph);
    }

    @Override
    public int hashCode() {
        return Objects.hash(directedGraph);
    }

    @Override
    public String toString() {
        return "MachineContract{" +
                "directedGraph=" + directedGraph +
                '}';
    }
}
