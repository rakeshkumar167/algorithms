package com.rakesh.algo.graph.BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

	public List<Vertex> doBFS(Vertex start, Vertex end) {
		List<Vertex> path = new ArrayList<Vertex>();
		Queue<Vertex> queue = new LinkedList<Vertex>();
		queue.add(start);

		while (!queue.isEmpty()) {
			Vertex current = queue.remove();
			current.setVisited(true);
			if (current.getId() == end.getId()) {
				path = getPath(current);
				return path;
			}
			for (Vertex neighbour : current.getEdgeList()) {
				if (neighbour.isVisited()) {
					continue;
				}
				neighbour.setPrev(current);
				queue.add(neighbour);
			}
		}
		return path;
	}

	private List<Vertex> getPath(Vertex current) {
		List<Vertex> path = new ArrayList<Vertex>();
		do {
			path.add(current);
			current = current.getPrev();
		} while (current != null);
		Collections.reverse(path);
		return path;
	}
}
