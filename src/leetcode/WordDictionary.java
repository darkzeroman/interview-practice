package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class WordDictionary {

    Map<Integer, Map<Character, Set<String>>> data;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        data = new HashMap<>();
    }

    public static void main(String[] args) {
        // ["WordDictionary","addWord","addWord","search","search","search","search","search","search","search","search"]
//[[],["a"],["ab"],["a"],["a."],["ab"],[".a"],[".b"],["ab."],["."],[".."]]
        WordDictionary wd = new WordDictionary();
        wd.addWord("a");
        wd.addWord("ab");
//        wd.search("a.");
//        wd.search("ab");
//        wd.search(".a");
//        wd.search(".b");
//        wd.search("ab.");
        System.out.println(wd.search("."));
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!data.containsKey(i)) {
                data.put(i, new HashMap<Character, Set<String>>());
            }

            Map<Character, Set<String>> wordData = data.get(i);
            if (!wordData.containsKey(ch)) {
                wordData.put(ch, new HashSet<>());
            }

            wordData.get(ch).add(word);
        }

    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        Set<String> set = null;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!data.containsKey(i)) {
                return false;
            }

            Set<String> charSet = new HashSet<>();
            if (ch == '.') {
                for (Map<Character, Set<String>> s : data.values()) {
                    for (Set<String> strSet : s.values()) {
                        for (String str : strSet) {
                            if (str.length() == word.length()) charSet.add(str);
                        }
                    }
                }
            } else {
                for (String str : data.get(i).getOrDefault(ch, new HashSet<>())) {
                    if (str.length() == word.length()) charSet.add(str);
                }
            }


            if (set == null) {
                set = new HashSet<>(charSet);
            } else {
                set.retainAll(charSet);
            }
        }
        return set != null && !set.isEmpty();
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */