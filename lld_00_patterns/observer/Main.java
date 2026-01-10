package lld_00_patterns.observer;

import lld_00_patterns.observer.pull.classes.EmailSubscriberObserver;
import lld_00_patterns.observer.pull.classes.MobileDisplayObserver;
import lld_00_patterns.observer.pull.classes.NewsAgency;
import lld_00_patterns.observer.push.classes.LaptopObserver;
import lld_00_patterns.observer.push.classes.PhoneObserver;
import lld_00_patterns.observer.push.classes.WeatherStation;

/**
 * Demo runner for the Observer Pattern.
 *
 * This file shows both common variants:
 * - Push model: subject pushes the updated value into update(value)
 * - Pull model: subject passes a read-only subject/view, observers pull via getters
 */
public class Main {
    public static void main(String[] args) {
        runPushWeatherStationDemo();

        System.out.println("\n---------------\n");

        runPullNewsAgencyDemo();
    }

    private static void runPushWeatherStationDemo() {
        // PUSH MODEL DEMO
        // 1) Subject changes its internal state.
        // 2) Subject NOTIFIES observers and PUSHES the new data into update(...).

        WeatherStation station = new WeatherStation();

        station.addObserver(new LaptopObserver());
        station.addObserver(new PhoneObserver());

        station.setTemperature(25);
        station.setTemperature(30);
    }

    private static void runPullNewsAgencyDemo() {
        // PULL MODEL DEMO
        // 1) Subject changes its internal state.
        // 2) Subject notifies observers by passing a reference (read-only view).
        // 3) Observers "pull" the latest data from that view using getters.

        NewsAgency agency = new NewsAgency();

        agency.addObserver(new MobileDisplayObserver());
        agency.addObserver(new EmailSubscriberObserver());

        agency.publishHeadline("Breaking: Observer pattern - pull model");
        agency.publishHeadline("Update: Observers pull data via getters");
    }
}
