package me.curlpipesh.lib.plugin.loading;

import java.lang.annotation.*;

/**
 * @author c
 * @since 5/27/15
 */
@Inherited
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Load {
    LoadPriority priority() default LoadPriority.NONE;
}
