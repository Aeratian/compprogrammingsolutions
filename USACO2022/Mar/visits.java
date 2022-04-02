import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class visits {
    public static void dfs(ArrayList<Integer> list, int start, int cur, int id, int component[], int data[], boolean visited[]) {
        if(!visited[cur]) {
            component[cur] = id;
            list.add(cur);
            visited[cur] = true;
            dfs(list, start, data[cur], id, component, data, visited);
        }
        else {
            int count;
            if(component[cur] != component[start]) {
                count = list.size();
            }
            else {
                count = list.indexOf(cur);
            }
            for(int i = 0; i < count; i++) {
                component[list.get(i)] = -1;
            }
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int adj[] = new int[n];
        long data[] = new long[n];
        int component[] = new int[n];
        boolean visited[] = new boolean[n];
        long min[] = new long [n];
        Arrays.fill(min, -1);
        long ans = 0;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            long b = Long.parseLong(st.nextToken());
            ans += b;
            adj[i] = a;
            data[i] = b;
        }
        int id = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(new ArrayList<Integer>(), i, i, id, component, adj, visited);
                id++;
            }
        }
        for(int i = 0; i < n; i++) {
            if(component[i] != -1) {
                if(min[component[i]] == -1)
                    min[component[i]] = data[i];
                else
                    min[component[i]] = Math.min(min[component[i]], data[i]);
            }
        }
        for(int i = 0; i < n; i++) {
            if(min[i] != -1)
                ans -= min[i];
            else
                break;
        }
        bw.write(ans+"\n");
        bw.flush();
    }
}