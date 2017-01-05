import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Chapter4Trees {
	// 4.1 Route between nodes : given a directed graph , design an algorithm to find out whether 
	//the is a root between two nodes : 
	public static class DiGraph<T>{
		HashMap<T,List<T>> map = new HashMap<T,List<T>>(); 
	
		public void addVertex(T vertex){
			if (map.containsKey(vertex)){
				return ;
			}
			map.put(vertex, new ArrayList());
		}
		 /**
	     * String representation of graph.
	     */
	    public String toString () {
	        StringBuffer s = new StringBuffer();
	        for (T v: map.keySet()) s.append("\n    " + v + " -> " + map.get(v));
	        return s.toString();                
	    }
	    /**
	     * Add an edge to the graph; if either vertex does not exist, it's added.
	     * This implementation allows the creation of multi-edges and self-loops.
	     */
	    public void add (T from, T to) {
	        this.addVertex(from); this.addVertex(to);
	        map.get(from).add(to);
	    }
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			DiGraph<Integer> graph = new DiGraph<Integer>();
	        graph.add(0, 1); graph.add(0, 2); graph.add(0, 3);
	        graph.add(1, 2); graph.add(1, 3); graph.add(2, 3);
	        graph.add(2, 4); graph.add(4, 5); graph.add(5, 6);    // Tetrahedron with tail
	        System.out.println("The current graph: " + graph);
	}

}
