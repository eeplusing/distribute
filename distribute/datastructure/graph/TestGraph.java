 
package graph;  
public class TestGraph {
	public static void main(String[] args){
		Graph g = new Graph(30);
		g.addVertex('A');
		g.addVertex('B');
		g.addVertex('C');
		
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
	}
}
  
