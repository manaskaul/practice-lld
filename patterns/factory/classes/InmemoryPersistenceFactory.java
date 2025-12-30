package patterns.factory.classes;

import patterns.factory.interfaces.PersistenceStore;
import patterns.factory.interfaces.PersistenceStoreFactory;

/**
 * Concrete Creator (Factory Method pattern).
 *
 * Encapsulates creation logic for InmemoryPersistence.
 */
public class InmemoryPersistenceFactory implements PersistenceStoreFactory {
    
    @Override
    public PersistenceStore create() {
        // The client only sees PersistenceStore, not the concrete class.
        return new InmemoryPersistence();
    }

}
