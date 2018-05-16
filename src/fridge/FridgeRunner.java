package fridge;

import java.util.ArrayList;
import java.util.List;

public class FridgeRunner {
    public static void main(String[] args) {
        Fridge fridge = new Fridge();
        fridge.addToFridge(new FridgeItem(10, 10, "Milk"));
        fridge.addToFridge(new FridgeItem(10, 10, "Apples"));

        List<Thread> runnables = new ArrayList<>();
        runnables.add(new Thread(fridge));
        runnables.add(new Thread(new HungryRoommate(fridge, "Milk")));
        runnables.add(new Thread(new HungryRoommate(fridge, "Apples")));
        runnables.add(new Thread(new HungryRoommate(fridge, "Apples")));
        runnables.add(new Thread(new NiceRoommate(fridge)));
        runnables.add(new Thread(new NiceRoommate(fridge)));

        for (Thread runnable : runnables) {
            runnable.start();
        }


    }
}
