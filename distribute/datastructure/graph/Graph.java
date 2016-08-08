 
package graph;  
public class Graph {
	//顶点数组
	private Vertex[] vertexList;
	//邻接矩阵
	private int[][] adjMat;
	//顶点的最大数目
	private int maxSize;
	//当前顶点
	private int nVertext;
	
	public Graph(int maxSize){
		vertexList = new Vertex[maxSize];
		adjMat = new int[maxSize][maxSize];
		for(int i = 0; i < maxSize; i++){
			for(int j = 0; j < maxSize; j++){
				adjMat[i][j] = 0;
			}
		}
		nVertext = 0;
	}
	
	public void addVertex(char label){
		vertexList[nVertext++] = new Vertex(label); 
	}
	
	public void addEdge(int start, int end){
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	
}
  
