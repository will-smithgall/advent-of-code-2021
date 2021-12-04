import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day1 {

    public static ArrayList<Integer> sumByThree(ArrayList<Integer> ints) {
        ArrayList<Integer> threes = new ArrayList<Integer>();

        for (int i = 2; i < ints.size(); i++) {
            threes.add(ints.get(i - 2) + ints.get(i - 1) + ints.get(i));
        }

        return threes;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("inputs/input_day_one.txt"));
        ArrayList<Integer> ints = new ArrayList<Integer>();
        int counter = 0;

        String line = br.readLine();
        while (line != null) {
            ints.add(Integer.parseInt(line));
            line = br.readLine();
        }

        for (int i = 1; i < ints.size(); i++) {
            if (ints.get(i) > ints.get(i - 1)) {
                counter++;
            }
        }

        ArrayList<Integer> threes = sumByThree(ints);
        int counterTwo = 0;

        for (int i = 1; i < threes.size(); i++) {
            if (threes.get(i) > threes.get(i - 1)) {
                counterTwo++;
            }
        }

        System.out.println(counterTwo);
        br.close();
    }
}
