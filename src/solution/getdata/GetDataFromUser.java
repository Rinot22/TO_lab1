package solution.getdata;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GetDataFromUser {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public String inputCode() {
        try {
            return br.readLine();
        } catch (Exception e) {
            System.err.println(e);
        }

        return null;
    }

    public float inputQuote() {
        try {
            return Float.parseFloat(br.readLine());
        } catch (Exception e) {
            System.err.println(e);
        }

        return 0;
    }

    public int inputOption() {
        try {
            return Integer.parseInt(br.readLine());
        } catch (Exception e) {
            System.err.println(e);
        }

        return 0;
    }
}
