package ru.avalon.javapp.devj30.readerswriters;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Database {
    private static AtomicInteger countReaders = new AtomicInteger();
    private static AtomicInteger countWriters = new AtomicInteger();

    private int numberOfEntries;

    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void reading(Reader reader) {
        lock.readLock().lock();
        try {
            System.out.println("Reader " + reader.getName() + " came to the database. " +
                    "Number of readers in the database : " + countReaders.incrementAndGet() + "; " +
                    "Number of writers in the database : " + countWriters);
            reader.imitateAction(900, 1200);
            System.out.println("Reader " + reader.getName() + " left the database." +
                    "Number of readers in the database : " + countReaders.decrementAndGet());
        } finally {
            lock.readLock().unlock();
        }
    }


    public void write(Writer writer) {
        lock.writeLock().lock();
        try {
            System.out.println("Writer " + writer.getName() + " came to the database. " +
                    "Number of readers in the database : " + countReaders + "; " +
                    "Number of writers in the database : " + countWriters.incrementAndGet());
            writer.imitateAction(1200, 1400);
            System.out.println("Writer " + writer.getName() + " left the database." +
                    "Number of writers in the database : " + countWriters.decrementAndGet());
            numberOfEntries++;
            System.out.println("Number of entries in the database : " + numberOfEntries + "\n");
        } finally {
            lock.writeLock().unlock();
        }
    }
}
