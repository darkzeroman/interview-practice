package fridge;

public class HungryRoommate implements Runnable {
    private final static int TIME_TO_EAT = 30;

    private final Fridge fridge;
    private final String itemPreference;

    public HungryRoommate(Fridge fridge, String itemPreference) {
        this.fridge = fridge;
        this.itemPreference = itemPreference;
    }

    @Override
    public void run() {
        while (true) {
            FridgeItem fi = fridge.itemByType.get(itemPreference);
            if (fi.eatIfCan()) {
                System.out.println("Eaten: " + fi.type);
                sleep();
                continue;
            }

            for (FridgeItem fridgeItem : fridge.items) {
                if (fridgeItem.eatIfCan()) {
                    System.out.println("Eaten: " + fi.type);
                    sleep();
                    break;
                }
            }
        }
    }

    public void sleep() {
        try {
            Thread.sleep(TIME_TO_EAT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
