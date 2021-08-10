package cn.vorbote.common.utils;

import cn.vorbote.time.DateTime;

/**
 * Time util.
 *
 * @author vorbote thills@vorbote.cn
 */
public class TimeUtil {

    /**
     * Convert timestamp to {@code DateTime}.
     *
     * @param timestamp Timestamp.
     * @return {@code DateTime} instance.
     */
    public static DateTime FromTimestamp(long timestamp) {
        return new DateTime(timestamp);
    }

    /**
     * Convert {@code DateTime} instance to timestamp.
     *
     * @param dateTime {@code DateTime} instance.
     * @return {@code DateTime} instance.
     */
    public static long ToTimestamp(DateTime dateTime) {
        return dateTime.Timestamp();
    }

    /**
     * Convert {@code DateTime} instance to unix timestamp.
     *
     * @param dateTime {@code DateTime} instance.
     * @return {@code DateTime} instance.
     */
    public static long Unix(DateTime dateTime) {
        return dateTime.Timestamp() / 1000;
    }

}
