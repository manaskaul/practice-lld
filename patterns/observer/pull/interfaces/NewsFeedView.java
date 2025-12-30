package patterns.observer.pull.interfaces;

/**
 * Read-only view of the subject.
 *
 * Pull model: observers receive this view in update(),
 * then "pull" whatever data they need via getters.
 *
 * Using a view interface keeps observers decoupled from the concrete subject class
 * and limits observers to only the data they should be able to read.
 */
public interface NewsFeedView {

    String getLatestHeadline();

}
