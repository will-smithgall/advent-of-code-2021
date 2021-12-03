import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day3 {
    public static int powerConsumption(ArrayList<String> terms) {
        String gamma = "";
        String epsilon = "";

        for (int i = 0; i < terms.get(0).length(); i++) {
            int ones = 0;
            int zeros = 0;

            for (int j = 0; j < terms.size(); j++) {
                if (terms.get(j).charAt(i) == '1') {
                    ones++;
                } else {
                    zeros++;
                }
            }

            if (ones > zeros) {
                gamma = gamma + "1";
                epsilon = epsilon + "0";
            } else {
                gamma = gamma + "0";
                epsilon = epsilon + "1";
            }
        }
        return Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2);
    }

    public int lifeSupport(ArrayList<String> terms) {
        String oxygen = "";
        String carbon = "";
        ArrayList<String> termsCopy = new ArrayList<String>(terms);

        //Oxygen generator rating
        //TODO
        //  Figure this the fuck out

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("inputs/test.txt"));
        String line = br.readLine();
        ArrayList<String> terms = new ArrayList<String>();

        while (line != null) {
            terms.add(line);
            line = br.readLine();
        }

        int powerConsumption = powerConsumption(terms);
        System.out.println(powerConsumption);
    }
}
