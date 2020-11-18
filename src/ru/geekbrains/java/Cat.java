package ru.geekbrains.java;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean isSatiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        isSatiety = false;
    }

    public void eat(Plate p) {
        if (appetite <= p.getFood()) {
            p.decreaseFood(appetite);
            isSatiety = true;
        }
    }

    public void info() {
        System.out.println("Cat with name " + name + ", with appetit = " + appetite + " and isSatiety = " + isSatiety);
    }
}
