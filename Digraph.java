import java.util.*;

public class Digraph {
	private final int V;
	private final Bag<Integer>[] adj;

	public Digraph(int V) {
		this.V = V;
		adj = (Bag<Integer>[]) new Bag[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new Bag<Integer>();
		}
	}
	public boolean addEdge(int v, int w) {
		if (v >= this.V || w >= this.V || v < 0 || w < 0) {
			return false;
		}
			adj[v].add(w);
			return true;		
	}
	public int V() {
		return V;
	}
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
}