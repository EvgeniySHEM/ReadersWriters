package ru.avalon.javapp.devj30.readerswriters;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();

        AbstractPerson[] people = {
                new Writer(database, "w1"),
                new Writer(database, "w2"),
                new Writer(database, "w3"),
                new Reader(database, "r1"),
                new Reader(database, "r2"),
                new Reader(database, "r3"),
                new Reader(database, "r4"),
                new Reader(database, "r5"),
                new Reader(database, "r6")
        };

        for (AbstractPerson p : people) {
            p.start();
        }
    }
}
