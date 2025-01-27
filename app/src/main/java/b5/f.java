package b5;

import javax.annotation.CheckForNull;

@g
@a5.c
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a */
    public static final Double f1253a = Double.valueOf(l5.c.f27899e);

    /* renamed from: b */
    public static final Float f1254b = Float.valueOf(0.0f);

    @CheckForNull
    public static <T> T a(Class<T> cls) {
        u.E(cls);
        if (!cls.isPrimitive()) {
            return null;
        }
        if (cls == Boolean.TYPE) {
            return (T) Boolean.FALSE;
        }
        if (cls == Character.TYPE) {
            return (T) (char) 0;
        }
        if (cls == Byte.TYPE) {
            return (T) (byte) 0;
        }
        if (cls == Short.TYPE) {
            return (T) (short) 0;
        }
        if (cls == Integer.TYPE) {
            return (T) 0;
        }
        if (cls == Long.TYPE) {
            return (T) 0L;
        }
        if (cls == Float.TYPE) {
            return (T) f1254b;
        }
        if (cls == Double.TYPE) {
            return (T) f1253a;
        }
        return null;
    }
}
