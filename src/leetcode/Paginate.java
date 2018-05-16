package leetcode;

import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named NumIslands.
 *
 * If you need more classes, simply define them inline.
 */
public class Paginate {
    /*
     * Complete the function below.
     */
    static String[] paginate(int num, String[] results) {
        if (num == 0) {
            return new String[0];
        }
        LinkedList<Listing> originalListings = new LinkedList<>();

        for (String result : results) {
            originalListings.add(new Listing(result));
        }

        List<List<Listing>> pages = new ArrayList<>();

        while (!originalListings.isEmpty()) {
            LinkedList<Listing> skippedListings = new LinkedList<>();
            List<Listing> page = new ArrayList<>(num);
            Set<Integer> seenHosts = new HashSet<>();

            while (!originalListings.isEmpty() && page.size() < num) {
                Listing tmpListing = originalListings.removeFirst();
                if (seenHosts.contains(tmpListing.id)) {
                    skippedListings.add(tmpListing);
                } else {
                    seenHosts.add(tmpListing.id);
                    page.add(tmpListing);
                }
            }

            while (page.size() < num && !skippedListings.isEmpty()) {
                page.add(skippedListings.removeFirst());
            }

            originalListings.addAll(0, skippedListings);
            pages.add(page);
        }

        List<String> output = new LinkedList<>();
        for (int i = 0; i < pages.size(); i++) {
            List<Listing> page = pages.get(i);
            for (Listing listing : page) {
                output.add(listing.str);
            }
            if (i != pages.size() - 1) {
                output.add("");
            }
        }

        return output.toArray(new String[output.size()]);
    }

    private static class Listing {
        String str;
        int id;

        public Listing(String str) {
            this.str = str;
            String[] split = this.str.split(",");
            this.id = Integer.parseInt(split[0].trim());
        }
    }
}