import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class operations {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int q = Integer.parseInt(br.readLine());
        int n = str.length();
        int pref[][] = new int [n+1][3];
        for(int i = 0; i < n; i++) {
            pref[i+1][0] = pref[i][0];
            pref[i+1][1] = pref[i][1];
            pref[i+1][2] = pref[i][2];
            if(str.charAt(i) == 'C') {
                pref[i+1][0]++;
            }
            if(str.charAt(i) == 'O') {
                pref[i+1][1]++;
            }
            if(str.charAt(i) == 'W') {
                pref[i+1][2]++;
            }
        }
        for(int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = pref[b][0] - pref[a-1][0];
            int o = pref[b][1] - pref[a-1][1];
            int w = pref[b][2] - pref[a-1][2];
            if((o-w)%2==0 && (Math.min(o, w)+c)%2==1) {
                bw.write("Y");
            }
            else 
                bw.write("N");
        }
        bw.write("\n");
        bw.flush();
    }

}
