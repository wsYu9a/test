package rx.internal.util;

import java.security.AccessController;
import java.security.PrivilegedAction;

/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a */
    private static final boolean f36781a = c();

    static class a implements PrivilegedAction<ClassLoader> {
        a() {
        }

        @Override // java.security.PrivilegedAction
        /* renamed from: a */
        public ClassLoader run() {
            return ClassLoader.getSystemClassLoader();
        }
    }

    static ClassLoader a() {
        return System.getSecurityManager() == null ? ClassLoader.getSystemClassLoader() : (ClassLoader) AccessController.doPrivileged(new a());
    }

    public static boolean b() {
        return f36781a;
    }

    private static boolean c() {
        try {
            Class.forName("android.app.Application", false, a());
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
