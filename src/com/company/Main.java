package com.company;

public class Main {

    public static void main(String[] args) {
        EdgeListGraph<String> grap = new EdgeListGraph();

//        grap.addVertex("Mona");
//        grap.addVertex("Mohan");
//        grap.addEdge("Mona","Mohan");
//        grap.showRelation();
        AdjancyGraph<String> graph = new AdjancyGraph<String>();
        graph.addVertex("Mona");
        graph.addVertex("Mohan");
        graph.addVertex("Shubham");
        graph.addVertex("Shobit");
        graph.addEdge("Mohan","Shobit");
        graph.addEdge("Mona","Shubham");
        graph.addEdge("Shobit","Shubham");
        graph.showRelation();
    }
}
