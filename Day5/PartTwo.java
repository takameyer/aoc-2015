import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Find strings in a text file that are naughty or nice
// nice string is the following:
// - contains pairs of letters that appear at least twice 'xyxy' 'aabcdefgaa'
// - contains one letter which repeats with exactly one letter in between them

public class PartTwo {

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
        return containsPairs(word) && containsCharSurround(word);
    }

    private static boolean containsPairs(String word) {
        char[] chars = word.toCharArray();
        List<String> checkedPairs = new ArrayList<>();
        for (int i = 0; i < chars.length - 1; i++) {
            String pair = "" + chars[i] + chars[i + 1];
            if (!checkedPairs.contains(pair)) {
                checkedPairs.add(pair);
                if ((word.split(Pattern.quote(pair), -1).length - 1) >= 2) {
                    System.out.println(word + " contains pairs");
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean containsCharSurround(String word) {
        char[] chars = word.toCharArray();
        List<Character> checkedLetters = new ArrayList<>();
        for (int i = 0; i < chars.length - 1; i++) {
            char c = chars[i];
            if (!checkedLetters.contains(c)) {
                checkedLetters.add(c);
                Pattern pattern = Pattern.compile("" + c + "[a-z]" + c);
                Matcher matcher = pattern.matcher(word);
                if (matcher.find()) {
                    System.out.println(word + " contains char surround");
                    return true;
                }
            }
        }
        return false;
    }
}
