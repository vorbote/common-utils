package cn.vorbote.common.utils;

/**
 * This is the string util
 *
 * @author TheodoreHills
 */
public final class StringUtil {

    private StringUtil() {

    }

    /**
     * Check the string is empty
     *
     * @param val The string you want to check
     * @return True while the string is empty, otherwise return false
     */
    public static boolean IsEmpty(String val) {
        return val == null || val.length() == 0;
    }

    /**
     * Check the string is not empty
     *
     * @param val The string you want to check
     * @return True while the string is not empty, otherwise return false
     */
    public static boolean IsNotEmpty(String val) {
        return !IsEmpty(val);
    }

    /**
     * Check the string is blank
     *
     * @param val The string you want to check
     * @return True while the string is blank, otherwise return false.
     * Blank means the string is meaningless, or it only got spaces or tabs in it.
     */
    public static boolean IsBlank(String val) {
        if (val == null) {
            return true;
        }
        val = val.trim();
        return IsEmpty(val);
    }

    /**
     * Format any string using wild card of "{@code {}}"
     *
     * @param format The origin format string.
     * @param args   The args to be put into the string.
     * @return An formatted string.
     */
    public static String Format(String format, Object... args) {
        if (args.length == 0) {
            return format;
        }

        if (Count(format, "{}") != args.length) {
            throw new RuntimeException("");
        }

        int i = 0;
        while (format.contains("{}")) {
            format = format.replaceFirst("\\{}", args[i].toString());
            i++;
        }

        return format;
    }

    /**
     * To count how many times does the substring in the base string.
     *
     * @param base      The original string.
     * @param subString The substring.
     * @return The number of the count.
     */
    public static int Count(String base, String subString) {
        if (subString == null || "".equals(subString)) return 0;
        int count = 0;
        int fromIndex = 0;
        while (true) {
            int index = base.indexOf(subString, fromIndex);
            if (index == -1) break;
            fromIndex = index + 1;
            count++;
        }
        return count;
    }

}
