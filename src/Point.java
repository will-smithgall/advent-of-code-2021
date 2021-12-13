public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //Getters / Setters

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distanceX(double x) {
        return Math.abs(this.x - x);
    }

    public double distanceY(double y) {
        return Math.abs(this.y - y);
    }

    @Override
    public boolean equals(Object obj) {
        Point point = (Point) obj;

        return (this.x == point.getX() && this.y == point.getY());
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
