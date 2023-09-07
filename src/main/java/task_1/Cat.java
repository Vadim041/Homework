package task_1;

public class Cat extends Animal {

    private static int catCount;
    private boolean satiety;

    public Cat(String name) {
        super(name, 200, 0);
        satiety = false;
    }

    @Override
    protected void run(int runningLength) {
        if (runningLength <= maxRunningLength) {
            System.out.println("Кот " + name + " пробежал " + runningLength + " м");
        } else {
            System.out.println("Кот " + name + " не может пробежать " + runningLength + " м");
        }
    }

    @Override
    protected void swim(int swimmingLength) {
        System.out.println("Коты не умеют плавать");
    }

    @Override
    public void eat(Dish dish, int amount) {
        if (amount > 0 && amount <= dish.amountFood) {
            dish.amountFood -= amount;
            satiety = true;
            System.out.println("Кот " + name + " съел " + amount + " едениц корма");
        } else {
            System.out.println("Коту " + name + " не удалось сытно поесть");
        }
    }

    public String isSatiety() {
        if (satiety == true) {
            return "Кот " + name + " сыт";
        } else {
            return "Кот " +  name + " голоден";
        }
    }

    public static void getCatCount() {
        System.out.println("Количество собак: " + catCount);
    }
}
