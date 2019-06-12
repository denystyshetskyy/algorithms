import java.util.ArrayList;
import java.util.List;

public class LongestPalindromV2 {

    List<String> elements = new ArrayList<>();

    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }

        for (int i = 0; i< s.length(); i++) {
            getValIfPalindrom(i, i + 1, s);
        }
    if (elements.size() == 0) {
        return String.valueOf(s.charAt(0));
    } else {
        elements.sort((o1, o2) -> o2.length() - o1.length());
        return elements.get(0);
    }
    }

    private void getValIfPalindrom(int start, int i, String s) {
        String sequence = s.substring(start, i++);
        StringBuilder backwardsBuilder  = new StringBuilder(sequence);
        backwardsBuilder.reverse();
        if (sequence.equals(backwardsBuilder.toString())) {
            elements.add(sequence);
        }
        if (i > s.length()) {
            return;
        }
        getValIfPalindrom(start, i++, s);

    }
}
