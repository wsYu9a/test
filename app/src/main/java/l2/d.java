package l2;

import java.lang.reflect.Type;

/* loaded from: classes.dex */
public final class d implements i, j {
    @Override // l2.j
    public final Object a(Object obj) {
        return ((Enum) obj).name();
    }

    @Override // l2.i
    public final Object b(Object obj, Type type) {
        return Enum.valueOf((Class) type, obj.toString());
    }

    @Override // l2.i, l2.j
    public final boolean a(Class<?> cls) {
        return Enum.class.isAssignableFrom(cls);
    }
}
