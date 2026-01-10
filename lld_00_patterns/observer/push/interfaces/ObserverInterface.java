package lld_00_patterns.observer.push.interfaces;

/**
 * Observer contract for the PUSH model.
 *
 * The Subject pushes the updated value (payload) into update(value).
 *
 * @param <T> payload type being pushed to observers
 */
public interface ObserverInterface<T> {
    
    void update(T value);

}
