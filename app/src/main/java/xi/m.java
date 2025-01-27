package xi;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.FIELD, ElementType.TYPE_USE})
@Documented
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes4.dex */
public @interface m {
    @j
    String resourceBundle();
}
