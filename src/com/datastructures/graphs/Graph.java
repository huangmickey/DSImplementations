package com.datastructures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Directed Graphs Using Adjacency List
public class Graph {

    private class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return this.label;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        Node node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if (fromNode == null || toNode == null) throw new IllegalArgumentException("Node not valid");

        adjacencyList.get(fromNode).add(toNode);
    }

    public void removeNode(String label) {
        Node targetNode = nodes.get(label);
        if (targetNode == null) return;
        for (Node sourceNodes : adjacencyList.keySet()) {
            adjacencyList.get(sourceNodes).remove(targetNode);
        }
        adjacencyList.remove(targetNode);
        nodes.remove(label);
    }

    public void removeEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if (fromNode == null || toNode == null) return;
        adjacencyList.get(fromNode).remove(toNode);
    }

    public void print() {
        for (Node sourceNode : adjacencyList.keySet()) {
            List<Node> targetLists = adjacencyList.get(sourceNode);
            if (!targetLists.isEmpty()) {
                System.out.println(sourceNode + " is connected to " + targetLists);
            }
        }
    }


    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.removeNode("A");
        graph.addEdge("B", "A");
        graph.print();
    }

}
