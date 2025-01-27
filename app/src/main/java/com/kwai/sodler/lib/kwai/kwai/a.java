package com.kwai.sodler.lib.kwai.kwai;

import android.app.Activity;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public final class a extends PathClassLoader {
    private static final List<ClassLoader> aKg = new CopyOnWriteArrayList();
    private final BaseDexClassLoader aKf;

    public a(BaseDexClassLoader baseDexClassLoader) {
        super("", baseDexClassLoader);
        this.aKf = baseDexClassLoader;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    protected final Class<?> findClass(String str) {
        Class<?> loadClass;
        Class<?> loadClass2;
        Class<?> cls = null;
        try {
            loadClass2 = this.aKf.loadClass(str);
        } catch (Throwable th) {
            th = th;
        }
        if (Activity.class.isAssignableFrom(loadClass2)) {
            return loadClass2;
        }
        th = null;
        cls = loadClass2;
        if (cls != null) {
            return cls;
        }
        Iterator<ClassLoader> it = aKg.iterator();
        while (it.hasNext()) {
            try {
                loadClass = it.next().loadClass(str);
            } catch (Throwable unused) {
            }
            if (loadClass != null) {
                return loadClass;
            }
        }
        if (th instanceof ClassNotFoundException) {
            throw th;
        }
        throw new ClassNotFoundException(str, th);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public final String findLibrary(String str) {
        return this.aKf.findLibrary(str);
    }

    @Override // java.lang.ClassLoader
    public final URL getResource(String str) {
        return this.aKf.getResource(str);
    }

    @Override // java.lang.ClassLoader
    public final InputStream getResourceAsStream(String str) {
        return this.aKf.getResourceAsStream(str);
    }

    @Override // java.lang.ClassLoader
    public final Enumeration<URL> getResources(String str) {
        return this.aKf.getResources(str);
    }

    @Override // java.lang.ClassLoader
    public final Class<?> loadClass(String str) {
        return findClass(str);
    }

    @Override // dalvik.system.BaseDexClassLoader
    public final String toString() {
        return this.aKf.toString();
    }
}
