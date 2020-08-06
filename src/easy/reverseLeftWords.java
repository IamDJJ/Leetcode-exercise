package easy;

//左旋转字符串

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 */


public class reverseLeftWords {

    public static String reverseLeft(String s, int n) {
        if(s.length() > 10000 || n > s.length()) {
            return "";
        }
        StringBuilder head = new StringBuilder();
        StringBuilder tail = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(i <= n -1) {
                head.append(s.charAt(i));
            } else {
                tail.append(s.charAt(i));
            }
        }

        return tail.append(head.toString()).toString();
    }

    public static void main(String[] args) {
        String result = reverseLeft("applestore", 4);
        System.out.println(result);
    }
}
