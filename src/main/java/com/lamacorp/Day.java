package com.lamacorp;

public abstract class Day {

    public void run() {
        System.out.println("----- DAY " + getNumber() + " -----");
        part1();
        part2();
    }

    protected abstract void part1();
    protected abstract void part2();
    protected abstract String getNumber();
}
