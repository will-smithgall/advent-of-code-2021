import javax.sound.sampled.Line;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day6 {

    public static int numFishPartOne(ArrayList<Integer> fish) {
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

        return fish.size();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("inputs/day6.txt"));
        ArrayList<Integer> fishPartOne = new ArrayList<Integer>();

        String[] line = br.readLine().split(",");

        for (int i = 0; i < line.length; i++) {
            fishPartOne.add(Integer.parseInt(line[i]));
        }

        //int doesn't have enough storage
        long[] fish = new long[10];
        long totalFish = 0;

        for (String s : line) {
            fish[Integer.parseInt(s)]++;
        }

        for (int i = 0; i < 256; i++) {
            //number of fish restarting their cycle (day 6) is the number of fish at 0 from the previous day
            fish[7] += fish[0];

            //number of fish creating new fish (day 8 fish) is the number of fish at 0 from previous day
            fish[9] = fish[0];

            for (int j = 0; j < 9; j++) {
                //increment day 0 fish amount by day 1 fish amount
                fish[j] = fish[j+1];
            }

            //reset day 8
            fish[9] = 0;
        }

        for (int i = 0; i < fish.length; i++) {
            totalFish += fish[i];
        }

//        System.out.println(numFishPartOne(fishPartOne));
        System.out.println(totalFish);
    }
}
