package Annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
public @interface JsonProperty {
    String Name() default "";
    boolean IgnoreIfNull() default false;
}
