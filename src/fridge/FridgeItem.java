package fridge;

import java.util.concurrent.atomic.AtomicInteger;

public class FridgeItem {
    String type;
    private int maxCount;
    private AtomicInteger atomicCurrCount;
    private AtomicInteger expectedCount;


    public FridgeItem(int maxCount, int currCount, String type) {
        this.maxCount = maxCount;
        this.type = type;

        atomicCurrCount = new AtomicInteger(currCount);
        expectedCount = new AtomicInteger();
    }

    public synchronized boolean canRestock() {
        if (atomicCurrCount.get() + expectedCount.get() < maxCount) {
            expectedCount.incrementAndGet();
            return true;
        }
        return false;
    }

    public void restock() {
        atomicCurrCount.incrementAndGet();
    }

    public synchronized boolean eatIfCan() {
        synchronized (atomicCurrCount) {
            int newValue = atomicCurrCount.decrementAndGet();
            if (newValue < 0) {
                atomicCurrCount.incrementAndGet();
                return false;
            }

            return true;
        }
    }

    @Override
    public synchronized String toString() {
        return "FridgeItem{" +
                "maxCount=" + maxCount +
                ", currCount=" + atomicCurrCount.get() +
                ", type='" + type + '\'' +
                '}';
    }

    public synchronized boolean isInValidState() {
        int tmpValue = atomicCurrCount.get();
        return tmpValue >= 0 && tmpValue <= maxCount;
    }
}
