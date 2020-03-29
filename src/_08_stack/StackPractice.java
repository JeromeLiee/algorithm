package _08_stack;

import java.util.HashMap;
import java.util.Stack;

public class StackPractice {
    private HashMap<Character, Character> bracketsMap = new HashMap<>(3);

    {
        bracketsMap.put(')', '(');
        bracketsMap.put(']', '[');
        bracketsMap.put('}', '{');
    }

    public static void main(String[] args) {
        StackPractice stackPractice = new StackPractice();
        System.out.println(stackPractice.isValid("(]"));

        MinStack minStack = new MinStack();
        minStack.push(0);  // [-2]
        minStack.push(1);   // [-2, 0]
        minStack.push(0);  // [-2, 0, -1]
        System.out.println(minStack.getMin());  //  [-2, 0, -1], -2
//        System.out.println(minStack.top()); //  [-2, 0, -1], -1
        minStack.pop(); // [-2, 0]
        System.out.println(minStack.getMin()); // [-2, 0], -2

        System.out.println("-------------------------");
        System.out.println(stackPractice.backspaceCompare("ab#c", "ad#c"));
        System.out.println(stackPractice.backspaceCompare("ab##", "c#d#"));
        System.out.println(stackPractice.backspaceCompare("a##c", "#a#c"));
        System.out.println(stackPractice.backspaceCompare("a#c", "b"));
    }

    /**
     * 1. 有效的括号
     * <p>
     * LeetCode 20
     * <p>
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "()"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: "()[]{}"
     * 输出: true
     * 示例 3:
     * <p>
     * 输入: "(]"
     * 输出: false
     * 示例 4:
     * <p>
     * 输入: "([)]"
     * 输出: false
     * 示例 5:
     * <p>
     * 输入: "{[]}"
     * 输出: true
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null) return false;
        int length = s.length();
        if (length == 0) return true;
        if (length % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == bracketsMap.get(c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    /**
     * 3. 比较含退格的字符串
     * <p>
     * LeetCode 844
     * <p>
     * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：S = "ab#c", T = "ad#c"
     * 输出：true
     * 解释：S 和 T 都会变成 “ac”。
     * 示例 2：
     * <p>
     * 输入：S = "ab##", T = "c#d#"
     * 输出：true
     * 解释：S 和 T 都会变成 “”。
     * 示例 3：
     * <p>
     * 输入：S = "a##c", T = "#a#c"
     * 输出：true
     * 解释：S 和 T 都会变成 “c”。
     * 示例 4：
     * <p>
     * 输入：S = "a#c", T = "b"
     * 输出：false
     * 解释：S 会变成 “c”，但 T 仍然是 “b”。
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= S.length <= 200
     * 1 <= T.length <= 200
     * S 和 T 只含有小写字母以及字符 '#'。
     *
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare(String S, String T) {
        int sLength = S.length();
        int tLength = T.length();
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();

        for (int i = 0; i < sLength; i++) {
            char c = S.charAt(i);
            if (c == '#') {
                if (!sStack.isEmpty()) {
                    sStack.pop();
                }
            } else {
                sStack.push(c);
            }
        }

        for (int i = 0; i < tLength; i++) {
            char c = T.charAt(i);
            if (c == '#') {
                if (!tStack.isEmpty()) {
                    tStack.pop();
                }
            } else {
                tStack.push(c);
            }
        }
        if (sStack.size() != tStack.size()) {
            return false;
        }

        while (!sStack.isEmpty() && !tStack.isEmpty()) {
            char sPop = sStack.pop();
            char tPop = tStack.pop();
            if (sPop != tPop) {
                return false;
            }
        }
        return true;
    }

    /**
     * 5. 基本计算器
     * <p>
     * LeetCode 224
     * <p>
     * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
     * <p>
     * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "1 + 1"
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: " 2-1 + 2 "
     * 输出: 3
     * 示例 3:
     * <p>
     * 输入: "(1+(4+5+2)-3)+(6+8)"
     * 输出: 23
     * 说明：
     * <p>
     * 你可以假设所给定的表达式都是有效的。
     * 请不要使用内置的库函数 eval。
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        return 0;
    }

    /**
     * 6. 下一个更大元素
     * <p>
     * LeetCode 496
     * <p>
     * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
     * <p>
     * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
     * 输出: [-1,3,-1]
     * 解释:
     * 对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
     * 对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
     * 对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
     * 示例 2:
     * <p>
     * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
     * 输出: [3,-1]
     * 解释:
     *     对于num1中的数字2，第二个数组中的下一个较大数字是3。
     * 对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
     * 注意:
     * <p>
     * nums1和nums2中所有元素是唯一的。
     * nums1和nums2 的数组大小都不超过1000。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        return nums1;
    }

    /**
     * 7. 栈的压入、弹出序列（验证栈顺序）
     *
     * LeetCode 面试题31
     *
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
     * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
     *  
     * 示例 1：
     *
     * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
     * 输出：true
     * 解释：我们可以按以下顺序执行：
     * push(1), push(2), push(3), push(4), pop() -> 4,
     * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
     *
     * 示例 2：
     *
     * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
     * 输出：false
     * 解释：1 不能在 2 之前弹出。
     *
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null || pushed.length != popped.length) return false;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && index < pushed.length && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }


}
