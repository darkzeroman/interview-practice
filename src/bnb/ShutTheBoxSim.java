package bnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ShutTheBoxSim {
    public static void main(String[] args) {
        ShutTheBoxSim sim = new ShutTheBoxSim(new DumbStrategy());
        sim.runGame();

    }
    int NUM_TILES = 9;
    boolean[] state;
    Random random = new Random();
    Strategy strategy;

    public ShutTheBoxSim(Strategy strategy) {
        state = new boolean[NUM_TILES];
        Arrays.fill(state, true);
        this.strategy = strategy;
    }

    public void runGame() {
        while (true) {
            int num = rollDice();
            List<Integer> moves = this.strategy.determineMove(state, num);
            System.out.println(String.format("State: %s, Dice: %d, Moves:%s", Arrays.toString(state), num, moves));
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

                used[i] = true;
                sum += (i+1);
                helper(state, used, sum, index+1, results, target);
                sum -= (i+1);
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
            return validMoves.get(0);
        }
    }

}
