package Annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
public @interface JsonProperty {
    String name() default "";
    boolean ignoreIfNull() default false;
}
