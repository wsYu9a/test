package com.kwad.library.b.a;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class b extends BaseDexClassLoader {
    private final List<String> alM;
    private final List<String> alN;
    private final ClassLoader alO;

    public b(ClassLoader classLoader, String str, @Nullable File file, String str2, List<String> list, List<String> list2) {
        super(str, file, str2, classLoader);
        this.alO = classLoader;
        this.alM = list;
        this.alN = list2;
        while (classLoader.getParent() != null) {
            classLoader = classLoader.getParent();
        }
        Log.i("PluginClassLoader", "mParent is " + classLoader.getClass().getName());
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public final String findLibrary(String str) {
        String findLibrary = super.findLibrary(str);
        return (TextUtils.isEmpty(findLibrary) && (this.alO instanceof BaseDexClassLoader)) ? ((BaseDexClassLoader) this.alO).findLibrary(str) : findLibrary;
    }

    @Override // java.lang.ClassLoader
    public final Class<?> loadClass(String str, boolean z10) {
        List<String> list = this.alM;
        if (list != null && list.contains(str)) {
            Log.i("PluginClassLoader", "loadClass " + str + " from host by interface");
            return super.loadClass(str, z10);
        }
        List<String> list2 = this.alN;
        if (list2 != null) {
            Iterator<String> it = list2.iterator();
            while (it.hasNext()) {
                if (str.startsWith(it.next() + p1.b.f29697h)) {
                    return super.loadClass(str, z10);
                }
            }
        }
        Class<?> findLoadedClass = findLoadedClass(str);
        if (findLoadedClass != null) {
            return findLoadedClass;
        }
        try {
            return findClass(str);
        } catch (ClassNotFoundException e10) {
            try {
                return getParent().loadClass(str);
            } catch (ClassNotFoundException e11) {
                e11.addSuppressed(e10);
                throw e11;
            }
        }
    }
}
