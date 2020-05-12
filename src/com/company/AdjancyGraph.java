package com.company;
import java.util.LinkedList;

public class AdjancyGraph <T> {
    private LinkedList<Vertex> vertices;

    public AdjancyGraph() {
        this.vertices = new LinkedList();
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
    
    public void showRelation(){
        for (Vertex vertex : vertices) {
            for (Vertex padosi: vertex.nbrs) {
                System.out.println(vertex.value+" -> "+padosi.value);
            }
        }
    }

    public void addEdge(T start,T end){
        Vertex s = get(start);
        Vertex e = get(end);
        if(s != null && e != null) {
            s.nbrs.add(e);
        }
    }

    private class Vertex {
        private T value;
        private LinkedList<Vertex> nbrs;
        public Vertex(T value) {
            this.value = value;
            nbrs = new LinkedList<Vertex>();
        }
    }

}
