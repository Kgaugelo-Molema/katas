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
        return 0;
    }

    public static int countAllCharactersOfThePyramid(String characters) {
        return getArray(characters);
    }

    public static int getLayers(String s) {
        return s.length();
    }

    public static int getTotalCount(String s) {
        var result = 0;
        var count = 0;
        var power = 1;
        for (var c = 0; c < s.length(); c++) {
            if (c == 0)
                continue;
            power += 2;
            System.out.println("c = " + c);
            System.out.println("power = " + power);
            count += c + power;

            System.out.println("count = " + count);
            result += pow(power, 2);
            System.out.println("result = " + result);
        }
        return result;
    }

    public static int getArray(String phrase) {
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

        total = list.stream().mapToInt(Pair::getRight).sum();
        return total;
    }
}
