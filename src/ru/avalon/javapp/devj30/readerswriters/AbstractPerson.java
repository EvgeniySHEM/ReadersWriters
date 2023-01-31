package ru.avalon.javapp.devj30.readerswriters;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public abstract class AbstractPerson extends Thread{
    protected final Database database;
    protected final Random rnd = ThreadLocalRandom.current();

    public AbstractPerson(Database database, String name) {
        super(name);
        this.database = database;
    }

    public void imitateAction(long minMs, long maxMs) {
        try {
            Thread.sleep((long) (minMs + (maxMs - minMs) * rnd.nextFloat(1)));
        } catch (InterruptedException e) {
        }
    }

}
