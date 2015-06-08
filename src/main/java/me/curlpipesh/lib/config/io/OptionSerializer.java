package me.curlpipesh.lib.config.io;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import me.curlpipesh.lib.config.Option;
import me.curlpipesh.lib.config.option.RangeOption;

import java.lang.reflect.Type;

/**
 * @author c
 * @since 6/8/15
 */
public class OptionSerializer<T extends Option<?>> implements JsonSerializer<T> {
    @Override
    public JsonElement serialize(T src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        result.add("name", context.serialize(src.name(), String.class));
        result.add("type", context.serialize(src.getClass().getName(), String.class));
        result.add("currentValue", context.serialize(src.get()));
        if(src instanceof RangeOption<?>) {
            RangeOption<?> r = (RangeOption<?>) src;
            result.add("lowerLimit", context.serialize(r.getLowerLimit()));
            result.add("upperLimit", context.serialize(r.getUpperLimit()));
            result.add("increment", context.serialize(r.getIncrement()));
        }
        return result;
    }
}
