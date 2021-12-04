import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Day2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("inputs/day2.txt"));
        String line = br.readLine();

        int horizontal = 0;
        int depth = 0;
        int aim = 0;

        while (line != null) {
            String[] terms = line.split(" ");

            if (terms[0].equals("forward")) {
                horizontal = horizontal + Integer.parseInt(terms[1]);
                depth = depth + (aim * Integer.parseInt(terms[1]));
            } else if (terms[0].equals("down")) {
                // depth = depth + Integer.parseInt(terms[1]);
                aim = aim + Integer.parseInt(terms[1]);
            } else {
                // depth = depth - Integer.parseInt(terms[1]);
                aim = aim - Integer.parseInt(terms[1]);
            }

            line = br.readLine();
        }

        System.out.println(horizontal * depth);
        br.close();

    }
}
