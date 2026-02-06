package TP.ex.ex03.model;

public class Timer {
    private long startTime;
    private long endTime;

    public void start() {
        startTime = System.nanoTime();
    }

    public void stop() {
        endTime = System.nanoTime();
    }

    public long getElapsedTimeNano() {
        return endTime - startTime;
    }

    public long getElapsedTimeSec() {
        return (endTime - startTime) / 1_000_000_000;
    }

    public long getElapsedTimeMilli() {
        return (endTime - startTime) / 1_000_000;
    }

    public void reset() {
        startTime = 0;
        endTime = 0;
    }
}