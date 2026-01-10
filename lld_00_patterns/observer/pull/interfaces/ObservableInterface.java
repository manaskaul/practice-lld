package lld_00_patterns.observer.pull.interfaces;

/**
 * Subject/Observable contract for the PULL model.
 *
 * The Subject maintains observers and notifies them when its state changes.
 * Observers then pull the needed data from the Subject/view.
 *
 * @param <S> subject/view type that observers can read from
 */
public interface ObservableInterface<S> {

    void addObserver(ObserverInterface<S> observer);

    void removeObserver(ObserverInterface<S> observer);

    void notifyAllObservers();

}
