package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Words {
    private List<String> words = new ArrayList<>();

    public void addWord(String word) {
        if (word.contains(" ")) {
            throw new IllegalArgumentException("It should be one word!");
        } else if (!word.equals(word.toLowerCase())) {
            throw new IllegalArgumentException("Word should be lower case!");
        } else {
            words.add(word);
        }
    }

    public boolean isThereAWordTwice() {
        for (String word : words) {
            if (countWord(word) == 2) {
                return true;
            }
        }
        return false;
    }

    public int countWord(String word) {
        int count = 0;
        for (String s : words) {
            if (s.equals(word)) {
                count++;
            }
        }
        return count;
    }

    public List<String> getWords() {
        return words;
    }
}
