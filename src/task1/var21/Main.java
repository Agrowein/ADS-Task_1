package task1.var21;

public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(5, 5);
        Point p2 = new Point(100, 100);

        Circle c1 = new Circle(10, 1, 15);
        System.out.println(c1);
        System.out.println(c1 + "содержит точку " + p1 + "? - " + c1.contains(p1));
        System.out.println(c1 + "содержит точку " + p2 + "? - " + c1.contains(p2));


        Circle c2 = new Circle(new Point(0, 0), new Point(20, 0));
        System.out.println(c2);
        System.out.println(c2.contains(p1));
    }
}