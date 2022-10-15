package ir.ac.kntu;

import java.util.*;

public class Language {
    // HashTable to save words by letters
    private final HashMap<Character, ArrayList<String>> wordList;

    // Language author name
    private String creatorName;

    // Language name
    private String name;

    public Language(String creatorName, String name){
        setCreatorName(creatorName);
        setName(name);
        wordList = new HashMap<>();
    }


    // Implement constructor for Language
    // Implement getter and setter for fields
    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWordList(HashMap<Character, ArrayList<String>> set) {
        this.wordList.clear();
        this.wordList.putAll(set);
    }

    public HashMap<Character, ArrayList<String>> getWordList() {
        return new HashMap<Character, ArrayList<String>>(wordList);
    }

    // add word to wordList by first letter (key)
    public void addWord(String word) {
        Character key = Character.toLowerCase(word.charAt(0));
        if (this.wordList.containsKey(key)){
            ArrayList<String> temp = wordList.get(key);
            if (!temp.contains(word)){
                temp.add(word);
            }
            wordList.replace(key, wordList.get(key), temp);

        }else{
            wordList.put(key, new ArrayList<>(List.of(word)));
        }
    }

    // remove specific word from wordList
    public void removeWord(String word) {
        Character key = Character.toLowerCase(word.charAt(0));
        if (this.wordList.containsKey(key)){
            ArrayList<String> temp = wordList.get(key);
            temp.remove(word);
            this.wordList.put(key, temp);
        }
    }

    // get list of words by first character
    public ArrayList<String> getListOfWordsByCharacter(char c) {
        if (this.wordList.get((Character) c) == null){
            return new ArrayList<>();
        }else {
            return new ArrayList<String>(this.wordList.get((Character) c));
        }
    }

    // count total words in language
    public int countWords() {
        int output = 0;
        for (Map.Entry<Character, ArrayList<String>> set: this.wordList.entrySet()){
            for (String s: set.getValue()){
                output += 1;
            }
        }
        return output;
    }

    // check if word is already in language
    public boolean contains(String word) {
        ArrayList<String> temp = this.wordList.get(Character.toLowerCase(word.charAt(0)));
        if (temp != null) {
            return temp.contains(word);
        }else{
            return false;
        }

    }

    @Override
    public String toString() {
        return "Language{" +
                "wordList=" + wordList +
                ", creatorName='" + creatorName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wordList, creatorName, name);
    }

    // Implement toString and HashCode and setter and getter

}
