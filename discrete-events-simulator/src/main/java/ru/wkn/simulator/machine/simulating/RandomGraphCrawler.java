package ru.wkn.simulator.machine.simulating;

import org.apache.commons.graph.DirectedGraph;
import org.apache.commons.graph.Edge;
import org.apache.commons.graph.Vertex;
import ru.wkn.entities.graph.Condition;
import ru.wkn.entities.graph.ConditionEdge;
import ru.wkn.entities.graph.StateMachine;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class RandomGraphCrawler extends GraphCrawler {

    private DirectedGraph directedGraph;
    private EventPerformer eventPerformer;

    public RandomGraphCrawler(DirectedGraph directedGraph, EventPerformer eventPerformer) {
        super(directedGraph, eventPerformer);
        this.directedGraph = directedGraph;
        this.eventPerformer = eventPerformer;
    }

    @Override
    public void run() {
        try {
            randomVertexCrawling(((StateMachine) directedGraph).getStartVertex());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void randomVertexCrawling(Vertex vertex) throws InterruptedException {
        eventPerformer.runProcess(vertex);
        Edge edge = getEdgeByCondition(vertex, getRandomCondition(vertex));
        if (edge != null) {
            randomVertexCrawling(((ConditionEdge) edge).getSecondVertex());
        }
    }

    private Condition getRandomCondition(Vertex vertex) {
        int quantityConditions = directedGraph.getEdges(vertex).size();
        if (quantityConditions != 0) {
            Condition currentCondition = null;
            while (currentCondition == null) {
                currentCondition = getRandomCondition(getConditionIterator(directedGraph.getEdges(vertex)));
            }
            return currentCondition;
        } else {
            return null;
        }
    }

    private Iterator<Condition> getConditionIterator(Set<ConditionEdge> conditionEdges) {
        Set<Condition> conditions = new HashSet<>();
        conditionEdges.forEach(conditionEdge -> conditions.add(conditionEdge.getCondition()));
        return conditions.iterator();
    }

    private Condition getRandomCondition(Iterator<Condition> vertexIterator) {
        double coefficient = new Random().nextDouble();
        Condition currentCondition = null;
        while (vertexIterator.hasNext() && currentCondition == null) {
            currentCondition = vertexIterator.next();
            if ((boolean) currentCondition.getFunction().apply(coefficient)) {
                break;
            }
        }
        return currentCondition;
    }

    private Edge getEdgeByCondition(Vertex vertex, Condition condition) {
        Set<Edge> edges = directedGraph.getEdges(vertex);
        for (Edge currentEdge : edges) {
            if (((ConditionEdge) currentEdge).getCondition().equals(condition)) {
                return currentEdge;
            }
        }
        return null;
    }
}
