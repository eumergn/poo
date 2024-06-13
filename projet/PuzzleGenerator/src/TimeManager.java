public class TimeManager {
    private long startTime;
    private long bestTime;

    public void startTimer() {
        startTime = System.currentTimeMillis();
    }

    public void stopTimer() {
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        if (bestTime == 0 || elapsedTime < bestTime) {
            bestTime = elapsedTime;
        }
    }

    public long getElapsedTime() {
        return System.currentTimeMillis() - startTime;
    }

    public long getBestTime() {
        return bestTime;
    }
}