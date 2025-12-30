package patterns.observer.pull.classes;

import java.util.ArrayList;
import java.util.List;

import patterns.observer.pull.interfaces.NewsFeedView;
import patterns.observer.pull.interfaces.ObservableInterface;
import patterns.observer.pull.interfaces.ObserverInterface;

/**
 * Subject / Observable (Pull model)
 *
 * Notice: we do NOT pass the headline into update().
 * Observers will pull it via NewsFeedView#getLatestHeadline().
 */
public class NewsAgency implements ObservableInterface<NewsFeedView>, NewsFeedView {

    private final List<ObserverInterface<NewsFeedView>> observers = new ArrayList<>();

    private String latestHeadline;

    @Override
    public void addObserver(ObserverInterface<NewsFeedView> observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ObserverInterface<NewsFeedView> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        // PULL: pass a reference to the subject (as a read-only view).
        // Observers will pull the headline via feed.getLatestHeadline().
        observers.forEach(observer -> observer.update(this));
    }

    /**
     * State change entry-point: publishing a new headline.
     * After state changes, notify all observers.
     */
    public void publishHeadline(String headline) {
        this.latestHeadline = headline;
        notifyAllObservers();
    }

    @Override
    public String getLatestHeadline() {
        return latestHeadline;
    }
}
