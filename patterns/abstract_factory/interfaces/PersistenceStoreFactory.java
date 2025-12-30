package patterns.abstract_factory.interfaces;

public interface PersistenceStoreFactory {
    
    public PersistenceStore createStore(String storeType);

}
