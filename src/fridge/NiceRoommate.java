package fridge;

public class NiceRoommate implements Runnable {
    private final static int TIME_TO_RESTORE = 10;
    private final static int WAIT = 10;

    private final Fridge fridge;

    public NiceRoommate(Fridge fridge) {
        this.fridge = fridge;
    }

    @Override
    public void run() {
        while (true) {
            for (FridgeItem fi : fridge.items) {
                if (fi.canRestock()) {
                    System.out.println("Restock: " + fi.type);
                    sleep(TIME_TO_RESTORE);
                    fi.restock();
                    break;
                }
            }
            sleep(WAIT);
        }
    }

    public void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
