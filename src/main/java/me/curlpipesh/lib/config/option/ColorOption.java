package me.curlpipesh.lib.config.option;

/**
 * Option for storing a color. Colors need to be passed in using the
 * <tt>0xAARRGGBB</tt> format.
 *
 * @author c
 * @since 6/1/15
 */
public class ColorOption extends NumberOption<Integer> {
    public ColorOption(String name, Integer defaultValue) {
        super(name, defaultValue);
    }

    @Override
    public Class<Integer> getNumberType() {
        return Integer.class;
    }

    @Override
    public void set(String string) {
        try {
            set(Integer.decode(string));
        } catch(Exception e) {
            try {
                set(Integer.parseInt(string.replaceFirst("0x", ""), 16));
            } catch(Exception e1) {
                set(Integer.parseInt(string.replaceFirst("0x", "")));
            }
        }
    }
}
