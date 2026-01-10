package lld_00_patterns.abstract_factory.classes;

import lld_00_patterns.abstract_factory.interfaces.PersistenceStore;
import lld_00_patterns.abstract_factory.interfaces.PersistenceStoreFactory;

public class SqlDatabaseStoreFactory implements PersistenceStoreFactory {
    
    @Override
    public PersistenceStore createStore(String storeType) {
        switch (storeType) {
            case "POSTGRESQL":
                return new PostgresqlPersistence();
            case "SQLITE":
                return new SqlitePersistence();
            default:
                throw new IllegalArgumentException("Invalid Store Type");
        }
    }

}
