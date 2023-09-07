package task_1;

public class Dog extends Animal {

    private static int dogCount;

    public Dog(String name) {
        super(name, 500, 10);
        dogCount++;
    }

    @Override
    public void run(int runningLength) {
        if (runningLength <= maxRunningLength) {
            System.out.println("Пес " + name + " пробежал " + runningLength + " м");
        } else {
            System.out.println("Пес " + name + " не может пробежать " + runningLength + " м");
        }

    }

    @Override
    protected void swim(int swimmingLength) {
        if (swimmingLength <= maxSwimmingLength) {
            System.out.println("Пес " + name + " проплыл " + swimmingLength + " м");
        } else {
            System.out.println("Пес " + name + " не может проплыть " + swimmingLength + " м");
        }
    }

    public static void getDogCount() {
        System.out.println("Количество собак: " + dogCount);
    }
}
