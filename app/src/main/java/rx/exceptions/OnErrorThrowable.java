package rx.exceptions;

import fk.d;
import java.util.HashSet;
import java.util.Set;
import o5.c;
import vj.a;

/* loaded from: classes4.dex */
public final class OnErrorThrowable extends RuntimeException {
    private static final long serialVersionUID = -569558213262703934L;
    private final boolean hasValue;
    private final Object value;

    public static class OnNextValue extends RuntimeException {
        private static final long serialVersionUID = -3454462756050397899L;
        private final Object value;

        public static final class a {

            /* renamed from: a */
            public static final Set<Class<?>> f30453a = a();

            public static Set<Class<?>> a() {
                HashSet hashSet = new HashSet();
                hashSet.add(Boolean.class);
                hashSet.add(Character.class);
                hashSet.add(Byte.class);
                hashSet.add(Short.class);
                hashSet.add(Integer.class);
                hashSet.add(Long.class);
                hashSet.add(Float.class);
                hashSet.add(Double.class);
                return hashSet;
            }
        }

        public OnNextValue(Object obj) {
            super("OnError while emitting onNext value: " + renderValue(obj));
            this.value = obj;
        }

        public static String renderValue(Object obj) {
            if (obj == null) {
                return "null";
            }
            if (a.f30453a.contains(obj.getClass())) {
                return obj.toString();
            }
            if (obj instanceof String) {
                return (String) obj;
            }
            if (obj instanceof Enum) {
                return ((Enum) obj).name();
            }
            String b10 = d.b().a().b(obj);
            if (b10 != null) {
                return b10;
            }
            return obj.getClass().getName() + c.f29046d;
        }

        public Object getValue() {
            return this.value;
        }
    }

    private OnErrorThrowable(Throwable th2) {
        super(th2);
        this.hasValue = false;
        this.value = null;
    }

    public static Throwable addValueAsLastCause(Throwable th2, Object obj) {
        Throwable b10 = a.b(th2);
        if (b10 != null && (b10 instanceof OnNextValue) && ((OnNextValue) b10).getValue() == obj) {
            return th2;
        }
        a.a(th2, new OnNextValue(obj));
        return th2;
    }

    public static OnErrorThrowable from(Throwable th2) {
        Throwable b10 = a.b(th2);
        return b10 instanceof OnNextValue ? new OnErrorThrowable(th2, ((OnNextValue) b10).getValue()) : new OnErrorThrowable(th2);
    }

    public Object getValue() {
        return this.value;
    }

    public boolean isValueNull() {
        return this.hasValue;
    }

    private OnErrorThrowable(Throwable th2, Object obj) {
        super(th2);
        this.hasValue = true;
        this.value = obj;
    }
}
