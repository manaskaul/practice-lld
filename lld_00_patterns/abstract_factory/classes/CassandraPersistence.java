package lld_00_patterns.abstract_factory.classes;

import lld_00_patterns.abstract_factory.interfaces.PersistenceStore;

public class CassandraPersistence implements PersistenceStore {

    @Override
    public void save() {
        System.out.println("Save to Cassandra Database");
    }
    
}