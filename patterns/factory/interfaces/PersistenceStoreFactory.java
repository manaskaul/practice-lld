package patterns.factory.interfaces;

/**
 * Creator interface (Factory Method pattern).
 *
 * Concrete factories implement this interface and decide which concrete
 * PersistenceStore to create.
 */
public interface PersistenceStoreFactory {
    
    /**
     * Factory method: creates and returns a PersistenceStore.
     */
    PersistenceStore create();
    
}
