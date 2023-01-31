package ru.avalon.javapp.devj30.readerswriters;

public class Writer extends AbstractPerson {

    public Writer(Database database, String name) {
        super(database, name);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(this.getName() + " waiting for connection to the database");
            database.write(this);
            imitateAction(200, 800);
        }
    }
}
