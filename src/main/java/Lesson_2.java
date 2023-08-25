public class Lesson_2 {

    public static void main(String[] args) {
        Lesson_2 lesson2 = new Lesson_2();
        lesson2.checkSumSign();
        lesson2.printColor();
        lesson2.compareNumber();
    }

    public void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    public void checkSumSign() {
        int a = 10;
        int b = -100;
        String answer = a + b >= 0 ? "Сумма положительная" : "Сумма отрицательная";
        System.out.println(answer);
    }

    public void printColor() {
        int value = 100;
        if (value <= 0){
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public void compareNumber(){
        int a = 1;
        int b = 10;
        String answer = a >= b ? "a >= b" : "a < b";
        System.out.println(answer);
    }
}
