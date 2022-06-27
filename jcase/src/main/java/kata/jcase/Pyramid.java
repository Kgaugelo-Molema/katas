package kata.jcase;


import wiremock.org.apache.commons.lang3.tuple.ImmutablePair;
import wiremock.org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;

import static java.lang.Math.*;
import static wiremock.com.github.jknack.handlebars.internal.lang3.ArrayUtils.reverse;

public class Pyramid {
    public static String watchPyramidFromTheSide(String characters) {
        var result = "";
        final ArrayList<Pair<String, Integer>> list = Pyramid.getPairs(characters);
        var max = list.stream().mapToInt(Pair::getRight).max();
        System.out.println("max = " + max);
        var maxsqrt = 0;
        if (max.isPresent())
            maxsqrt = (int) sqrt(max.getAsInt());
        for (var ln: list) {
            System.out.println("ln = " + ln);
            var charCount = sqrt(ln.getRight());
            var padding = maxsqrt - charCount;
            System.out.println("padding = " + padding);
            System.out.println("charCount = " + charCount);

            var str = ln.getLeft();
            for (var s = 1; s < charCount; s++) {
                str += ln.getLeft();
            }
            while (padding > 0) {
                str = " " + str + " ";
                padding -= 2;
            }
            result += str;
            if (list.indexOf(ln) < list.size() - 1)
                result += '\n';
            System.out.println("str = " + str);
            System.out.println("result = \n" + result);
        }
        return result;
    }

    public static String watchPyramidFromAbove(String characters) {
        var list = getPairs(characters);
        var topBottomList = new ArrayList<String>();
        for (var ln: list) {
            var topBottom = "";
            var sqrt = sqrt(ln.getRight());
            for (var i = 1; i <= sqrt; i++) {
                topBottom += ln.getLeft();
            }
            topBottomList.add(topBottom);
            var sideToSide = "";
            for (var i = 1; i <= sqrt; i++) {
                sideToSide = ln.getLeft();
                topBottomList.add(sideToSide);
            }
            for (var i = 1; i <= sqrt; i++) {
                sideToSide = ln.getLeft();
                topBottomList.add(sideToSide);
            }
            topBottomList.add(topBottom);
        }
        var result = String.join("\n", topBottomList);
        System.out.println("result = " + result);

        return result;
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
