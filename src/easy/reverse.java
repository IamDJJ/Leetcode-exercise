package easy;

/**
 * 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *
 *  示例 2:
 * 输入: -123
 * 输出: -321
 *
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0
 */
public class reverse {

    //解法一：转换成char，再反方向遍历
    public static int reverse(int x) {
        if(x == 0) {
            return 0;
        }
        //判断加入数字是否过大
        char[] xChar = new Integer(x).toString().toCharArray();
        StringBuilder newX = new StringBuilder();
        //把正负号去掉
        int index = 0;
        while(xChar[index] < '0' || xChar[index] > '9') {
            newX.append(xChar[index]);
            index ++;
        }
        //哨兵，确认首数字不为0
        boolean zeroFlag = false;
        for(int i = xChar.length - 1; i >= index; i--) {
            //若首数字为0，则直接去掉
            if(xChar[i] == '0' && !zeroFlag) {
                continue;
            }
            newX.append(xChar[i]);
            zeroFlag = true;
        }
        //判断最终反转数字不超出阈值
        long result = new Long(newX.toString()).longValue();
        if(result > (long)Math.pow(2, 31) - 1 || result < -(long)Math.pow(2, 31)) {
            return 0;
        }
        return new Integer(newX.toString()).intValue();
    }

    //解法二：除以10获取先对应的数字，作为头部乘以10
    public static int reverse2(int x) {
        if(x == 0) {
            return 0;
        }
        long result = 0;
        while(x != 0) {
            result = result * 10 + (x % 10);
            x = x / 10;
        }
        if(result > (long)Math.pow(2, 31) - 1 || result < -(long)Math.pow(2, 31)) {
            return 0;
        }
        return (int)result;
    }

    public static void main(String[] args) {
        //int 最大值 2147483647, 2的
//        System.out.println(reverse(123));
        System.out.println(reverse2(-123));
    }
}
