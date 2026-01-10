package lld_00_patterns.abstract_factory.classes;

import lld_00_patterns.abstract_factory.interfaces.PersistenceStore;
import lld_00_patterns.abstract_factory.interfaces.PersistenceStoreFactory;

public class NoSqlDatabaseStoreFactory implements PersistenceStoreFactory {
    
    @Override
    public PersistenceStore createStore(String storeType) {
        switch (storeType) {
            case "MONGODB":
                return new MongoDbPersistence();
            case "CASSANDRA":
                return new CassandraPersistence();
            default:
                throw new IllegalArgumentException("Invalid Store Type");
        }
    }

}