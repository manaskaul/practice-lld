package patterns.observer.pull.classes;

import patterns.observer.pull.interfaces.NewsFeedView;
import patterns.observer.pull.interfaces.ObserverInterface;

/**
 * Concrete Observer (PULL model).
 * Receives a subject/view reference and pulls the needed data via getters.
 *
 * Why NewsFeedView and not NewsAgency?
 * - This keeps the observer decoupled from the concrete subject class.
 * - The observer only depends on the minimal, read-only API it needs.
 * - Any subject that implements NewsFeedView can be plugged in.
 */
public class EmailSubscriberObserver implements ObserverInterface<NewsFeedView> {

    @Override
    public void update(NewsFeedView feed) {
        // Pull the data we need from the subject (read-only view).
        System.out.println("Email subscriber: " + feed.getLatestHeadline());
    }

}
