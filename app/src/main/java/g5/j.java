package g5;

import b5.u;
import com.google.j2objc.annotations.Weak;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;

@e
/* loaded from: classes2.dex */
public class j {

    /* renamed from: a */
    @Weak
    public f f26141a;

    /* renamed from: b */
    @a5.d
    public final Object f26142b;

    /* renamed from: c */
    public final Method f26143c;

    /* renamed from: d */
    public final Executor f26144d;

    @a5.d
    public static final class b extends j {
        public /* synthetic */ b(f fVar, Object obj, Method method, a aVar) {
            this(fVar, obj, method);
        }

        @Override // g5.j
        public void e(Object obj) throws InvocationTargetException {
            synchronized (this) {
                super.e(obj);
            }
        }

        public b(f fVar, Object obj, Method method) {
            super(fVar, obj, method);
        }
    }

    public /* synthetic */ j(f fVar, Object obj, Method method, a aVar) {
        this(fVar, obj, method);
    }

    public static j c(f fVar, Object obj, Method method) {
        return f(method) ? new j(fVar, obj, method) : new b(fVar, obj, method);
    }

    public static boolean f(Method method) {
        return method.getAnnotation(g5.a.class) != null;
    }

    public final k b(Object obj) {
        return new k(this.f26141a, obj, this.f26142b, this.f26143c);
    }

    public final void d(Object obj) {
        this.f26144d.execute(new Runnable() { // from class: g5.i

            /* renamed from: c */
            public final /* synthetic */ Object f26140c;

            public /* synthetic */ i(Object obj2) {
                obj = obj2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                j.this.g(obj);
            }
        });
    }

    @a5.d
    public void e(Object obj) throws InvocationTargetException {
        try {
            this.f26143c.invoke(this.f26142b, u.E(obj));
        } catch (IllegalAccessException e10) {
            String valueOf = String.valueOf(obj);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 28);
            sb2.append("Method became inaccessible: ");
            sb2.append(valueOf);
            throw new Error(sb2.toString(), e10);
        } catch (IllegalArgumentException e11) {
            String valueOf2 = String.valueOf(obj);
            StringBuilder sb3 = new StringBuilder(valueOf2.length() + 33);
            sb3.append("Method rejected target/argument: ");
            sb3.append(valueOf2);
            throw new Error(sb3.toString(), e11);
        } catch (InvocationTargetException e12) {
            if (!(e12.getCause() instanceof Error)) {
                throw e12;
            }
            throw ((Error) e12.getCause());
        }
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f26142b == jVar.f26142b && this.f26143c.equals(jVar.f26143c);
    }

    public final /* synthetic */ void g(Object obj) {
        try {
            e(obj);
        } catch (InvocationTargetException e10) {
            this.f26141a.b(e10.getCause(), b(obj));
        }
    }

    public final int hashCode() {
        return ((this.f26143c.hashCode() + 31) * 31) + System.identityHashCode(this.f26142b);
    }

    public j(f fVar, Object obj, Method method) {
        this.f26141a = fVar;
        this.f26142b = u.E(obj);
        this.f26143c = method;
        method.setAccessible(true);
        this.f26144d = fVar.a();
    }
}
