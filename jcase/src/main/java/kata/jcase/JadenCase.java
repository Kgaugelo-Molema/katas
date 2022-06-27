package kata.jcase;

import wiremock.com.github.jknack.handlebars.internal.text.WordUtils;

import java.util.regex.Pattern;

public class JadenCase {
    public static String toJadenCase(String phrase) {
        if (phrase == null)
            return null;

        if (phrase.isEmpty())
            return null;

        var x= phrase.split(" ");
        var pattern = Pattern.compile("^[a-z]");
        var result = "";
        for (var s: x) {
            var matcher = pattern.matcher(s);
            if (matcher.find()) {
                final String match = matcher.group();
                System.out.println("match = " + match);
                var newStr = s.replace(match, match.toUpperCase());
                System.out.println("s = " + s);
                result += newStr + " ";
            }
        }
        return result.trim();
    }

    public static String toJaden2(String phrase) {
        if(phrase == ""){
            return null;
        }
        else{
            return WordUtils.capitalize(phrase);
        }
    }
}
