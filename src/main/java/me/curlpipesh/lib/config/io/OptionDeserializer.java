package me.curlpipesh.lib.config.io;

import com.google.gson.*;
import me.curlpipesh.lib.config.Option;
import me.curlpipesh.lib.config.option.BasicOption;
import me.curlpipesh.lib.config.option.RangeOption;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

/**
 * @author c
 * @since 6/8/15
 */
public class OptionDeserializer<T extends Option<?>> implements JsonDeserializer<T> {
    @Override
    public T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject result = json.getAsJsonObject();
        String name = result.get("name").getAsString();
        String type = result.get("type").getAsString();
        String currentValue = result.get("currentValue").getAsString();
        if(type.equals(RangeOption.class.getName())) {
            throw new UnsupportedOperationException("Not able to deserialize `RangeOption<T>' yet!");
        } else {
            try {
                Class<?> o = Class.<T>forName(type);
                if(BasicOption.class.isAssignableFrom(o)) {
                    try {
                        o.asSubclass(BasicOption.class).getDeclaredConstructor(String.class, Object.class).newInstance(name, currentValue);
                    } catch(NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                } else {
                    throw new UnsupportedOperationException("Options that don't extends `BasicOption<T>' aren't " +
                            "supported for serialization yet!");
                }
            } catch(ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
