package lld_00_patterns.factory.classes;

import lld_00_patterns.factory.interfaces.PersistenceStore;

/**
 * Concrete Product (Factory Method pattern).
 * Represents a database-backed persistence implementation.
 */
public class DatabasePersistence implements PersistenceStore {
    
    @Override
    public void save() {
        System.out.println("Save to Database");
    }

}
