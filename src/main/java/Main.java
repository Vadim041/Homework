import models.Apple;
import models.Box;
import models.Orange;

public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        appleBox1.addFruit(new Apple(1.0f));
        appleBox1.addFruit(new Apple(1.0f));

        Box<Orange> orangeBox1 = new Box<>();
        orangeBox1.addFruit(new Orange(1.5f));
        orangeBox1.addFruit(new Orange(1.5f));

        System.out.println("Is the weight in boxes equals?: " + appleBox1.compare(orangeBox1));

        System.out.println("AppleBox1 weight: " + appleBox1.getWeight());
        System.out.println("AppleBox2 weight: " + appleBox2.getWeight());

        appleBox1.transfer(appleBox2);
        System.out.println("---Weight after transfer---");

        System.out.println("AppleBox1 weight: " + appleBox1.getWeight());
        System.out.println("AppleBox2 weight: " + appleBox2.getWeight());

    }
}
