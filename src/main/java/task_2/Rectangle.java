package task_2;

public class Rectangle extends Shape {

    private double x,y;

    public Rectangle(){}

    public Rectangle(double x, double y, String fillColor, String borderColor) {
        super(fillColor,borderColor);
        this.x = x;
        this.y = y;
    }

    @Override
    public void printInfo() {
        System.out.println("Прямоугольник[Периметр: " + rectanglePerimeter(x,y) + "; Площадь: " + rectangleArea(x,y)
                + "; Цвет фона: " + fillColor  + "; Цвет границ: " + borderColor + "]");
    }
}
