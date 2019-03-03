package ru.wkn.entities.graph;

import org.apache.commons.graph.DirectedGraph;
import org.apache.commons.graph.Edge;
import org.apache.commons.graph.Vertex;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

public class StateMachine implements DirectedGraph {

    private Set<Vertex> vertices;
    private Set<Edge> edges;
    private Map<Vertex, Set<Edge>> vertexSetMap;
    private Vertex startVertex;

    public StateMachine() {
        this(new HashSet<>());
    }

    public StateMachine(Set<Edge> edges) {
        this(null, edges);
    }

    public StateMachine(Vertex startVertex, Set<Edge> edges) {
        vertices = extractVertices(edges);
        this.edges = edges;
        mapEdgesInit(edges);
        setStartVertex(startVertex != null ? startVertex : getRandomVertex());
    }

    private Set<Vertex> extractVertices(Set<Edge> edges) {
        Set<Vertex> vertices = new HashSet<>();
        for (Edge currentEdge : edges) {
            vertices.addAll(((ConditionEdge) currentEdge).getVertices());
        }
        return vertices;
    }

    public void mapEdgesInit(Set<Edge> edges) {
        vertexSetMap = new HashMap<>();
        for (Edge currentEdge : edges) {
            Vertex keyVertex = ((ConditionEdge) currentEdge).getFirstVertex();
            if (vertexSetMap.containsKey(keyVertex)) {
                vertexSetMap.get(keyVertex).add(currentEdge);
            } else {
                Set<Edge> currentEdges = new HashSet<>();
                currentEdges.add(currentEdge);
                vertexSetMap.put(keyVertex, currentEdges);
            }
        }
    }

    private Vertex getRandomVertex() {
        Random random = new Random();
        int size = vertices.size();
        if (size != 0) {
            int randomValue = random.nextInt() % vertices.size();
            int count = 0;
            for (Vertex vertex : vertices) {
                if (count == randomValue) {
                    return vertex;
                }
                count++;
            }
        }
        return null;
    }

    public Vertex getStartVertex() {
        return startVertex;
    }

    public void setStartVertex(Vertex startVertex) {
        this.startVertex = startVertex;
    }

    @Override
    public Set<Vertex> getVertices() {
        return vertices;
    }

    @Override
    public Set<Edge> getEdges() {
        return edges;
    }

    @Override
    public Set<Edge> getEdges(Vertex vertex) {
        return vertexSetMap.get(vertex);
    }

    @Override
    public Set<Vertex> getVertices(Edge edge) {
        return ((ConditionEdge) edge).getVertices();
    }

    @Override
    public Set getInbound(Vertex vertex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set getOutbound(Vertex vertex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Vertex getSource(Edge edge) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Vertex getTarget(Edge edge) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StateMachine that = (StateMachine) o;
        return Objects.equals(vertices, that.vertices) &&
                Objects.equals(edges, that.edges) &&
                Objects.equals(vertexSetMap, that.vertexSetMap) &&
                Objects.equals(startVertex, that.startVertex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertices, edges, vertexSetMap, startVertex);
    }

    @Override
    public String toString() {
        return "StateMachine{" +
                "vertices=" + vertices +
                ", edges=" + edges +
                ", vertexSetMap=" + vertexSetMap +
                ", startVertex=" + startVertex +
                '}';
    }
}
