package com.company;


import java.util.LinkedList;

public class EdgeListGraph<T> {
    private LinkedList<Vertex> vertices;
    private LinkedList<Edge> edges;

    public EdgeListGraph() {
        this.vertices = new LinkedList();
        this.edges = new LinkedList();
    }

    public void addVertex(T value){
        this.vertices.add(new Vertex(value));
    }
    
    private Vertex get(T value){
        for (Vertex vertex: this.vertices) {
            if(vertex.value.equals(value)){
                return vertex;
            }
        }
        return null;
    }

    public void addEdge(T start,T end){
        Vertex s = get(start);
        Vertex e = get(end);
        if(s != null && e != null) {
            this.edges.add(new Edge(s, e));
        }
    }
    public void showRelation(){
        for (Edge edge: edges) {
            System.out.println(edge.start.value+"->"+edge.end.value);
        }
    }
    private class Edge {
        private Vertex start;
        private Vertex end;

        public Edge(Vertex start, Vertex end) {
            this.start = start;
            this.end = end;
        }
    }

    private class Vertex {
        private T value;

        public Vertex(T value) {
            this.value = value;
        }
    }

}
