package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class WordLadderII {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> ladders = new WordLadderII().findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        for (List<String> list : ladders) System.out.println(list);

    }

    public static ArrayList<String> createPath(State state) {
        return new ArrayList<>(state.path.stream().map(i -> i.word).collect(Collectors.toList()));
    }

    public static Map<String, Node> generateNeighbors(String beginWord, List<String> wordList) {
        Map<String, Node> map = new HashMap<>();
        Set<String> set = new HashSet<>(wordList);

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(beginWord));
        map.put(queue.peek().word, queue.peek());
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (String neighbor : generateWords(node.word, set)) {
                boolean alreadyExisted = map.containsKey(neighbor);
                Node neighborNode = map.computeIfAbsent(neighbor, Node::new);
                node.neighbors.add(neighborNode);
                neighborNode.neighbors.add(node);
                if (!alreadyExisted) {
                    queue.add(neighborNode);
                }
            }
        }

        return map;
    }

    public static List<String> generateWords(String word, Set<String> wordList) {
        StringBuilder sb = new StringBuilder(word);
        List<String> words = new ArrayList<>();

        for (int i = 0; i < sb.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (sb.charAt(i) == ch) {
                    continue;
                }

                char tmp = sb.charAt(i);
                sb.setCharAt(i, ch);
                String str = sb.toString();
                if (wordList.contains(str)) {
                    words.add(str);
                }
                sb.setCharAt(i, tmp);
            }
        }

        return words;
    }

    public ArrayList<ArrayList<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        Map<String, Node> nodes = generateNeighbors(beginWord, wordList);
        Node startNode = nodes.get(beginWord);

        List<State> states = new LinkedList<>();
        states.add(new State(startNode, new HashSet<Node>(Arrays.asList(startNode)), new ArrayList<Node>(Arrays.asList(startNode))));
        boolean hasFound = false;
        int minPathLen = 0;
        while (!states.isEmpty()) {
            State currState = states.remove(0);

            if (hasFound && currState.path.size() > minPathLen) {
                break;
            }

            if (currState.node.word.equals(endWord)) {
                result.add(createPath(currState));
                hasFound = true;
                minPathLen = currState.path.size();
                continue;
            }

            for (Node neighbor : currState.node.neighbors) {
                if (currState.seen.contains(neighbor)) {
                    continue;
                }

                states.add(new State(currState, neighbor));
            }
        }

        return result;
    }

    public static class State {
        Node node;
        Set<Node> seen;
        ArrayList<Node> path;

        public State(Node node, Set<Node> seen, ArrayList<Node> path) {
            this.node = node;
            this.seen = seen;
            this.path = path;
        }

        public State(State state, Node node) {
            this(node, new HashSet<>(state.seen), new ArrayList<Node>(state.path));
            this.path.add(node);
            this.seen.add(node);
        }
    }

    public static class Node {
        String word;
        Set<Node> neighbors = new HashSet<>();

        public Node(String word) {
            this.word = word;
        }

    }
}