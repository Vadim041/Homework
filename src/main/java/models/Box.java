package models;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    private List<T> fruits = new ArrayList<>();

    public void addFruit(T t) {
        fruits.add(t);
    }

    public float getWeight() {
        float weighCount = 0;
        for (T fruit : fruits) {
            weighCount += fruit.getWeight();
        }
        return weighCount;
    }

    public void transfer(Box<T> box) {
        box.fruits.addAll(this.fruits);
        this.fruits.clear();
    }

    public boolean compare(Box<? extends Fruit> box) {
        return Math.abs(this.getWeight() - box.getWeight()) < 0.0001;
    }

}
