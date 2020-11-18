package ru.geekbrains.java;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(int n) {
        if (food >= n) {
            food -= n;
        }
    }

    public void addFood(int foodForAdding) {
        this.food += foodForAdding;
    }

    public void info() {
        System.out.println("plate: " + food);
    }
}
