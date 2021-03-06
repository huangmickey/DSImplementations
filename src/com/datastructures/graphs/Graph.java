package com.datastructures.graphs;

import java.util.*;

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

    public void traverseDepthFirst(String root) {
        Node node = nodes.get(root);
        if (node == null) return;
        traverseDepthFirst(nodes.get(root), new HashSet<>());
    }

    private void traverseDepthFirst(Node root, Set<Node> visited) {
        System.out.println(root);
        visited.add(root);
        for (Node node : adjacencyList.get(root)) {
            if (!visited.contains(node)) {
                traverseDepthFirst(node, visited);
            }
        }
    }

    public void traverseDepthFirstIterative(String root) {
        // validate that graph has the target root
        Node node = nodes.get(root);
        if (node == null) return;

        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();

        // push(root)
        stack.push(node);
        // while(stack is not empty)
        while (!stack.isEmpty()) {
            //  current = pop()
            Node current = stack.pop();
            //  visit(current)
            if (visited.contains(current)) continue;
            System.out.println(current);
            visited.add(current);
            //  push each unvisited neighbor onto stack
            for (Node linkedNode : adjacencyList.get(current)) {
                if (!visited.contains(linkedNode)) {
                    stack.push(linkedNode);
                }
            }
        }
    }

    public void traverseBreadthFirstIterative(String root) {
       Node node = nodes.get(root);
       if (node == null) return;

       Queue<Node> queue = new ArrayDeque<>();
       Set<Node> visited = new HashSet<>();
       queue.add(node);
       while (!queue.isEmpty()) {
           Node current = queue.remove();

           if (visited.contains(current)) continue;

           System.out.println(current);
           visited.add(current);

           for (Node neighbour : adjacencyList.get(current)) {
               if (!visited.contains(neighbour)) {
                   queue.add(neighbour);
               }
           }
       }
    }

    public List<String> topologicalSort() {
        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();

        for (Node node : nodes.values()) {
            topologicalSort(node, visited, stack);
        }

        List<String> sorted = new ArrayList<>();
        while (!stack.isEmpty()) {
            sorted.add(stack.pop().label);
        }

        return sorted;
    }

    private void topologicalSort(Node node, Set<Node> visited, Stack<Node> stack) {
        if (visited.contains(node)) return;

        visited.add(node);

        for (Node neighbour : adjacencyList.get(node)) {
            topologicalSort(neighbour, visited, stack);
        }

        stack.push(node);
    }

    public boolean hasCycle() {
        Set<Node> all = new HashSet<>(nodes.values());

        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();

        while (!all.isEmpty()) {
            Node current = all.iterator().next();
            if (hasCycle(current, all, visiting, visited)) return true;
        }

        return false;
    }

    private boolean hasCycle(Node node, Set<Node> all, Set<Node> visiting, Set<Node> visited) {
        all.remove(node);
        visiting.add(node);

        for (Node neighbour : adjacencyList.get(node)) {
            if (visited.contains(neighbour)) continue;

            if (visiting.contains(neighbour)) return true;

            if (hasCycle(neighbour, all, visiting, visited)) {
                return true;
            }
        }

        visiting.remove(node);
        visited.add(node);

        return false;
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
        graph.addEdge("B", "C");
        graph.addEdge("C", "A");

        graph.print();
        System.out.println(graph.hasCycle());
    }
}
