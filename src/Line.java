public class Line {
    //Line 的位置坐标
    private double xPosition;
    private double yPosition;
    //Line 的向量值
    private double xVector;
    private double yVector;

    //默认构造函数
    private Line() {
        xPosition = 0;
        yPosition = 0;

        xVector = 0;
        yVector = 0;
    }

    //提供两点的构造函数
    private Line(Point p1, Point p2) {
        if (p1.coincide(p2)) {
            System.out.println("The two points coincide, create Line is null!");

            xPosition = 0;
            yPosition = 0;

            xVector = 0;
            yVector = 0;
        } else {
            xPosition = p1.getX();
            yPosition = p1.getY();

            xVector = p2.getX() - p1.getX();
            yVector = p2.getY() - p1.getY();
        }
    }

    //点+向量的构造函数
    private Line(double xP, double yP, double xV, double yV) {
        xPosition = xP;
        yPosition = yP;
        xVector = xV;
        yVector = yV;
    }

    //变量接口
    private double getxPosition() {
        return xPosition;
    }
    private void setxPosition(double xPosition) {
        this.xPosition = xPosition;
    }

    private double getyPosition() {
        return yPosition;
    }
    private void setyPosition(double yPosition) {
        this.yPosition = yPosition;
    }

    private double getxVector() {
        return xVector;
    }
    private void setxVector(double xVector) {
        this.xVector = xVector;
    }

    private double getyVector() {
        return yVector;
    }
    private void setyVector(double yVector) {
        this.yVector = yVector;
    }


    //检查非空
    private boolean checkNotNull() {
        return !(getxPosition() == 0) || !(getyPosition() == 0) || !(getxVector() == 0) || !(getyVector() == 0);
    }

    //更换值
    private void changeLine(Point p1, Point p2) {
        setxPosition(p1.getX());
        setyPosition(p1.getY());

        setxVector(p2.getX() - p1.getX());
        setyVector(p2.getY() - p1.getY());
    }

    //Vector Plus


    //展示
    private void show() {
        if (checkNotNull()) {
            System.out.println("This line is from ( " + getxPosition() + ", " + getyPosition() + " ), vector is ( " + getxVector() + ", " + getyVector() + " ).");
        } else {
            System.out.println("This line is null!");
        }
    }


    //判断平行
    private boolean judgeParallel(Line line) {
        if (checkNotNull() && line.checkNotNull()) {
            return getxVector() * line.getyVector() == getyVector() * line.getxVector();
        }
        System.out.println("Null line has existed, no way to judge parallel.");
        return false;
    }

    public static void main(String[] args) {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(5, 7);
        Point p3 = new Point(5, 7);
        Point p4 = new Point(6, 8);

        Line l1 = new Line();
        Line l2 = new Line(p1, p2);
        Line l3 = new Line(p2, p3);
        Line l4 = new Line(1.0, 1.0, 4.0, 4.0);

        l1.show();
        l2.show();
        l3.show();
        l4.show();


        l3.changeLine(p2, p4);

        l3.show();

        if (l3.judgeParallel(l4)) {
            System.out.println("l3 parallel to l4.");
        }
    }
}
