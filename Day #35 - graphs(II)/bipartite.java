import java.util.*;

public class bipartite {

    static class Edge {
        int src; 
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) graph[i] = new ArrayList<>();

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 3));   //4

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));   //4

        // graph[4].add(new Edge(4, 2));
        // graph[4].add(new Edge(4, 3));
    } 

    public static boolean biPartite(ArrayList<Edge> graph[]) {
        int col[] = new int[graph.length];
        for(int i=0; i<col.length; i++) col[i] = -1;

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<graph.length; i++) {
            if(col[i] == -1) {
                col[i] = 0;
                q.add(i);

                while(!q.isEmpty()) {
                    int curr = q.remove();
                    for(int j=0; j<graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        
                        if(col[e.dest] == -1) {
                            int nextCol = col[curr] == 0 ? 1 : 0;
                            col[e.dest] = nextCol;
                            q.add(e.dest);
                        }
                        else if(col[e.dest] == col[curr]) return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        try {

            @SuppressWarnings("unchecked")
            ArrayList<Edge> graph[] = new ArrayList[7];
            createGraph(graph);
        
            System.out.print(biPartite(graph));
        
        } finally {
            sc.close();
        }

    }
}