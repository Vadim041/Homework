package task_2;

public interface Calculatable {

    default double circlePerimeter(double radius) {
        return 2 * Math.PI * radius;
    }

    default double rectanglePerimeter(double x, double y) {
        return 2 * (x + y);
    }

    default double trianglePerimeter(double a, double b, double c) {
        return a + b + c;
    }

    default double circleArea(double radius) {
        return Math.PI * radius * radius;
    }

    default double rectangleArea(double x, double y) {
        return x * y;
    }

    default double triangleArea(double a, double b, double c) {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

}
