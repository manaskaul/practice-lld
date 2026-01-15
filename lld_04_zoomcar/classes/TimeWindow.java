package lld_04_zoomcar.classes;

import lombok.Getter;

@Getter
public class TimeWindow {
    private int startTime;
    private int endTime;

    public TimeWindow(int start, int end) {
        this.startTime = start;
        this.endTime = end;
    }
}
