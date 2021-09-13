package cn.vorbote.common.entity;

/**
 * Because of {@code java} can not return two data instance at the same time,
 * we use a class to replace it.
 *
 * @param <T> The type of the data.
 * @author vorbote thills@vorbote.cn
 * @since 2.3.0.RELEASE
 */
public class LoopEntity<T> {
    private int index;
    private T value;

    public LoopEntity() {
    }

    public LoopEntity(int index, T value) {
        this.index = index;
        this.value = value;
    }

    public int Index() {
        return index;
    }

    public LoopEntity<T> Index(int index) {
        this.index = index;
        return this;
    }

    public T Value() {
        return value;
    }

    public LoopEntity<T> Value(T value) {
        this.value = value;
        return this;
    }

    @Deprecated
    public int getIndex() {
        return index;
    }

    @Deprecated
    public void setIndex(int index) {
        this.index = index;
    }

    @Deprecated
    public T getValue() {
        return value;
    }

    @Deprecated
    public void setValue(T value) {
        this.value = value;
    }
}
