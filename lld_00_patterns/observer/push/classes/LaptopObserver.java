package lld_00_patterns.observer.push.classes;

import lld_00_patterns.observer.push.interfaces.ObserverInterface;

/**
 * Concrete Observer (PUSH model).
 * Receives the updated temperature directly in update(value).
 */
public class LaptopObserver implements ObserverInterface<Integer> {
    
    @Override
    public void update(Integer temperature) {
        System.out.println("Laptop: temperature updated to " + temperature);
    }

}
