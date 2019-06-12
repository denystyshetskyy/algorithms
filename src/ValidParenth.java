import java.util.*;

public class ValidParenth {



        public boolean isValid(String s) {
            double length = s.length();
            String openBrackets = "({[";
            if (length / 2 % 1 != 0) {
                return false;
            }
            Deque deque = new ArrayDeque();
            for (int i = 0; i < s.length(); i++) {
                if (openBrackets.contains(String.valueOf(s.charAt(i)))) {
                    deque.push(String.valueOf(s.charAt(i)));
                } else if (!deque.isEmpty() && ((String.valueOf(s.charAt(i))).equals("}") && (deque.peek()).equals("{") || (String.valueOf(s.charAt(i))).equals("]") && (deque.peek()).equals("[") ||
                        (String.valueOf(s.charAt(i))).equals(")") && (deque.peek()).equals("(") )) {
                    deque.pop();
                } else {
                    return false;
                }

            }
            if (!deque.isEmpty()) {
                return false;
            }
            return true;
        }
}
