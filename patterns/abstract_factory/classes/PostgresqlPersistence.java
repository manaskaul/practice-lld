package patterns.abstract_factory.classes;

import patterns.abstract_factory.interfaces.PersistenceStore;

public class PostgresqlPersistence implements PersistenceStore {

    @Override
    public void save() {
        System.out.println("Save to Postgresql Database");
    }
    
}
