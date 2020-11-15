package ru.geekbrains.java;

public class Dog extends Animal {
    public Dog(String name, int maxRunDistance, float maxJumpHeight, int maxSwimmingDistance) {
        super(name, maxRunDistance, maxJumpHeight, maxSwimmingDistance);
    }

    @Override
    void printInfo() {
        System.out.println("Dog with name " + name + " ," + getLimitsInfo());
    }
}
