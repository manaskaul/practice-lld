package lld_00_patterns.abstract_factory.classes;

import lld_00_patterns.abstract_factory.interfaces.PersistenceStore;

public class MongoDbPersistence implements PersistenceStore {

    @Override
    public void save() {
        System.out.println("Save to MongoDB Database");
    }
    
}