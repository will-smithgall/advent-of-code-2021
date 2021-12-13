import javax.sound.sampled.Line;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("inputs/day6.txt"));
        ArrayList<Integer> fish = new ArrayList<Integer>();

        String[] line = br.readLine().split(",");

        for (int i = 0; i < line.length; i++) {
            fish.add(Integer.parseInt(line[i]));
        }

        for (int i = 0; i < 80; i++) {
            ArrayList<Integer> newDay = new ArrayList<Integer>(fish);
            int count = 0;
            for (int j = 0; j < fish.size(); j++) {
                if (fish.get(j) == 0) {
                    count++;
                    newDay.set(j, 6);
                } else {
                    newDay.set(j, fish.get(j) - 1);
                }
            }

            for (int j = 0; j < count; j++) {
                newDay.add(8);
            }

            fish = newDay;
        }

        System.out.println(fish.size());
    }
}
