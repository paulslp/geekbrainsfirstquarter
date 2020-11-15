package ru.geekbrains.java;

public abstract class Animal {
    final int maxRunDistance;
    final float maxJumpHeight;
    final int maxSwimmingDistance;
    final String name;

    public Animal(String name, int maxRunDistance, float maxJumpHeight, int maxSwimmingDistance) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.maxSwimmingDistance = maxSwimmingDistance;
    }

    abstract void printInfo();

    boolean run(int distance) {
        System.out.println("Running " + distance + " result:" + (distance <= maxRunDistance));
        return (distance <= maxRunDistance);
    }

    boolean jump(float height) {
        System.out.println("Jumping " + height + " result:" + (height <= maxJumpHeight));
        return (height <= maxJumpHeight);
    }

    boolean swim(float distance) {
        System.out.println("Swimming " + distance + " result:" + (distance <= maxSwimmingDistance));
        return (distance <= maxSwimmingDistance);
    }

    String getLimitsInfo() {
        return "maxRunDistance = " + maxRunDistance
                + ", maxJumpHeight = " + maxJumpHeight
                + ", maxSwimmingDistance = " + maxSwimmingDistance + ".";
    }
}
