package lld_00_patterns.factory.interfaces;

/**
 * Product interface (Factory Method pattern).
 *
 * Client code depends on this abstraction, not on concrete persistence classes.
 */
public interface PersistenceStore {
    
    void save();

}
