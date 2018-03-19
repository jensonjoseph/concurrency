package com.jensonjo;

public class Main {
    public static void main(String args[]) {
        new Thread(new Worker("worker1")).start();
        new Thread(new Worker("worker2")).start();
    }
}
