import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class subset1 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        HashSet<Integer> large = new HashSet<>();
        int onecount[] = new int[18];
        for(int i = 0; i < s.length(); i++) {
            onecount[s.charAt(i) - 'a']++;
        }

        String t = br.readLine();
        int twocount[] = new int[18];
        for(int i = 0; i < t.length(); i++) {
            twocount[t.charAt(i) - 'a']++;
        }

        int q = Integer.parseInt(br.readLine());
        String queries[] = new String [q];
        for(int i = 0; i < q; i++) {
            String str = br.readLine();
            queries[i] = str;
        }
        boolean works[] = new boolean [q];
        boolean bool = false;
        for(int i = q-1; i >= 0; i--) {
            bool = false;
            for(int num: large) {
                if(Integer.toString(num, 2).length() <= queries[i].length()) {
                    break;
                }
                if(isSubset(hash(queries[i]), num)) {
                    works[i] = true;
                    large.add(hash(queries[i]));
                    bool = true;
                    break;
                }
            }
            if(bool) {
                continue;
            }
            String s_ = s.replaceAll("[^"+queries[i]+"]", "");
            String t_ = t.replaceAll("[^"+queries[i]+"]", "");
            if(s_.equals(t_)) {
                works[i] = true;
                large.add(hash(queries[i]));
            }
            else {
                works[i] = false;
            }
        }
        for(int i = 0; i < q; i++) {
            if(works[i]) {
                bw.write("Y");
            }
            else {
                bw.write("N");
            }
        }
        bw.write("\n");
        bw.flush();
    }
    public static int hash(String set) {
        String has = "";
        int count = 0;
        for(char c = 'a'; c <= 'r'; c++) {
            if(count >= set.length()) {
                has+="0";
            }
            else if(set.charAt(count) == c) {
                has+="1";
                count++;
            }
            else {
                has+="0";
            }
        }
        return Integer.parseInt(has, 2);
    }
    public static boolean isSubset(int hash1, int hash2) {
        if(hash1 > hash2) {
            return ((hash1-hash2)&(hash2)) == 0;
        }
        else if(hash2 > hash1) {
            return ((hash2-hash1)&(hash1)) == 0;
        }
        return true;
    }
}
