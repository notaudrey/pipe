package me.curlpipesh.lib.config.option;

import lombok.Getter;
import lombok.Setter;

/**
 * A {@link NumberOption} that is constrained to a certain range
 *
 * @author c
 * @since 5/24/15
 */
public class RangeOption<T extends Number> extends NumberOption<T> {
    /**
     * The upper limit of values for this option
     */
    @Getter
    @Setter
    private T upperLimit;

    /**
     * The lower limit of values for this option
     */
    @Getter
    @Setter
    private T lowerLimit;

    /**
     * The increment value for this option
     */
    @Getter
    @Setter
    private T increment;

    /**
     * Creates a new RangeOption
     *
     * @param name The name of this option
     * @param defaultValue The starting value for this option
     * @param upperLimit The upper limit of values for this option
     * @param lowerLimit The lower limit of values for this option
     * @param increment The increment value for this option
     */
    public RangeOption(String name, T defaultValue, T upperLimit, T lowerLimit, T increment) {
        super(name, defaultValue);
        this.upperLimit = upperLimit;
        this.lowerLimit = lowerLimit;
    }

    @Override
    public T get() {
        return super.get();
    }

    @Override
    public void set(T t) {
        if(t.doubleValue() < lowerLimit.doubleValue()) {
            super.set(lowerLimit);
        } else if(t.doubleValue() > upperLimit.doubleValue()) {
            super.set(upperLimit);
        } else {
            super.set(t);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public Class<T> getNumberType() {
        return (Class<T>) this.lowerLimit.getClass();
    }
}
