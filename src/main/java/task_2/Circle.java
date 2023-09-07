package task_2;

public class Circle extends Shape {

    private double radius;

    public Circle(){}

    public Circle(double radius,String fillColor, String borderColor) {
        super(fillColor,borderColor);
        this.radius = radius;
    }

    @Override
    public void printInfo() {
        System.out.println("Круг[Периметр: " + circlePerimeter(radius) + "; Площадь: " + circleArea(radius)
        + "; Цвет фона: " + fillColor  + "; Цвет границ: " + borderColor + "]");
    }

}
