package easy;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FinalPositionOfSnakeTest {

    public int finalPositionOfSnake(int n, List<String> commands) {
        int i = 0, j = 0;
        for (String command : commands) {
            int[] position = getMove(command);
            i += position[0];
            j += position[1];
        }
        return i * n + j;
    }

    public int[] getMove(String direction) {
        switch (direction) {
            case "UP":
                return new int[] { -1, 0 };
            case "DOWN":
                return new int[] { 1, 0 };
            case "LEFT":
                return new int[] { 0, -1 };
            case "RIGHT":
                return new int[] { 0, 1 };
            default:
                return new int[] { 0, 0 };
        }
    }

    public int finalPositionOfSnake2(int n, List<String> commands) {
        int p = 0;
        for (String command : commands) {
            char c = command.charAt(0);
            p += c == 'U' ? -n : (c == 'R' ? 1 : (c == 'D' ? n : -1));
        }
        return p;
    }

    @Test
    public void test1() {
        List<String> commands = new ArrayList<>(Arrays.asList("RIGHT","DOWN"));
        assertEquals(finalPositionOfSnake2(2, commands), 3);
    }

    @Test
    public void test2() {
        List<String> commands = new ArrayList<>(Arrays.asList("DOWN","RIGHT","UP"));
        assertEquals(finalPositionOfSnake2(3, commands), 1);
    }

}
