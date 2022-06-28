package kata.jcase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void basicTest2() {
        String characters = "*#";
        String expectedWatchFromSide =
                " # \n" +
                        "***";
        String expectedWatchFromAbove =
                "***\n" +
                        "*#*\n" +
                        "***";
        String actualWatchFromSide = Pyramid.watchPyramidFromTheSide(characters);
        String actualWatchFromAbove = Pyramid.watchPyramidFromAbove(characters);
        visualisation(expectedWatchFromSide, expectedWatchFromAbove, actualWatchFromSide, actualWatchFromAbove);
        assertEquals(9, Pyramid.countVisibleCharactersOfThePyramid(characters));
        assertEquals(10, Pyramid.countAllCharactersOfThePyramid(characters));
    }

    @Test
    public void basicTest3() {
        String characters = "abc";
        String expectedWatchFromSide =
                "  c  \n" +
                        " bbb \n" +
                        "aaaaa";
        String expectedWatchFromAbove =
                "aaaaa\n" +
                        "abbba\n" +
                        "abcba\n" +
                        "abbba\n" +
                        "aaaaa";
        String actualWatchFromSide = Pyramid.watchPyramidFromTheSide(characters);
        String actualWatchFromAbove = Pyramid.watchPyramidFromAbove(characters);
        visualisation(expectedWatchFromSide, expectedWatchFromAbove, actualWatchFromSide, actualWatchFromAbove);
        assertEquals(25, Pyramid.countVisibleCharactersOfThePyramid(characters));
        assertEquals(35, Pyramid.countAllCharactersOfThePyramid(characters));
    }

    @Test
    public void canBuildPyramid() {
        assertEquals(10, Pyramid.getTotalCount("*#"));
        assertEquals(25, Pyramid.countVisibleCharactersOfThePyramid("abc"));
        assertEquals(35, Pyramid.countAllCharactersOfThePyramid("abc"));
    }

    @Test
    public void canBuildRectangle() {
        String characters = "abc";
        String expectedWatchFromAbove =
                "aaaaa\n" +
                        "abbba\n" +
                        "abcba\n" +
                        "abbba\n" +
                        "aaaaa";
        String actualWatchFromAbove = Pyramid.watchPyramidFromAbove(characters);
        assertEquals(expectedWatchFromAbove, actualWatchFromAbove);

    }

    private void visualisation(String expectedWatchFromSide, String expectedWatchFromAbove, String actualWatchFromSide, String actualWatchFromAbove) {
        System.out.println("From side correct:\n" + expectedWatchFromSide);
        System.out.println("From above correct:\n" + expectedWatchFromAbove);
        System.out.println("From side yours:\n" + actualWatchFromSide);
        System.out.println("From above yours:\n" + actualWatchFromAbove);
        assertEquals(expectedWatchFromSide, actualWatchFromSide);
        assertEquals(expectedWatchFromAbove, actualWatchFromAbove);
    }
}
