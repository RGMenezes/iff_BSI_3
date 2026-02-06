package TP.ex.ex03.view;

import TP.ex.ex03.model.Timer;

public class TestTimer {
    public static void main(String[] args) {
        Timer timer = new Timer();

        timer.start();
        
        for (int i = 0; i < 1000000000; i++) {
        }
        timer.stop();

        long elapsedTimeNano = timer.getElapsedTimeNano();
        System.out.println("\nElapsed time in nanoseconds: " + elapsedTimeNano);

        long elapsedTimeMilli = timer.getElapsedTimeMilli();
        System.out.println("Elapsed time in milliseconds: " + elapsedTimeMilli);

        long elapsedTimeSec = timer.getElapsedTimeSec();
        System.out.println("Elapsed time in seconds: " + elapsedTimeSec);
    }
}
