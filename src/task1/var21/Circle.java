package task1.var21;

public class Circle {
    private final Point center;
    private final double r;

    //конструктор через координаты центра и радиус
    public Circle(int x, int y, double r) {
        this.center = new Point(x, y);
        this.r = r;
    }
    //конструктор через точки
    public Circle(Point center, Point point) {
        this.center = center;
        this.r = Point.distance(center, point);
    }

    //площадь
    public double square() {
        return Math.PI*r*r;
    }

    //периметр
    public double perimeter() {
        return 2*Math.PI*r;
    }

    //Принадледит ли точка окружности
    public boolean contains(Point point) {
        int x = point.getX();
        int y = point.getY();
        return x*x + y*y <= r*r;
    }

    //переопределяем метод для печати информации об окружности
    @Override
    public String toString() {
        return "Окружность радиусом " + r + " c центром в точке (" + center.getX() + "," + center.getY()+")";
    }
}
