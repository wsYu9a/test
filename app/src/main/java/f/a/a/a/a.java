package f.a.a.a;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes.dex */
public @interface a {

    @f.b.a.c
    public static final String k = "The method argument (if parameter was annotated) or this container (if instance method was annotated)";

    @f.b.a.c
    public static final String l = "this";

    @f.b.a.c
    public static final String m = "This container (if the parameter was annotated) or the return value (if instance method was annotated)";

    @f.b.a.c
    public static final String n = "The return value of this method";

    @f.b.a.c
    public static final String o = "this";

    String source() default "The method argument (if parameter was annotated) or this container (if instance method was annotated)";

    boolean sourceIsContainer() default false;

    String target() default "This container (if the parameter was annotated) or the return value (if instance method was annotated)";

    boolean targetIsContainer() default false;
}
