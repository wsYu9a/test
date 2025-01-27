package l2;

import java.lang.reflect.Type;
import java.util.Date;

/* loaded from: classes.dex */
public final class c implements i, j {
    @Override // l2.j
    public final Object a(Object obj) {
        return Long.valueOf(((Date) obj).getTime());
    }

    @Override // l2.i
    public final Object b(Object obj, Type type) {
        return new Date(((Long) obj).longValue());
    }

    @Override // l2.i, l2.j
    public final boolean a(Class<?> cls) {
        return Date.class.isAssignableFrom(cls);
    }
}
