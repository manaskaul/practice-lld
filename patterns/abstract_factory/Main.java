package patterns.abstract_factory;

import patterns.abstract_factory.classes.DatabasePersistenceFactory;
import patterns.abstract_factory.interfaces.PersistenceFactory;
import patterns.abstract_factory.interfaces.PersistenceStore;
import patterns.abstract_factory.interfaces.PersistenceStoreFactory;

public class Main {
    public static void main(String[] args) {
        /*
            Create a abstract factory to get a factory
                - DatabasePersistenceFactory
                - InmemoryPersistenceFactory
            
            Use the factory to get the concrete implementation
                - SqlDatabaseFactory
                - NoSqlDatabaseFactory
                - FileFactory
                - NasFactory
            
            Use the concrete implementationt to perform action
                - PostgresqlPersistence
                - SqlitePersistence
                - MongoDbPersistence
                - CassandraPersistence

            PersistenceFactory               -->            PersistenceStoreFactory              -->        PersistenceStore
            |- DatabasePersistenceFactory                   |- SqlDatabaseStoreFactory                      |- PostgresqlPersistence
                                                            |- NoSqlDatabaseStoreFactory                    |- SqlitePersistence
                                                                                                            |- MongoDbPersistence
                                                                                                            |- CassandraPersistence
        */
        
        PersistenceFactory databasePersistenceFactory = new DatabasePersistenceFactory();
        
        PersistenceStoreFactory sqlPersistenceStoreFactory = databasePersistenceFactory.getFactory("SQL");
        
        PersistenceStore sqliteStore = sqlPersistenceStoreFactory.createStore("SQLITE");
        
        sqliteStore.save();
    }
}
