package wi;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE})
@d("RegExp")
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes4.dex */
public @interface i {
    @xi.j
    String prefix() default "";

    @xi.j
    String suffix() default "";
}
