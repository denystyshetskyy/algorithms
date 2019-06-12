import java.util.*;

public class PhoneNumberParser {
    Map<String, String> phone = new HashMap() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> out = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0 || digits.contains("1")) {
            return out;
        }
        recursionMethod("", 0, 0, digits);
        return out;
    }

    private void recursionMethod(String firstElement, int level, int index, String digits) {
        if (level == digits.length() - 1 && index != phone.get(String.valueOf(digits.charAt(level))).length()) {
            String element = firstElement.concat(String.valueOf(phone.get(String.valueOf(digits.charAt(level))).charAt(index)));
            out.add(element);
            recursionMethod(firstElement, level, index + 1, digits);
        } else if (index == phone.get(String.valueOf(digits.charAt(level))).length()) {
            if (level == 0) {
                return;
            }
            String charsAtLevel = phone.get(String.valueOf(digits.charAt(level - 1)));
            String elementIndex = String.valueOf(firstElement.charAt(level - 1));
            String elementToMaintain = firstElement.substring(0, level - 1);
            int nextIndex = charsAtLevel.indexOf(elementIndex) + 1;
            recursionMethod(elementToMaintain, level - 1, nextIndex, digits);
        } else {
            String element = firstElement.concat(String.valueOf(phone.get(String.valueOf(digits.charAt(level))).charAt(index)));
            recursionMethod(element, level + 1, 0, digits);
        }
    }
}


