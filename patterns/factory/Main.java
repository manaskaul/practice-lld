package patterns.factory;

import patterns.factory.classes.DatabasePersistenceFactory;
import patterns.factory.classes.InmemoryPersistenceFactory;
import patterns.factory.interfaces.PersistenceStore;
import patterns.factory.interfaces.PersistenceStoreFactory;

/**
 * Demo for the Factory Method pattern.
 *
 * Key roles:
 * - Product: PersistenceStore
 * - Concrete Products: DatabasePersistence, InmemoryPersistence
 * - Creator: PersistenceStoreFactory (declares the factory method create())
 * - Concrete Creators: DatabasePersistenceFactory, InmemoryPersistenceFactory
 *
 * In real apps, the selection of which factory to use usually comes from
 * configuration (env/properties) or a DI container.
 */
public class Main {
    public static void main(String[] args) {
        // Pick the concrete creator (factory) you want.
        PersistenceStoreFactory dbPersistenceFactory = new DatabasePersistenceFactory();

        // Ask the factory to create the product (interface type).
        PersistenceStore dbPersistence = dbPersistenceFactory.create();

        // Use the product without knowing its concrete class.
        dbPersistence.save();

        PersistenceStoreFactory inmemoryPersistenceFactory = new InmemoryPersistenceFactory();
        PersistenceStore inmemoryPersistence = inmemoryPersistenceFactory.create();
        inmemoryPersistence.save();
    }
}
