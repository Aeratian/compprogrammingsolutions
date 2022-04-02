import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.regex.Pattern;

public class subset {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String t = br.readLine();
        HashMap<String, Boolean> works = new HashMap<>();
        int q = Integer.parseInt(br.readLine());
        for(int i = 0; i < q; i++) {
            String str = br.readLine();
            Pattern p = Pattern.compile("[^"+str+"]");
            String s_ = p.matcher(s).replaceAll("");
            String t_ = p.matcher(t).replaceAll("");
            if(s_.equals(t_)) {
                bw.write("Y");
                works.put(str, true);
            }
            else
                bw.write("N");
                works.put(str, false);
        }
        bw.write("\n");
        bw.flush();
    }
}
