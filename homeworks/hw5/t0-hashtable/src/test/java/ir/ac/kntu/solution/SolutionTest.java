package ir.ac.kntu.solution;

import ir.ac.kntu.HashTable;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class SolutionTest {

    private HashTable hashTable;
    private ArrayList<String> strings;

    @Before
    public void setUp() {
        strings = new ArrayList<>();
        hashTable = new HashTable();

        strings.add("AaAaAaAaAa");
        strings.add("aAaAaAaAaA");
        strings.add("aaaaAAAAaA");

        strings.add("java");
    }

    @Test
    public void setWordTest() {
        String s1 = strings.get(0);
        hashTable.setWord(s1);

        String s2 = strings.get(1);
        hashTable.setWord(s2);

        assertEquals(s1, hashTable.getHashTable()[810].get(0));
        assertEquals(s2, hashTable.getHashTable()[810].get(1));
    }

    @Test
    public void findIndexTest1() {
        hashTable.setWord(strings.get(0));
        hashTable.setWord(strings.get(1));

        int[] indexes = {810, 1};
        assertEquals(indexes[0], hashTable.findIndex(strings.get(1))[0]);
        assertEquals(indexes[1], hashTable.findIndex(strings.get(1))[1]);
    }

    @Test
    public void findIndexTest2() {
        hashTable.setWord(strings.get(0));
        hashTable.setWord(strings.get(1));

        assertNull(hashTable.findIndex(strings.get(2)));
    }

    @Test
    public void findIndexTest3() {
        hashTable.setWord(strings.get(0));
        hashTable.setWord(strings.get(1));

        assertNull(hashTable.findIndex(strings.get(3)));
    }

    @Test
    public void getWordTest() {
        hashTable.setWord(strings.get(0));
        hashTable.setWord(strings.get(1));
        hashTable.setWord(strings.get(2));

        assertEquals(strings.get(1), hashTable.getWord(810, 1));
    }

    @Test
    public void getHashTAbleTest() throws NoSuchFieldException, IllegalAccessException {
        Field wordsField = HashTable.class.getDeclaredField("words");
        wordsField.setAccessible(true);
        ArrayList<String>[] words = (ArrayList<String>[]) wordsField.get(hashTable);
        assertNotSame(words, hashTable.getHashTable());

        for (int i = 0; i < words.length; i++) {
            assertEquals(words[i], hashTable.getHashTable()[i]);
        }
    }

    @Test
    public void encapsulationTest() {
        HashTable instance = new HashTable();
        Class<?> hashTable = instance.getClass();

        Field[] fields = hashTable.getDeclaredFields();
        assertEquals(26, fields[0].getModifiers());
        assertEquals(2, fields[1].getModifiers());
    }
}