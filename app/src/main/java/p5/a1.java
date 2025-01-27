package p5;

import java.lang.Thread;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

@a5.c
@m
/* loaded from: classes2.dex */
public final class a1 {

    @a5.d
    public static final class a implements Thread.UncaughtExceptionHandler {

        /* renamed from: b */
        public static final Logger f29777b = Logger.getLogger(a.class.getName());

        /* renamed from: a */
        public final Runtime f29778a;

        public a(Runtime runtime) {
            this.f29778a = runtime;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th2) {
            try {
                f29777b.log(Level.SEVERE, String.format(Locale.ROOT, "Caught an exception in %s.  Shutting down.", thread), th2);
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    public static Thread.UncaughtExceptionHandler a() {
        return new a(Runtime.getRuntime());
    }
}
