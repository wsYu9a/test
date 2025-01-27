package o5;

import b5.u;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import javax.annotation.CheckForNull;

@d
/* loaded from: classes2.dex */
public abstract class l<T> extends k<T> {

    /* renamed from: b */
    public final TypeVariable<?> f29063b;

    public l() {
        Type capture = capture();
        u.u(capture instanceof TypeVariable, "%s should be a type variable.", capture);
        this.f29063b = (TypeVariable) capture;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof l) {
            return this.f29063b.equals(((l) obj).f29063b);
        }
        return false;
    }

    public final int hashCode() {
        return this.f29063b.hashCode();
    }

    public String toString() {
        return this.f29063b.toString();
    }
}
