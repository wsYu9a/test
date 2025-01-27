package xi;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* loaded from: classes4.dex */
public final class f {

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.CLASS)
    public @interface a {
        @j
        @wi.d(prefix = "class Renderer{Object[] $childrenArray(){return ", suffix = ";}}", value = "JAVA")
        String childrenArray() default "";

        @j
        @wi.d(prefix = "class Renderer{boolean $hasChildren(){return ", suffix = ";}}", value = "JAVA")
        String hasChildren() default "";

        @j
        @wi.d(prefix = "class Renderer{String $text(){return ", suffix = ";}}", value = "JAVA")
        String text() default "";
    }

    public f() {
        throw new AssertionError("Debug should not be instantiated");
    }
}
