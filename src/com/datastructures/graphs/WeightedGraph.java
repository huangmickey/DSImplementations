package com.datastructures.graphs;

import java.util.*;

// Weighted Undirected Graph
public class WeightedGraph {

    private class Node {
        private String label;
        private List<Edge> edges = new ArrayList<>();

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return this.label;
        }

        public void addEdge(Node to, int weight) {
            edges.add(new Edge(this, to, weight));
        }

        public List<Edge> getEdges() {
            return edges;
        }
    }

    private class Edge {
        private Node from;
        private Node to;
        private int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from + "->" + to;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();

    public void addNode(String label) {
        nodes.putIfAbsent(label, new Node(label));
    }

    public void addEdge(String from, String to, int weight) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if (fromNode == null) throw new IllegalArgumentException("From node does not exist in graph");
        if (toNode == null) throw new IllegalArgumentException("To node does not exist in graph");
        fromNode.addEdge(toNode, weight);
        toNode.addEdge(fromNode, weight);
    }

    public void print() {
        for (Node node : nodes.values()) {
            List<Edge> edgeList = node.getEdges();
            if (!edgeList.isEmpty()) {
                System.out.println(node + " is connected to " + edgeList);
            }
        }
    }

    private class NodeEntry {
        private Node node;
        private int priority;

        public NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }
    }

    public Path getShortestPath(String from, String to) {
        Node fromNode = nodes.get(from);
        if (fromNode == null) throw new IllegalArgumentException();
        Node toNode = nodes.get(to);
        if (toNode == null) throw new IllegalArgumentException();

        Map<Node, Integer> distances = new HashMap<>();
        for (Node node : nodes.values()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.replace(fromNode, 0);

        Map<Node, Node> previousNodes = new HashMap<>();

        Set<Node> visited = new HashSet<>();

        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(
                Comparator.comparingInt(ne -> ne.priority));
        queue.add(new NodeEntry(fromNode, 0));

        while (!queue.isEmpty()) {
            Node curr = queue.remove().node;
            visited.add(curr);

            for (Edge edge : curr.getEdges()) {
                if (visited.contains(edge.to)) continue;

                int newDistance = distances.get(curr) + edge.weight;
                if (newDistance < distances.get(edge.to)) {
                    distances.put(edge.to, newDistance);
                    previousNodes.put(edge.to, curr);
                    queue.add(new NodeEntry(edge.to, newDistance));
                }
            }
        }

        return buildPath(previousNodes, toNode);
    }

    private Path buildPath(Map<Node, Node> previousNodes, Node toNode) {
        Stack<Node> stack = new Stack<>();
        stack.push(toNode);
        Node prev = previousNodes.get(toNode);
        while (prev != null) {
            stack.push(prev);
            prev = previousNodes.get(prev);
        }

        Path path = new Path();
        while (!stack.isEmpty()) {
            path.add(stack.pop().label);
        }

        return path;
    }

    public static void main(String[] args) {
        WeightedGraph weightedGraph = new WeightedGraph();
        weightedGraph.addNode("A");
        weightedGraph.addNode("B");
        weightedGraph.addNode("C");
        weightedGraph.addEdge("A", "B", 1);
        weightedGraph.addEdge("B", "C", 2);
        weightedGraph.addEdge("A", "C", 10);
        weightedGraph.print();
        System.out.println(weightedGraph.getShortestPath("A", "K"));
    }
}
