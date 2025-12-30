package patterns.observer.push.interfaces;

/**
 * Subject/Observable contract for the PUSH model.
 *
 * The Subject maintains a list of observers and notifies them when its state changes.
 * The new value is pushed into ObserverInterface#update(T).
 *
 * @param <T> payload type being pushed to observers
 */
public interface ObservableInterface<T> {
    
    // List<ObserverInterface> observers;

    void addObserver(ObserverInterface<T> ob);

    void removeObserver(ObserverInterface<T> ob);

    void notifyAllObservers();

}
