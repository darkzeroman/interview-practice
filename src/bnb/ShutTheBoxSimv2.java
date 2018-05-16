package bnb;

import java.util.*;

public class ShutTheBoxSimv2 {
    public static void main(String[] args) {
        ShutTheBoxSimv2 sim = new ShutTheBoxSimv2(new DumbStrategy());
        sim.runGame();

    }
    int NUM_TILES = 9;
    boolean[] state;
    Random random = new Random();
    Strategy strategy;

    public ShutTheBoxSimv2(Strategy strategy) {
        state = new boolean[NUM_TILES];
        Arrays.fill(state, true);
        this.strategy = strategy;
    }

    public void runGame() {
        int numMoves = 0;
        while (true) {
            numMoves++;
            int num = rollDice();
            List<Integer> moves = this.strategy.determineMove(state, num);
            System.out.println(String.format("Move: %d, State: %s, Dice: %d, Moves:%s", numMoves, Arrays.toString(state), num, moves));
            if (moves.isEmpty()) {
                System.out.println("You've lost");
                break;
            }

            // validateMoves, to make sure it matches the num

            for (Integer index : moves) {
                if (!state[index-1]) {
                    System.out.println("You've lost");
                    break;
                }
                state[index-1] = false;
            }

            boolean allFlipped = true;
            for (int i = 0; i < state.length; i++) {
                allFlipped = allFlipped && !state[i];
            }
            if (allFlipped) {
                System.out.println("You've won");
                break;
            }
        }
    }

    private int rollDice() {
        return random.nextInt(6)+1 + random.nextInt(6)+1;
    }


    public static abstract class Strategy {
        abstract List<Integer> determineMove(boolean[] state, int num);
        List<List<Integer>> findPartitions(boolean[] state, int target) {
            List<List<Integer>> results = new ArrayList<>();
            helper(state, new boolean[state.length], 0, 0, results, target);
            return results;
        }

        private void helper(boolean[] state, boolean[] used, int sum, int index, List<List<Integer>> results, int target) {
            if (sum > target) {
                return;
            }

            if (sum == target) {
                List<Integer> validMove = new ArrayList<>();
                for (int i = 0; i < used.length; i++) {
                    if (used[i]) {
                        validMove.add(i+1);
                    }
                }
                results.add(validMove);
                return;
            }

            for (int i = index; i < used.length; i++) {
                if (!state[i]) {
                    continue;
                }

                int num = (i+1);

                used[i] = true;
                sum += num;
                helper(state, used, sum, num, results, target);
                sum -= num;
                used[i] = false;
            }
        }
    }

    private static class DumbStrategy extends Strategy {

        @Override
        public List<Integer> determineMove(boolean[] state, int num) {
            List<List<Integer>> validMoves = findPartitions(state, num);
            if (validMoves.isEmpty()) {
                return new ArrayList<>();
            }

            Collections.sort(validMoves, Comparator.comparing(List::size));
            return validMoves.get(0);
        }
    }

}
