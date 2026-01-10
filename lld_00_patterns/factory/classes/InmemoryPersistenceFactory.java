package lld_00_patterns.factory.classes;

import lld_00_patterns.factory.interfaces.PersistenceStore;
import lld_00_patterns.factory.interfaces.PersistenceStoreFactory;

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
