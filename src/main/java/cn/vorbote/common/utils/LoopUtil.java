package cn.vorbote.common.utils;

import cn.vorbote.common.entity.LoopEntity;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * This util class supplies some useful loop usage from {@code .Net Core},
 * {@code GoLang}, to make up some disadvantages in java loop.
 *
 * @author vorbote thills@vorbote.cn
 * @since 2.3.0.RELEASE
 */
public class LoopUtil {

    /**
     * This function provides a usage similar to the {@code range} keyword of
     * the <strong>Go</strong> language. By passing in any Collection object
     * you have designed, you can easily obtain the index and data of the
     * data directly in the enhanced for loop of Java.
     *
     * @param collection The collection object which you store the data in.
     * @param <T>        The type of data what the collection stored.
     * @return The index and the datum on the position of this index.
     */
    public static <T> List<LoopEntity<T>> Range(Collection<T> collection) {
        var list = new LinkedList<LoopEntity<T>>();

        var index = 0;
        for (var t : collection) {
            list.add(new LoopEntity<>(index++, t));
        }

        return list;
    }

}
