package patterns.abstract_factory.classes;

import patterns.abstract_factory.interfaces.PersistenceFactory;
import patterns.abstract_factory.interfaces.PersistenceStoreFactory;

public class DatabasePersistenceFactory implements PersistenceFactory {
    
    @Override
    public PersistenceStoreFactory getFactory(String factoryType) {
        switch (factoryType) {
            case "SQL":
                return new SqlDatabaseStoreFactory();
            case "NOSQL":
                return new NoSqlDatabaseStoreFactory();
            default:
                throw new IllegalArgumentException("Incorrect Factory");
        }
    }
    
}
