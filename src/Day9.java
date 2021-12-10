import javax.sound.sampled.Line;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day9 {
    public static void main(String[] args) throws IOException {
        ArrayList<String[]> heats = new ArrayList<String[]>();
        BufferedReader br = new BufferedReader(new FileReader("inputs/day9.txt"));
        String line = br.readLine();

        while (line != null) {
            String[] lineNums = line.split("");
            heats.add(lineNums);

            line = br.readLine();
        }

        int sumOfRisk = 0;

        for (int i = 0; i < heats.size(); i++) {
            for (int j = 0; j < heats.get(0).length; j++) {
                int left;
                int right;
                int up;
                int down;
                int current = Integer.parseInt(heats.get(i)[j]);

                try {
                    left = Integer.parseInt(heats.get(i)[j - 1]);
                } catch (IndexOutOfBoundsException e) {
                    left = 10;
                }

                try {
                    right = Integer.parseInt(heats.get(i)[j + 1]);
                } catch (IndexOutOfBoundsException e) {
                    right = 10;
                }

                try {
                    up = Integer.parseInt(heats.get(i - 1)[j]);
                } catch (IndexOutOfBoundsException e) {
                    up = 10;
                }

                try {
                    down = Integer.parseInt(heats.get(i + 1)[j]);
                } catch (IndexOutOfBoundsException e) {
                    down = 10;
                }

                //Corner or edge cases
                if (current < up && current < down && current < right && current < left) {
                    sumOfRisk += current + 1;
                }
            }
        }

        System.out.println(sumOfRisk);
    }
}
