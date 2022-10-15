package ir.ac.kntu.solution;


import ir.ac.kntu.Language;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Language language;
    private HashMap<Character, ArrayList<String >> listHashMap;

    @Before
    public void setUp() {
        listHashMap = new HashMap<>();
        listHashMap.put('i', new ArrayList<>(Arrays.asList("iman", "Internet")));
        listHashMap.put('b', new ArrayList<>(List.of("book")));
        listHashMap.put('s', new ArrayList<>(List.of("sound")));
    }

    @Test
    public void testConstructor() {
        language = new Language("kntuUni", "java");
        assertEquals("kntuUni", language.getCreatorName());
        assertEquals("java", language.getName());
    }

    @Test
    public void testAddWord() {
        language = new Language("kntuUni", "java");
        language.addWord(listHashMap.get('i').get(0));
        language.addWord(listHashMap.get('b').get(0));
        language.addWord(listHashMap.get('i').get(1));
        language.addWord(listHashMap.get('b').get(0));
        language.addWord(listHashMap.get('s').get(0));
        assertEquals(hashMapToString(listHashMap), hashMapToString(language.getWordList()));
    }

    @Test
    public void testRemoveWord() {
        language = new Language("kntuUni", "java");
        language.setWordList(listHashMap);
        language.removeWord("internet");
        listHashMap.get('i').remove("internet");
        assertEquals(hashMapToString(listHashMap), hashMapToString(language.getWordList()));
        language.removeWord("Internet");
        listHashMap.get('i').remove("Internet");
        assertEquals(hashMapToString(listHashMap), hashMapToString(language.getWordList()));
    }

    @Test
    public void testListOfWordsByChar() throws NoSuchFieldException, IllegalAccessException {
        language = new Language("kntuUni", "java");
        language.setWordList(listHashMap);
        language.removeWord("internet");
        listHashMap.get('i').remove("internet");
        language.removeWord("Internet");
        listHashMap.get('i').remove("Internet");

        Field fieldWordList = Language.class.getDeclaredField("wordList");
        fieldWordList.setAccessible(true);
        HashMap<Character, ArrayList<String>> tmp = (HashMap<Character, ArrayList<String>>) fieldWordList.get(language);

        assertNotSame(tmp.get('i'), language.getListOfWordsByCharacter('i'));
        assertEquals(listHashMap.get('i'), language.getListOfWordsByCharacter('i'));

        assertNotSame(new ArrayList<>(), language.getListOfWordsByCharacter('z'));
        assertEquals(new ArrayList<>(), language.getListOfWordsByCharacter('z'));
    }

    @Test
    public void testCountWords() {
        language = new Language("kntuUni", "java");
        language.setWordList(listHashMap);
        language.removeWord("internet");
        listHashMap.get('i').remove("internet");
        language.removeWord("Internet");
        listHashMap.get('i').remove("Internet");

        assertEquals(3, language.countWords());
    }

    @Test
    public void testContains() {
        language = new Language("kntuUni", "java");
        language.setWordList(listHashMap);
        language.removeWord("internet");
        listHashMap.get('i').remove("internet");
        language.removeWord("Internet");
        listHashMap.get('i').remove("Internet");

        assertFalse(language.contains("salam"));
        assertFalse(language.contains("internet"));
        assertTrue(language.contains("iman"));
    }

    @Test
    public void testSetHashMap() throws NoSuchFieldException, IllegalAccessException {
        language = new Language("kntuUni", "java");
        language.addWord("Ali");
        language.setWordList(listHashMap);
        Field fieldWordList = Language.class.getDeclaredField("wordList");
        fieldWordList.setAccessible(true);
        HashMap<Character, ArrayList<String>> tmp = (HashMap<Character, ArrayList<String>>) fieldWordList.get(language);
        assertNotSame(listHashMap, tmp);
        assertEquals(listHashMap, tmp);
    }

    @Test
    public void testGetHashMap() throws NoSuchFieldException, IllegalAccessException {
        language = new Language("kntuUni", "java");
        language.setWordList(listHashMap);
        Field fieldWordList = Language.class.getDeclaredField("wordList");
        fieldWordList.setAccessible(true);
        HashMap<Character, ArrayList<String>> tmp = (HashMap<Character, ArrayList<String>>) fieldWordList.get(language);
        assertNotSame(tmp, language.getWordList());
        assertEquals(listHashMap, language.getWordList());
    }

    @Test
    public void testFieldsMethods() {
        int fieldsNums = Language.class.getDeclaredFields().length;
        int methodsNums = Language.class.getDeclaredMethods().length;
        assertEquals(3, fieldsNums);
        assertTrue("Not enough method", methodsNums >= 13);
        try {
            Language.class.getDeclaredMethod("equals", Object.class);
            Language.class.getDeclaredMethod("hashCode");
            Language.class.getDeclaredMethod("toString");
        } catch (NoSuchMethodException e) {
            fail("implement toString hashCode and equals");
        }
    }

    public static String[] hashMapToString(HashMap<Character, ArrayList<String>> listHashMap) {
        String[] tmp = new String[listHashMap.size()];
        int i = 0;
        for (char c : listHashMap.keySet()) {
            tmp[i++] = c + "=> " + Arrays.toString(listHashMap.get(c).toArray());
        }
        Arrays.sort(tmp);
        return tmp;
    }
}
