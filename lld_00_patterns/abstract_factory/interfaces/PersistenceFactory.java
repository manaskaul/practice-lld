package lld_00_patterns.abstract_factory.interfaces;

public interface PersistenceFactory {

    public PersistenceStoreFactory getFactory(String factoryType);

}
