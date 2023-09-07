package task_1;

public class Main {

    public static void main(String[] args) {
        Dog dogBobik = new Dog("Бобик");
        Dog dogSharik = new Dog("Шарик");
        Cat catVasya = new Cat("Вася");
        Dish catDish = new Dish(100);
        Cat[] cats = new Cat[]{new Cat("Петя"), new Cat("Сема"), new Cat("Рыжик")};

        dogBobik.run(150);
        dogBobik.swim(1);
        dogSharik.run(1500);

        catVasya.run(100);
        catVasya.eat(catDish, 50);

        for (Cat cat : cats) {
            cat.eat(catDish, 20);
            System.out.println(cat.isSatiety());
        }

        Dog.getDogCount();
        Animal.getAnimalCount();

    }
}
