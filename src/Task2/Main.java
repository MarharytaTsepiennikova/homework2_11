/**
 * HTTP ответ
 */

package Task2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://butlers-online.com.ua");
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(http.getInputStream()));
            char[] buf = new char[1000];
            StringBuilder sb = new StringBuilder();
            int r;

            do {
                if((r = bf.read(buf)) > 0){
                    sb.append(new String(buf, 0 , r));
                }
            } while (r > 0);

            System.out.println(sb.toString());

        } finally {
            http.disconnect();
        }
    }
}
