class Point {
    private double x;
    private double y;


    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }


    boolean coincide(Point p) {
        return x == p.x && y == p.y;
    }


    double getX() {
        return x;
    }
    double getY() {
        return y;
    }
}
