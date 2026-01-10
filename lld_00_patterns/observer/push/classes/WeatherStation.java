package lld_00_patterns.observer.push.classes;

import java.util.ArrayList;
import java.util.List;

import lld_00_patterns.observer.push.interfaces.ObservableInterface;
import lld_00_patterns.observer.push.interfaces.ObserverInterface;

/**
 * Concrete Subject (Observable) for the PUSH model.
 *
 * State: temperature
 * Notification: pushes the latest temperature to all observers via update(temperature).
 */
public class WeatherStation implements ObservableInterface<Integer> {

    private List<ObserverInterface<Integer>> observers = new ArrayList<>();

    private int temperature;

    /**
     * State change entry-point.
     * In a typical Observer pattern, the Subject calls notifyAllObservers() after state updates.
     */
    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyAllObservers();
    }

    @Override
    public void addObserver(ObserverInterface<Integer> ob) {
        observers.add(ob);
    }

    @Override
    public void removeObserver(ObserverInterface<Integer> ob) {
        observers.remove(ob);
    }

    @Override
    public void notifyAllObservers() {
        // PUSH: pass the value directly to observers.
        observers.forEach(obs -> obs.update(temperature));
    }
    
}
