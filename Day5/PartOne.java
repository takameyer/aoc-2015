import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

// Find strings in a text file that are naughty or nice
// nice string is the following:
// - contains at least three vowels (aeiou)
// - contains at least one letter that appears twice in a row
// - does not contains the string ab, cd, pq, xy

public class PartOne {

    public static final List<Character> VOWELS = List.of('a', 'e', 'i', 'o', 'u');

    public static final String[] FORBIDDEN_STRINGS = { "ab", "cd", "pq", "xy" };

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            String line;
            int niceCount = 0;

            while ((line = reader.readLine()) != null) {
                if (isNice(line))
                    niceCount++;
            }
            System.out.println(niceCount);
            reader.close();

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

    }

    private static boolean isNice(String word) {
        boolean wordContainsThreeVowels = containsThreeVowels(word);
        boolean wordContainsDoubleChar = containsDoubleChar(word);
        boolean wordContainsForbiddenStrings = containsForbiddenStrings(word);

        System.out.println("DEBUG: word: " + word + " {3vowels:" + wordContainsThreeVowels + ", doubleChar: "
                + wordContainsDoubleChar + ", forbiddenStrings: " + wordContainsForbiddenStrings + "}");

        return containsThreeVowels(word) && containsDoubleChar(word) && !containsForbiddenStrings(word);
    }

    private static boolean containsThreeVowels(String word) {
        int vowelCount = 0;

        for (char c : word.toCharArray()) {
            if (VOWELS.contains(c)) {
                if (++vowelCount == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean containsDoubleChar(String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsForbiddenStrings(String word) {
        for (String s : FORBIDDEN_STRINGS) {
            if (word.indexOf(s) > -1) {
                return true;
            }
        }
        return false;
    }
}
