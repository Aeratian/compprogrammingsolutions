import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class intervals {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int intervals[][] = new int[n][2];
        int ans[] = new int [2*m + 2];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            intervals[i][0] = Integer.parseInt(st.nextToken());
            intervals[i][1] = Integer.parseInt(st.nextToken());
        }
        int pref[] = new int[2*m + 1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                    pref[intervals[i][0] + intervals[j][0]]++;
                    if(intervals[i][1] + intervals[j][1] + 1 <= 2 * m)
                    pref[intervals[i][1] + intervals[j][1] + 1]--;
            }
        }
        for(int i = 1; i <= 2 * m + 1; i++) {
            ans[i] = pref[i - 1] + ans [i - 1];
            bw.write(ans[i] + "\n");
        }
        bw.flush();
    }
}