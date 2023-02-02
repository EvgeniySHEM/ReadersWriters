package ru.avalon.javapp.devj30.readerswriters;

public class Reader extends AbstractPerson {
    public Reader(Database database, String name) {
        super(database, name);
    }

    @Override
    public void run() {
        while (true) {
            try {
                imitateAction(100, 500);
                database.reading(this);
            } catch (InterruptedException e) {
            }
            imitateAction(200, 500);
        }
    }
}
