package ru.geekbrains.java;

public class Main {

    public static void main(String[] args) {
        Cat[] cats = {new Cat("Barsik", 5), new Cat("Chris", 6), new Cat("Denis", 4),
                new Cat("Lemon", 3), new Cat("Tom", 7), new Cat("Robert", 10)};
        Plate plate = new Plate(25);
        System.out.println("Information about plate before eating:");
        plate.info();
        System.out.println("Start eating:");
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
            cats[i].info();
            plate.info();
        }
        System.out.println("Finish eating:");
        if (plate.getFood() < 10) {
            plate.addFood(25);
            System.out.println("Add 25 food units");
        }
        plate.info();
    }

}
