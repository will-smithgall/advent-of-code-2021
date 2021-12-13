import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day13 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("inputs/day13.txt"));
        String line = br.readLine();
        ArrayList<Point> points = new ArrayList<Point>();
        ArrayList<String> instructions = new ArrayList<String>();

        while (line != null) {
            try {
                String[] linePart = line.split(",");
                    points.add(new Point(Double.parseDouble(linePart[0]), Double.parseDouble(linePart[1])));
            } catch (Exception e){
                if (line.equals("")) {
                    continue;
                } else {
                    String[] inst = line.split(" ");
                    instructions.add(inst[2]);
                }
            } finally {
                line = br.readLine();
            }
        }

        for (int i = 0; i < 1; i++) {
            ArrayList<Point> newPoints = new ArrayList<Point>();
            String inst = instructions.get(i);
            double num = Double.parseDouble(inst.substring(2));
            if (inst.charAt(0) == 'y') {
                for (int j = 0; j < points.size(); j++) {
                    if (points.get(j).getY() > num) {
                        Point newPoint = new Point(points.get(j).getX(), num - points.get(j).distanceY(num));

                        if (!newPoints.contains(newPoint)) {
                            newPoints.add(newPoint);
                        }
                    } else if (points.get(j).getY() < num) {
                        if (!newPoints.contains(points.get(j))) {
                            newPoints.add(points.get(j));
                        }
                    }
                }
            } else {
                for (int j = 0; j < points.size(); j++) {
                    if (points.get(j).getX() > num) {
                        Point newPoint = new Point(Math.abs(num - points.get(j).distanceX(num)), points.get(j).getY());
                        if (!newPoints.contains(newPoints)) {
                            newPoints.add(newPoint);
                        }
                    } else if (points.get(j).getX() < num) {
                        if (!newPoints.contains(points.get(j))) {
                            newPoints.add(points.get(j));
                        }
                    }
                }
            }
            points = newPoints;
        }

        System.out.println(points.size());
    }
}
