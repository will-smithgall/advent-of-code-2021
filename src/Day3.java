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

    public static int lifeSupport(ArrayList<String> terms) {
        //Help from reddit Python solution (part 2)
        ArrayList<String> termsCopy = new ArrayList<String>(terms);

        for (int i = 0; i < terms.get(0).length(); i++) {
            int zero = 0;
            int one = 0;
            char o2 = '0';
            char co2 = '0';

            for (int j = 0; j < terms.size(); j++) {
                if (terms.get(j).charAt(i) == '1') {
                    one++;
                } else {
                    zero++;
                }
            }

            if (zero > one) {
                o2 = '0';
            } else if (one > zero) {
                o2 = '1';
            } else {
                o2 = '1';
            }

            if (terms.size() > 1) {
                ArrayList<String> newTerms = new ArrayList<String>();

                for (int j = 0; j < terms.size(); j++) {
                    if (terms.get(j).charAt(i) == o2) {
                        newTerms.add(terms.get(j));
                    }
                }

                terms = newTerms;
            }

            zero = 0;
            one = 0;

            for (int j = 0; j < termsCopy.size(); j++) {
                if (termsCopy.get(j).charAt(i) == '1') {
                    one++;
                } else {
                    zero++;
                }
            }

            if (zero > one) {
                co2 = '1';
            } else if (one > zero) {
                co2 = '0';
            } else {
                co2 = '0';
            }

            if (termsCopy.size() > 1) {
                ArrayList<String> newTermsCO2 = new ArrayList<String>();

                for (int j = 0; j < termsCopy.size(); j++) {
                    if (termsCopy.get(j).charAt(i) == co2) {
                        newTermsCO2.add(termsCopy.get(j));
                    }
                }

                termsCopy = newTermsCO2;
            }
        }

        return Integer.parseInt(terms.get(0), 2) * Integer.parseInt(termsCopy.get(0), 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("inputs/day3.txt"));
        String line = br.readLine();
        ArrayList<String> terms = new ArrayList<String>();

        while (line != null) {
            terms.add(line);
            line = br.readLine();
        }

        int powerConsumption = powerConsumption(terms);
//        System.out.println(powerConsumption);

        int ls = lifeSupport(terms);
        System.out.println(ls);
        br.close();
    }
}
