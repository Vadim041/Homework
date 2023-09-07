package task_1;

public abstract class Animal {

    protected String name;
    protected int maxRunningLength;
    protected int maxSwimmingLength;
    private static int count;

    public Animal(String name, int maxRunningLength, int maxSwimmingLength) {
        this.name = name;
        this.maxRunningLength = maxRunningLength;
        this.maxSwimmingLength = maxSwimmingLength;
        count++;
    }

    protected void run(int runningLength) {
    }

    protected void swim(int swimmingLength) {
    }

    public void eat(Dish dish, int amount) {}

    public static void getAnimalCount(){
        System.out.println("Количество животных: " + count);
    }

}
