package o5;

import b5.u;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@d
/* loaded from: classes2.dex */
public abstract class k<T> {
    public final Type capture() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        u.u(genericSuperclass instanceof ParameterizedType, "%s isn't parameterized", genericSuperclass);
        return ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
    }
}
