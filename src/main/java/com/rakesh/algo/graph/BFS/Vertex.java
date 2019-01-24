package com.rakesh.algo.graph.BFS;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
	private int id;
	private boolean visited = false;
	private List<Vertex> edgeList;
	private Vertex prev;
	
	public Vertex(int id){
		this.id = id;
		this.edgeList = new ArrayList<Vertex>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public List<Vertex> getEdgeList() {
		return edgeList;
	}

	public void addNeighbour(Vertex neighbour){
		this.edgeList.add(neighbour);
	}
	
	public String toString(){
		return this.id+" ";
	}

	public Vertex getPrev() {
		return prev;
	}

	public void setPrev(Vertex prev) {
		this.prev = prev;
	}
}
