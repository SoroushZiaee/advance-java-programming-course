package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;

public class HashTable {
    private final static int MAX_LEN = 10 * 'z';

    private ArrayList<String>[] words;

    public HashTable() {
        words = new ArrayList[MAX_LEN];
    }

    private int hash(String word) {
        // get a word and calculate it's hash code
        int output = 0;
        for (char c : word.toCharArray()) {
            output += (int) c;
        }
        return output;
    }

    public void setWord(String word) {
        // get a word and put it in hash table
        int hash = hash(word);
//        System.out.println(word + " " + hash);
        for (int i = 0; i < this.words.length; i++) {
            if (i == hash) {
                if (words[i] == null) {
                    words[i] = new ArrayList<>(List.of(word));
                } else {
                    words[i].add(word);
                }
            }
        }
    }

    public ArrayList<String>[] getHashTable() {
        // return entire words in format of hash table
        ArrayList<String>[] copyOfWords = new ArrayList[MAX_LEN];
        for (int i = 0; i < this.words.length; i++) {
            if (this.words[i] != null) {
                copyOfWords[i] = words[i];
            }else{
                copyOfWords[i] = null;
            }
        }
        return copyOfWords;
    }

    public String getWord(int arrayIndex, int arrayListIndex) {
        // get an array index and an arrayList index and return
        // corresponding word
        if (this.words[arrayIndex] != null){
            return this.words[arrayIndex].get(arrayListIndex);
        }

        return null;
    }

    public int[] findIndex(String word) {
        // get a word and return and array which it's first
        // index is array index and the second index is
        // arraylist index
        // return null if nothing found
        for (int i = 0; i < this.words.length; i++) {
            if (this.words[i] != null) {
                for (int j = 0; j < this.words[i].size(); j++) {
                    if (word.equals(this.words[i].get(j))) {
                        return new int[]{i, j};
                    }
                }
            }
        }
        return null;
    }
}
