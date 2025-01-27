package p5;

import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@a5.c
@m
/* loaded from: classes2.dex */
public final class n {

    /* renamed from: c */
    public static final Logger f29802c = Logger.getLogger(n.class.getName());

    /* renamed from: a */
    @CheckForNull
    @GuardedBy("this")
    public a f29803a;

    /* renamed from: b */
    @GuardedBy("this")
    public boolean f29804b;

    public static final class a {

        /* renamed from: a */
        public final Runnable f29805a;

        /* renamed from: b */
        public final Executor f29806b;

        /* renamed from: c */
        @CheckForNull
        public a f29807c;

        public a(Runnable runnable, Executor executor, @CheckForNull a aVar) {
            this.f29805a = runnable;
            this.f29806b = executor;
            this.f29807c = aVar;
        }
    }

    public static void c(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            Logger logger = f29802c;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 57 + valueOf2.length());
            sb2.append("RuntimeException while executing runnable ");
            sb2.append(valueOf);
            sb2.append(" with executor ");
            sb2.append(valueOf2);
            logger.log(level, sb2.toString(), (Throwable) e10);
        }
    }

    public void a(Runnable runnable, Executor executor) {
        b5.u.F(runnable, "Runnable was null.");
        b5.u.F(executor, "Executor was null.");
        synchronized (this) {
            try {
                if (this.f29804b) {
                    c(runnable, executor);
                } else {
                    this.f29803a = new a(runnable, executor, this.f29803a);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void b() {
        synchronized (this) {
            try {
                if (this.f29804b) {
                    return;
                }
                this.f29804b = true;
                a aVar = this.f29803a;
                a aVar2 = null;
                this.f29803a = null;
                while (aVar != null) {
                    a aVar3 = aVar.f29807c;
                    aVar.f29807c = aVar2;
                    aVar2 = aVar;
                    aVar = aVar3;
                }
                while (aVar2 != null) {
                    c(aVar2.f29805a, aVar2.f29806b);
                    aVar2 = aVar2.f29807c;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
