package ak;

import java.security.AccessController;
import java.security.PrivilegedAction;

/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f243a = c();

    public static class a implements PrivilegedAction<ClassLoader> {
        @Override // java.security.PrivilegedAction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ClassLoader run() {
            return ClassLoader.getSystemClassLoader();
        }
    }

    public static ClassLoader a() {
        return System.getSecurityManager() == null ? ClassLoader.getSystemClassLoader() : (ClassLoader) AccessController.doPrivileged(new a());
    }

    public static boolean b() {
        return f243a;
    }

    public static boolean c() {
        try {
            Class.forName("android.app.Application", false, a());
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
