package com.kwai.sodler.lib.kwai.kwai;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class b extends BaseDexClassLoader {
    private final List<String> aKh;
    private final List<String> aKi;
    private final ClassLoader aKj;

    public b(ClassLoader classLoader, String str, @Nullable File file, String str2, List<String> list, List<String> list2) {
        super(str, file, str2, classLoader);
        this.aKj = classLoader;
        this.aKh = list;
        this.aKi = list2;
        while (classLoader.getParent() != null) {
            classLoader = classLoader.getParent();
        }
        Log.i("PluginClassLoader", "mParent is " + classLoader.getClass().getName());
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public final String findLibrary(String str) {
        String findLibrary = super.findLibrary(str);
        if (!TextUtils.isEmpty(findLibrary) || !(this.aKj instanceof BaseDexClassLoader)) {
            return findLibrary;
        }
        StringBuilder sb = new StringBuilder("load so ");
        sb.append(str);
        sb.append(" from parent");
        return ((BaseDexClassLoader) this.aKj).findLibrary(str);
    }

    @Override // java.lang.ClassLoader
    protected final Class<?> loadClass(String str, boolean z) {
        List<String> list = this.aKh;
        if (list != null && list.contains(str)) {
            Log.i("PluginClassLoader", "loadClass " + str + " from host by interface");
            return super.loadClass(str, z);
        }
        List<String> list2 = this.aKi;
        if (list2 != null) {
            Iterator<String> it = list2.iterator();
            while (it.hasNext()) {
                if (str.startsWith(it.next() + ".")) {
                    return super.loadClass(str, z);
                }
            }
        }
        Class<?> findLoadedClass = findLoadedClass(str);
        if (findLoadedClass != null) {
            return findLoadedClass;
        }
        try {
            try {
                return findClass(str);
            } catch (ClassNotFoundException e2) {
                int i2 = Build.VERSION.SDK_INT;
                throw e2;
            }
        } catch (ClassNotFoundException unused) {
            return getParent().loadClass(str);
        }
    }
}
