import java.util.*;

public class connectedComponents {

    static class Edge {
        int src, dest, wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) graph[i] = new ArrayList<>();

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5,1));
    } 

    public static void bfs(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) bfsUtil(graph, vis);
        }
    }

    public static void bfsUtil(ArrayList<Edge> graph[], boolean vis[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while(!q.isEmpty()) {
            int curr = q.remove();

            vis[curr] = true;
            System.out.print(curr + " ");

            for(int i=0; i<graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                q.add(e.dest);
            }
        }
    }

    public static void dfs(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            dfsUtil(graph, i, vis);
        }
    }

    public static void dfsUtil(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        vis[curr] = true;
        System.out.print(curr + " ");

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                dfsUtil(graph, e.dest, vis);
            }
        }
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        try {

            @SuppressWarnings("unchecked")
            ArrayList<Edge> graph[] = new ArrayList[7];
            createGraph(graph);

            dfs(graph);

        } finally {
            sc.close();
        }

    }
}