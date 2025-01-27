package o5;

import com.google.common.collect.Sets;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Set;

@d
/* loaded from: classes2.dex */
public abstract class o {

    /* renamed from: a */
    public final Set<Type> f29064a = Sets.u();

    public final void a(Type... typeArr) {
        for (Type type : typeArr) {
            if (type != null && this.f29064a.add(type)) {
                try {
                    if (type instanceof TypeVariable) {
                        e((TypeVariable) type);
                    } else if (type instanceof WildcardType) {
                        f((WildcardType) type);
                    } else if (type instanceof ParameterizedType) {
                        d((ParameterizedType) type);
                    } else if (type instanceof Class) {
                        b((Class) type);
                    } else {
                        if (!(type instanceof GenericArrayType)) {
                            String valueOf = String.valueOf(type);
                            StringBuilder sb2 = new StringBuilder(valueOf.length() + 14);
                            sb2.append("Unknown type: ");
                            sb2.append(valueOf);
                            throw new AssertionError(sb2.toString());
                        }
                        c((GenericArrayType) type);
                    }
                } catch (Throwable th2) {
                    this.f29064a.remove(type);
                    throw th2;
                }
            }
        }
    }

    public void b(Class<?> cls) {
    }

    public void c(GenericArrayType genericArrayType) {
    }

    public void d(ParameterizedType parameterizedType) {
    }

    public void e(TypeVariable<?> typeVariable) {
    }

    public void f(WildcardType wildcardType) {
    }
}
