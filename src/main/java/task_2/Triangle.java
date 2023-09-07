package task_2;

public class Triangle extends Shape {

    private double a,b,c;

    public Triangle(){}

    public Triangle(double a, double b, double c, String fillColor, String borderColor) {
        super(fillColor,borderColor);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public void printInfo() {
        System.out.println("Треугольник[Периметр: " + trianglePerimeter(a,b,c) + "; Площадь: " + triangleArea(a,b,c)
                + "; Цвет фона: " + fillColor  + "; Цвет границ: " + borderColor + "]");
    }
}
