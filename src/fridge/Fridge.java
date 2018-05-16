package fridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fridge implements Runnable {
    final static int DEBUG_TIMEOUT = 1000;
    List<FridgeItem> items;
    Map<String, FridgeItem> itemByType;

    public Fridge() {
        items = new ArrayList<>();
        itemByType = new HashMap<>();
    }

    public void addToFridge(FridgeItem fi) {

        items.add(fi);
        itemByType.put(fi.type, fi);
    }

    @Override
    public void run() {

        while (true) {
            boolean inErrorState = false;
            for (FridgeItem fridgeItem : items) {
                inErrorState = inErrorState | !fridgeItem.isInValidState();
            }

            System.out.println("-- ");
            if (inErrorState) {
                System.out.println("In Error State");
            }
            for (FridgeItem fridgeItem : items) {
                System.out.println(fridgeItem.toString());
            }

            try {
                Thread.sleep(DEBUG_TIMEOUT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
