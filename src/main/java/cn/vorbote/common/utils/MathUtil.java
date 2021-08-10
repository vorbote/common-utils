package cn.vorbote.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.Stack;

/**
 * This util class can make some formal calculation.
 */
@Slf4j
public final class MathUtil {

    private MathUtil() {

    }

    /**
     * Calc the factorial of n
     *
     * @param n The number N should greater or equal to 0
     * @return The result of factorial n
     * @throws RuntimeException The n should greater or equal to 0
     */
    public static long Factorial(int n) {
        if (n < 0) throw new RuntimeException("A number lower than 0 has no factorial result");
        if (n <= 1) return 1L;
        else return n * Factorial(n - 1);
    }

    /**
     * Get the sum of the numbers
     *
     * @param numbers The numbers
     * @return The sum value of the numbers
     */
    public static double Sum(Collection<? extends Number> numbers) {
        double sum = 0;
        for (Number number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }

    /**
     * Get the average value of the numbers
     *
     * @param numbers The numbers
     * @return The average value of the numbers
     */
    public static double Average(Collection<? extends Number> numbers) {
        double sum = Sum(numbers);
        log.debug("sum = {}, size = {}", sum, numbers.size());
        return sum / numbers.size();
    }

    /**
     * Check the num whether is between the noLess and noGreater number
     *
     * @param num       The number
     * @param noLess    The <code>num</code> should not less than this number.
     * @param noGreater The <code>num</code> should not bigger than this number.
     * @return True while num no less than noLess and num no graeter than noGreater.
     */
    public static boolean IsBetween(Number num, Number noLess, Number noGreater) {
        return num.doubleValue() <= noGreater.doubleValue() &&
                num.doubleValue() >= noLess.doubleValue();
    }

    /**
     * Check the num whether is not between the noLess and noGreater number
     *
     * @param num       The number
     * @param noLess    The <code>num</code> should not less than this number.
     * @param noGreater The <code>num</code> should not bigger than this number.
     * @return True while num no less than noLess and num no graeter than noGreater.
     */
    public static boolean IsNotBetween(Number num, Number noLess, Number noGreater) {
        return !IsBetween(num, noLess, noGreater);
    }

    /**
     * Transformat a decimal number to hex number.
     *
     * @param value   The number with decimal format.
     * @param toUpper To specify will it be transformatted to Upper case.
     *                Default in lower case.
     * @return The hex string of the number.
     */
    public static String ToHexString(int value, boolean toUpper) {
        Stack<String> stack = new Stack<>();
        for (; value != 0; value /= 16) {
            int temp = value % 16;
            switch (temp) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    stack.push(String.valueOf(temp));
                    break;
                case 10:
                    stack.push("a");
                    break;
                case 11:
                    stack.push("b");
                    break;
                case 12:
                    stack.push("c");
                    break;
                case 13:
                    stack.push("d");
                    break;
                case 14:
                    stack.push("e");
                    break;
                case 15:
                    stack.push("f");
                    break;
            }
        }
        StringBuilder builder = new StringBuilder("0x");
        while (!stack.isEmpty()) {
            var e = stack.pop();
            builder.append(e);
        }
        if (toUpper) {
            return builder.toString().toUpperCase();
        } else {
            return builder.toString();
        }
    }

    /**
     * Transformat a decimal number to binary number.
     *
     * @param value   The number with decimal format.
     * @return The binary string of the number.
     */
    public static String ToBinaryString(int value) {
        Stack<String> stack = new Stack<>();
        for (; value != 0; value /= 2) {
            int temp = value % 2;
            stack.push(String.valueOf(temp));
        }
        StringBuilder builder = new StringBuilder("0b");
        while (!stack.isEmpty()) {
            var e = stack.pop();
            builder.append(e);
        }
        return builder.toString();
    }

    /**
     * Transformat a decimal number to octal number.
     *
     * @param value   The number with decimal format.
     * @return The octal string of the number.
     */
    public static String ToOctalString(int value) {
        Stack<String> stack = new Stack<>();
        for (; value != 0; value /= 8) {
            int temp = value % 8;
            stack.push(String.valueOf(temp));
        }
        StringBuilder builder = new StringBuilder("0");
        while (!stack.isEmpty()) {
            var e = stack.pop();
            builder.append(e);
        }
        return builder.toString();
    }
}
