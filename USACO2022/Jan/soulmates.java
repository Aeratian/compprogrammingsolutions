import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class soulmates {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == b) {
                bw.write("0\n");
                continue;
            }
            if(a > b) {
                int count = 0;
                while(a != b) {
                    if(a > b) {
                        if(a % 2 == 0) {
                            a/=2;
                        }
                        else {
                            a++;
                            a/=2; count++;
                        }
                    }
                    else {
                        count += b - a - 1;
                        b = a;
                    }
                    count++;
                }
                bw.write(count + "\n");
            }
            else {
                int count = 0;
                while(a != b) {
                    if(a < b) {
                        if(b % 2 == 0) {
                            b/=2;
                        }
                        else {
                            b--;
                        }
                    }
                    else {
                        b *= 2;
                        count += b - a - 2;
                        b = a;
                    }
                    count++;
                }
                bw.write(count + "\n");
            }
        }
        bw.flush();
    }
}