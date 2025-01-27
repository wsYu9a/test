package k5;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@p
@a5.a
@a5.c
/* loaded from: classes2.dex */
public final class m implements Closeable {

    /* renamed from: e */
    public static final c f27668e;

    /* renamed from: b */
    @a5.d
    public final c f27669b;

    /* renamed from: c */
    public final Deque<Closeable> f27670c = new ArrayDeque(4);

    /* renamed from: d */
    @CheckForNull
    public Throwable f27671d;

    @a5.d
    public static final class a implements c {

        /* renamed from: a */
        public static final a f27672a = new a();

        @Override // k5.m.c
        public void a(Closeable closeable, Throwable th2, Throwable th3) {
            Logger logger = l.f27667a;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(closeable);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 42);
            sb2.append("Suppressing exception thrown when closing ");
            sb2.append(valueOf);
            logger.log(level, sb2.toString(), th3);
        }
    }

    @a5.d
    public static final class b implements c {

        /* renamed from: a */
        public final Method f27673a;

        public b(Method method) {
            this.f27673a = method;
        }

        @CheckForNull
        public static b b() {
            try {
                return new b(Throwable.class.getMethod("addSuppressed", Throwable.class));
            } catch (Throwable unused) {
                return null;
            }
        }

        @Override // k5.m.c
        public void a(Closeable closeable, Throwable th2, Throwable th3) {
            if (th2 == th3) {
                return;
            }
            try {
                this.f27673a.invoke(th2, th3);
            } catch (Throwable unused) {
                a.f27672a.a(closeable, th2, th3);
            }
        }
    }

    @a5.d
    public interface c {
        void a(Closeable closeable, Throwable th2, Throwable th3);
    }

    static {
        c b10 = b.b();
        if (b10 == null) {
            b10 = a.f27672a;
        }
        f27668e = b10;
    }

    @a5.d
    public m(c cVar) {
        this.f27669b = (c) b5.u.E(cVar);
    }

    public static m a() {
        return new m(f27668e);
    }

    @CanIgnoreReturnValue
    @a0
    public <C extends Closeable> C b(@a0 C c10) {
        if (c10 != null) {
            this.f27670c.addFirst(c10);
        }
        return c10;
    }

    public RuntimeException c(Throwable th2) throws IOException {
        b5.u.E(th2);
        this.f27671d = th2;
        b5.a0.t(th2, IOException.class);
        throw new RuntimeException(th2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Throwable th2 = this.f27671d;
        while (!this.f27670c.isEmpty()) {
            Closeable removeFirst = this.f27670c.removeFirst();
            try {
                removeFirst.close();
            } catch (Throwable th3) {
                if (th2 == null) {
                    th2 = th3;
                } else {
                    this.f27669b.a(removeFirst, th2, th3);
                }
            }
        }
        if (this.f27671d != null || th2 == null) {
            return;
        }
        b5.a0.t(th2, IOException.class);
        throw new AssertionError(th2);
    }

    public <X extends Exception> RuntimeException d(Throwable th2, Class<X> cls) throws IOException, Exception {
        b5.u.E(th2);
        this.f27671d = th2;
        b5.a0.t(th2, IOException.class);
        b5.a0.t(th2, cls);
        throw new RuntimeException(th2);
    }

    public <X1 extends Exception, X2 extends Exception> RuntimeException e(Throwable th2, Class<X1> cls, Class<X2> cls2) throws IOException, Exception, Exception {
        b5.u.E(th2);
        this.f27671d = th2;
        b5.a0.t(th2, IOException.class);
        b5.a0.u(th2, cls, cls2);
        throw new RuntimeException(th2);
    }
}
