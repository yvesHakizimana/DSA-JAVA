package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
     private class Node{
        private String label;

        public Node(String label){
            this.label = label;
        }

         @Override
         public String toString() {
             return label;
         }
     }

     //HashMap Implementation.
    private Map<String, Node> nodesMap = new HashMap();

    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label){
        //Making the new Node
        var newNode = new Node(label);
        nodesMap.putIfAbsent(label, newNode);
        adjacencyList.putIfAbsent(newNode, new ArrayList<>());
    }

    public void addEdge(String fromLabel, String toLabel){
        //If it for the directed graph.
        var fromNode = nodesMap.get(fromLabel);
        if(fromNode == null)
            throw  new IllegalArgumentException("The fromNode is null");

        var toNode = nodesMap.get(toLabel);
        if(toNode == null)
            throw  new IllegalArgumentException("The toNode is null");

        adjacencyList.get(fromNode).add(toNode);
        //Unless if it undirected graph
//        adjacencyList.get(fromNode).add(toNode);
//        adjacencyList.get(toNode).add(fromNode);
    }

    public void removeNode(String label){
        //Algorithm of removing a Node
        var node = nodesMap.get(label);
        if(node == null)
            return;
        for(var n : adjacencyList.keySet()){
            adjacencyList.get(n).remove(node);
        }
        adjacencyList.remove(node);
        nodesMap.remove(label);
    }
    public void removeEdge(String from, String to){
        var fromNode = nodesMap.get(from);
        var toNode = nodesMap.get(to);
        if(fromNode == null || toNode == null)
            return;
        //Because it directed.
        adjacencyList.get(fromNode).remove(toNode);
    }
    public void print(){
        for( var source : adjacencyList.keySet()){
            var targets = adjacencyList.get(source);
            if(!targets.isEmpty()){
                System.out.println(source + " is connected to " + targets);
            }
        }
    }

}
