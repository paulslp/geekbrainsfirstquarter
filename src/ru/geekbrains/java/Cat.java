package ru.geekbrains.java;

public class Cat extends Animal {
    public Cat(String name, int maxRunDistance, float maxJumpHeight, int maxSwimmingDistance) {
        super(name, maxRunDistance, maxJumpHeight, maxSwimmingDistance);
    }

    @Override
    void printInfo() {
        System.out.println("Cat with name " + name + ", " + getLimitsInfo());
    }
}
