package ru.avalon.javapp.devj30.readerswriters;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Database {
    private volatile int countReaders;
    private volatile int countWriters;


    private volatile int numberOfEntries;

    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void reading(Reader reader) throws InterruptedException {
        if(lock.isWriteLocked())
            System.err.println(reader.getName() + " waiting for connection to the database");

        lock.readLock().lock();
        try {
            synchronized (this) {
                countReaders++;
                System.out.println("Reader " + reader.getName() + " came to the database. " +
                        "Number of readers in the database : " + countReaders + "; " +
                        "Number of writers in the database : " + countWriters);
            }

            reader.imitateAction(300, 600);

            synchronized (this) {
                countReaders--;
                System.out.println("Reader " + reader.getName() + " left the database." +
                        "Number of readers in the database : " + countReaders);
            }
        } finally {
            lock.readLock().unlock();
        }
    }


    public void write(Writer writer) {
        if(lock.isWriteLocked())
            System.err.println(writer.getName() + " waiting for connection to the database");

        lock.writeLock().lock();
        try {
            countWriters++;
            System.out.println("\nWriter " + writer.getName() + " came to the database. " +
                    "Number of readers in the database : " + countReaders + "; " +
                    "Number of writers in the database : " + countWriters);
            writer.imitateAction(900, 1000);
            countWriters--;
            System.out.println("Writer " + writer.getName() + " left the database." +
                    "Number of writers in the database : " + countWriters);
            numberOfEntries++;
            System.out.println("Number of entries in the database : " + numberOfEntries + "\n");
        } finally {
            lock.writeLock().unlock();
        }
    }
}
