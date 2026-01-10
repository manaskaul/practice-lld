package lld_00_patterns.observer.pull.interfaces;

/**
 * Observer contract for the PULL model.
 *
 * The Subject does NOT push the changed value into update(...).
 * Instead it passes a reference to the Subject (or a read-only view of it),
 * and the observer pulls the data it needs via getters.
 *
 * @param <S> subject/view type that observers can read from
 */
public interface ObserverInterface<S> {

    /**
     * Called by the subject when it changes.
     * Observers should pull required information from the passed subject/view.
     */
    void update(S subject);

}
