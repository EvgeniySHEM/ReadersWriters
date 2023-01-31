package ru.avalon.javapp.devj30.readerswriters;

public class Reader extends AbstractPerson {
    public Reader(Database database, String name) {
        super(database, name);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(this.getName() + " waiting for connection to the database");
            database.reading(this);
            imitateAction(200, 500);
        }
    }
}
