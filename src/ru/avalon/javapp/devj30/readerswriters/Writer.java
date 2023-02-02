package ru.avalon.javapp.devj30.readerswriters;

public class Writer extends AbstractPerson {

    public Writer(Database database, String name) {
        super(database, name);
    }

    @Override
    public void run() {
        while (true) {
            imitateAction(200, 800);
            database.write(this);
        }
    }
}
