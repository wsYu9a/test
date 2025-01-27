package b5;

import java.util.Arrays;
import javax.annotation.CheckForNull;

@a5.b
@g
/* loaded from: classes2.dex */
public final class r extends h {
    public static boolean a(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int b(@CheckForNull Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}
