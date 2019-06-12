import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestPalindrom {

    List<String> elements = new ArrayList<>();

    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        if (s.length() == 1 || s.equals(new StringBuilder(s).reverse().toString())) {
            return s;
        }

        for (int i = 0; i< s.length(); i++) {
            String firstElem = String.valueOf(s.charAt(i));
            int indexOfNextElement = s.indexOf(firstElem, i + 1);
            if (indexOfNextElement > 0) {
                getValIfPalindrom(firstElem, i, indexOfNextElement, s);
            } else {
                continue;
            }
            if (elements.size() != 0) {
                elements.sort((o1, o2) -> o2.length() - o1.length());
                if (elements.get(0).length() > s.length()/2) {
                    return elements.get(0);
                }
            }

        }
        if (elements.size() == 0) {
            return String.valueOf(s.charAt(0));
        } else {
            elements.sort((o1, o2) -> o2.length() - o1.length());

                return elements.get(0);
        }
    }

    private void getValIfPalindrom(String firstElem, int i, int nextIndex, String s) {
        if (nextIndex >= s.length()) {
            return;
        }
        String sequence = s.substring(i,nextIndex + 1);
        StringBuilder backwardsBuilder  = new StringBuilder(sequence);
        backwardsBuilder.reverse();
        if (sequence.equals(backwardsBuilder.toString())) {
            elements.add(sequence);
            int furtherElemIndex = s.indexOf(firstElem, nextIndex+1);
            if (furtherElemIndex > 0) {
                getValIfPalindrom(firstElem, i, furtherElemIndex, s);
            } else {
                return;
            }

        }
        else if (sequence.length() < s.length() && !elements.isEmpty() && elements.stream().filter(s1 -> sequence.contains(s1)).findFirst().isPresent()) {
            getValIfPalindrom(firstElem, i, nextIndex + 1, s);
        }
        else {
            return;
        }
     }
}
