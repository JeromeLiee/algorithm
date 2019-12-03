import java.util.HashMap;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.isValid(""));
        System.out.println(test.isValid("a"));
        System.out.println(test.isValid("{}[]()"));
        System.out.println(test.isValid("{}[()]"));
        System.out.println(test.isValid("(]"));
        System.out.println(test.isValid("([)]"));
    }

    private HashMap<Character, Character> hashMap;
    {
        hashMap = new HashMap<>(3);
        hashMap.put(')', '(');
        hashMap.put(']', '[');
        hashMap.put('}', '{');
    }
    // 有效的括号 LeetCode 20
    public boolean isValid(String s) {
        if (s == null || s.equals("")) {
            return true;
        }
        int length = s.length();
        if (length % 2 == 1) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i< length;i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            }else if (stack.peek().equals(hashMap.get(c))) {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}
