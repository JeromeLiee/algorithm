package _41_string;

public class StringTest {
    public static void main(String[] args) {
        StringTest stringTest = new StringTest();
        String str = "We are happy.";
        System.out.println(stringTest.replaceSpace(str));
    }

    /**
     * 1. 空格替换
     *
     * @param str
     * @return
     */
    public String replaceSpace(String str) {
        if (str == null || str.length() == 0) return str;
        StringBuilder stringBuilder = new StringBuilder(str);
        int index1 = str.length() - 1;
        for (int i = 0; i <= index1; i++) {
            if (str.charAt(i) == ' ') {
                stringBuilder.append("  ");
            }
        }
        int index2 = stringBuilder.length() - 1;
        while (index1 >= 0 && index2 >= 0) {
            char c = str.charAt(index1--);
            if (c == ' ') {
                stringBuilder.setCharAt(index2--, '%');
                stringBuilder.setCharAt(index2--, '0');
                stringBuilder.setCharAt(index2--, '2');
            } else {
                stringBuilder.setCharAt(index2--, c);
            }
        }
        return stringBuilder.toString();
    }
}
