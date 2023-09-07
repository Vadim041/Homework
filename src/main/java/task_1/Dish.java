package task_1;

public class Dish {

    protected int amountFood;

    public Dish(int amountFood){
            this.amountFood = amountFood;
    }

    public void addFood(int amount){
        if ( amount > 0){
            amountFood += amount;
            System.out.println("Добавлено: " + amount + " Корма в тарелке: " + amountFood);
        } else {
            System.out.println("Еда не добавлена");
        }
    }

}
