package ru.geekbrains.java;

public class Main {

    public static void main(String[] args) {
        Cat[] cats = createAndFillAndGetCatsArray();

        Plate plate = new Plate(25);
        System.out.println("Information about plate before eating:");
        plate.info();

        eating(cats, plate);

        addingFoodToPlate(plate, 10, 25);
    }

    private static Cat[] createAndFillAndGetCatsArray() {
        return new Cat[]{new Cat("Barsik", 5),
                new Cat("Chris", 6),
                new Cat("Denis", 4),
                new Cat("Lemon", 3),
                new Cat("Tom", 7),
                new Cat("Robert", 10)};
    }

    private static void eating(Cat[] cats, Plate plate) {
        System.out.println("Start eating:");
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
            cats[i].info();
            plate.info();
        }
        System.out.println("Finish eating:");
    }

    private static void addingFoodToPlate(Plate plate, int minFoodCount, int foodCount) {
        if (plate.getFood() < minFoodCount) {
            plate.addFood(foodCount);
            System.out.println("Add " + foodCount + " food units");
        }
        plate.info();
    }

}
