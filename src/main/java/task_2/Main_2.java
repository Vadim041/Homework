package task_2;

public class Main_2 {

    public static void main(String[] args) {
        Circle circle = new Circle(5,"Зеленый","Красный");
        Rectangle rectangle = new Rectangle(5,6,"Синий","Голубой");
        Triangle triangle = new Triangle(5,5,5,"Черный","Голубой");

        circle.printInfo();
        rectangle.printInfo();
        triangle.printInfo();
    }
}
