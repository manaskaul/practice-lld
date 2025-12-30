package patterns.abstract_factory.classes;

import patterns.abstract_factory.interfaces.PersistenceStore;

public class SqlitePersistence implements PersistenceStore {

    @Override
    public void save() {
        System.out.println("Save to Sqlite Database");
    }
    
}