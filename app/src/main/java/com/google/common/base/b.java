package com.google.common.base;

import b5.e;
import b5.g;
import b5.t;
import b5.u;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.ServiceConfigurationError;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.annotation.CheckForNull;

@a5.b(emulated = true)
@g
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a */
    public static final Logger f9127a = Logger.getLogger(b.class.getName());

    /* renamed from: b */
    public static final t f9128b = f();

    /* renamed from: com.google.common.base.b$b */
    public static final class C0262b implements t {
        public C0262b() {
        }

        @Override // b5.t
        public e a(String str) {
            return new JdkPattern(Pattern.compile(str));
        }

        @Override // b5.t
        public boolean b() {
            return true;
        }

        public /* synthetic */ C0262b(a aVar) {
            this();
        }
    }

    public static void a() {
    }

    public static e b(String str) {
        u.E(str);
        return f9128b.a(str);
    }

    @CheckForNull
    public static String c(@CheckForNull String str) {
        if (k(str)) {
            return null;
        }
        return str;
    }

    public static String d(double d10) {
        return String.format(Locale.ROOT, "%.4g", Double.valueOf(d10));
    }

    public static <T extends Enum<T>> Optional<T> e(Class<T> cls, String str) {
        WeakReference<? extends Enum<?>> weakReference = Enums.a(cls).get(str);
        return weakReference == null ? Optional.absent() : Optional.of(cls.cast(weakReference.get()));
    }

    public static t f() {
        return new C0262b();
    }

    public static void g(ServiceConfigurationError serviceConfigurationError) {
        f9127a.log(Level.WARNING, "Error loading regex compiler, falling back to next option", (Throwable) serviceConfigurationError);
    }

    public static String h(@CheckForNull String str) {
        return str == null ? "" : str;
    }

    public static boolean i() {
        return f9128b.b();
    }

    public static b5.b j(b5.b bVar) {
        return bVar.K();
    }

    public static boolean k(@CheckForNull String str) {
        return str == null || str.isEmpty();
    }

    public static long l() {
        return System.nanoTime();
    }
}
