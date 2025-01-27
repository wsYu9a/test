package wi;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes4.dex */
public @interface e {
    long[] flags() default {};

    Class<?> flagsFromClass() default void.class;

    long[] intValues() default {};

    @xi.j
    String[] stringValues() default {};

    Class<?> valuesFromClass() default void.class;
}
