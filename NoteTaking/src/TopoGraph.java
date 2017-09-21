import java.util.*;

//Class to represent a graph, print topological sort
public class TopoGraph
{
    int V;

    List <Integer> adj[];
    public TopoGraph(int V)// Constructor
    {
        this.V = V;
        adj = new ArrayList[V];
        for(int i = 0; i < V; i++)
            adj[i]=new ArrayList<Integer>();
    }

    public void addEdge(int u,int v)
    {
        adj[u].add(v);
    }
    public void topologicalSort()
    {

        int indegree[] = new int[V];

        for(int i = 0; i < V; i++)
        {
            ArrayList<Integer> temp = (ArrayList<Integer>) adj[i];
            for(int node : temp)
            {
                indegree[node]++;
            }
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0;i < V; i++)
        {
            if(indegree[i]==0)
                q.add(i);
        }

        int cnt = 0;

        Vector <Integer> topOrder=new Vector<Integer>();
        while(!q.isEmpty())
        {
            int u=q.poll();
            topOrder.add(u);

            for(int node : adj[u])
            {
                // If in-degree becomes zero, add it to queue
                if(--indegree[node] == 0)
                    q.add(node);
            }
            cnt++;
        }

        // Check if there was a cycle
        if(cnt != V)
        {
            System.out.println("There exists a cycle in the graph");
            return ;
        }

        // Print topological order
        for(int i : topOrder)
        {
            System.out.print(i+" ");
        }
    }

    public static void test()
    {
        Note note = new Note();
        // Create a graph given in the above diagram
        TopoGraph g=new TopoGraph(note.filesForRead.size());
        for (int i=0;i<note.filesForRead.size(); i++){
                int in = note.getInDegree();
                int out = note.getOutDegree();
                g.addEdge(in, out);
        }


        System.out.println("Topological Sort of Files by ReferencesC:\\Users\\Eva\\IdeaProjects\\330Assignment1\\Too-Many-Cats");
        g.topologicalSort();

    }
}