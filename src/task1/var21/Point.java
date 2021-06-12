package task1.var21;

public class Point {
    private final int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //геттеры для x и y
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //статический метод для получения расстояния между 2-мя точками
    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
    }

    @Override
    public String toString() {
        return "("+x+","+y+")";
    }
}
