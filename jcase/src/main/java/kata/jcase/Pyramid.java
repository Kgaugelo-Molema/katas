package kata.jcase;


import wiremock.org.apache.commons.lang3.tuple.ImmutablePair;
import wiremock.org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;

import static java.lang.Math.pow;
import static java.lang.Math.round;
import static wiremock.com.github.jknack.handlebars.internal.lang3.ArrayUtils.reverse;

public class Pyramid {
    public static String watchPyramidFromTheSide(String characters) {
        return null;
    }

    public static String watchPyramidFromAbove(String characters) {
        return null;
    }

    public static int countVisibleCharactersOfThePyramid(String characters) {
        return getVisibleCount(characters);
    }

    public static int countAllCharactersOfThePyramid(String characters) {
        return getTotalCount(characters);
    }

    public static int getLayers(String s) {
        return s.length();
    }

    public static int getTotalCount(String phrase) {
        ArrayList<Pair<String, Integer>> list = getPairs(phrase);
        int total;

        total = list.stream().mapToInt(Pair::getRight).sum();
        return total;
    }

    public static int getVisibleCount(String phrase) {
        ArrayList<Pair<String, Integer>> list = getPairs(phrase);
        int total;

        total = list.stream().mapToInt(Pair::getRight).sum();
        if (list.size() > 1)
            list.remove(list.size() - 1);
        var totalRemaining = list.stream().mapToInt(Pair::getRight).sum();
        return total - totalRemaining;
    }

    private static ArrayList<Pair<String, Integer>> getPairs(String phrase) {
        var list = new ArrayList<Pair<String, Integer>>();
        var total = 0;
        final char[] chars = phrase.toCharArray();
        var index = 1;
        reverse(chars);
        for (var s : chars) {
            var pow = pow(index, 2);
            var pair = new ImmutablePair<>(String.valueOf(s), (int)pow);
            list.add(pair);
            index += 2;
        }
        System.out.println("list = " + list);
        return list;
    }
}
