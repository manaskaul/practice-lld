package patterns.factory.classes;

import patterns.factory.interfaces.PersistenceStore;

/**
 * Concrete Product (Factory Method pattern).
 * Represents an in-memory persistence implementation.
 */
public class InmemoryPersistence implements PersistenceStore {
    
    @Override
    public void save() {
        System.out.println("Save to Inmemory");
    }

}
