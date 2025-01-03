import java.util.*;
public class graph1{
    static class edge{
        int src;
        int dest;
        int wt;
        public edge(int src, int dest, int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }
     public static void createGraph(int flights[][],ArrayList<edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<flights.length;i++){
            int src=flights[i][0];
            int dest=flights[i][1];
            int wt=flights[i][2];
            edge e= new edge(src, dest, wt);
            graph[src].add(e);
        }
     }


    public static void main(String[] args) {s
        int n=4;
        int flights[][]={{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src=0,dest=3,k=1;
        ArrayList<edge> graph[]=new ArrayList[n]; 
        createGraph(flights, graph);
    }
}