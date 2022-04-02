import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class connecting {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            boolean[][] adj = new boolean[n][n];
            for(int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken())-1;
                int b = Integer.parseInt(st.nextToken())-1;
                adj[a][b] = true;
                adj[b][a] = true;
            }
            PriorityQueue<QueueObject> queue = new PriorityQueue<>();
            queue.add(new QueueObject(0, 0, new boolean[n]));
            while(!queue.isEmpty()) {
                QueueObject cur = queue.poll();
                if(cur.visited[cur.cur]) continue;
                if(cur.cur == n - 1) {
                    bw.write(cur.cost + "\n"); break;
                }
                for(int k = 0; k < n; k++) {
                    cur.visited[cur.cur] = true;
                    if(adj[cur.cur][k])
                        queue.add(new QueueObject(cur.cost, k, cur.visited));
                    else
                        queue.add(new QueueObject(cur.cost + (k-cur.cur)*(k-cur.cur), k, cur.visited));
                }
            }
        }
        bw.flush(); 
    }
}
class QueueObject implements Comparable<QueueObject>{
    int cost;
    int cur;
    boolean[] visited;
    QueueObject (int _cost, int _cur, boolean[] _visited) {
        cost = _cost;
        cur = _cur;
        visited = _visited;
    }

    @Override
    public int compareTo(QueueObject ok) {
        return Integer.compare(cost, ok.cost);
    }
}
