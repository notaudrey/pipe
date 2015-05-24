package me.curlpipesh.lib.config.option;

import lombok.Getter;
import lombok.Setter;

/**
 * @author audrey
 * @since 5/24/15
 */
public class RangeOption<T extends Number> extends NumberOption<T> {
    @Getter
    @Setter
    private T upperLimit;

    @Getter
    @Setter
    private T lowerLimit;

    @Getter
    @Setter
    private T increment;

    public RangeOption(String name, T defaultValue, T upperLimit, T lowerLimit, T increment) {
        super(name, defaultValue);
        this.upperLimit = upperLimit;
        this.lowerLimit = lowerLimit;
    }

    public T get() {
        return super.get();
    }

    public void set(T t) {
        if(t.doubleValue() < lowerLimit.doubleValue()) {
            super.set(lowerLimit);
        } else if(t.doubleValue() > upperLimit.doubleValue()) {
            super.set(upperLimit);
        } else {
            super.set(t);
        }
    }
}
