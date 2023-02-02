package ru.avalon.javapp.devj30.readerswriters;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        ExecutorService executorService = Executors.newFixedThreadPool(9);

        for (int i = 1; i <= 3; i++) {
            executorService.submit(new Writer(database,"w" + i ));
        }

        for (int i = 1; i <= 6; i++) {
            executorService.submit(new Reader(database,"r" + i ));
        }
    }
}
