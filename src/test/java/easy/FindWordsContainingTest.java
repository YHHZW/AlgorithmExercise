package easy;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindWordsContainingTest {

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0, len = words.length; i < len; i++) {
            if (words[i].indexOf(x) != -1) {
                result.add(i);
            }
        }
        return result;
    }


    @Test
    public void test1() {
        String[] words = { "leet", "code" };
        List<Integer> target = findWordsContaining(words, 'e');
        List<Integer> result = new ArrayList<>(Arrays.asList(0, 1));
        assertArrayEquals(target.toArray(), result.toArray());
    }

    @Test
    public void test2() {
        String[] words = { "abc", "bcd", "aaaa", "cbc" };
        List<Integer> target = findWordsContaining(words, 'a');
        List<Integer> result = new ArrayList<>(Arrays.asList(0, 2));
        assertArrayEquals(target.toArray(), result.toArray());
    }

    @Test
    public void test3() {
        String[] words = { "abc", "bcd", "aaaa", "cbc" };
        List<Integer> target = findWordsContaining(words, 'z');
        List<Integer> result = new ArrayList<>(List.of());
        assertArrayEquals(target.toArray(), result.toArray());
    }

}
