package com.bytedance.pangle;

import android.os.Build;
import androidx.annotation.Keep;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@Keep
/* loaded from: classes.dex */
public class PluginClassLoader extends BaseDexClassLoader {
    private static final String TAG = "PluginClassLoader";
    private HashSet<String> allPluginClasses;
    private final ClassLoader hostClassLoader;
    private final List<ClassLoader> otherPluginClassLoader;

    public PluginClassLoader(String str, File file, String str2, List<ClassLoader> list) {
        super(str, file, str2, BaseDexClassLoader.getSystemClassLoader().getParent());
        this.hostClassLoader = PluginClassLoader.class.getClassLoader();
        this.otherPluginClassLoader = list;
    }

    private ClassNotFoundException handleException(StringBuilder sb, ClassNotFoundException classNotFoundException, ClassNotFoundException classNotFoundException2) {
        if (classNotFoundException == null) {
            return classNotFoundException2;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            return classNotFoundException;
        }
        sb.append(classNotFoundException2.getCause());
        sb.append("\n");
        return new ClassNotFoundException(sb.toString(), classNotFoundException2);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    protected Class<?> findClass(String str) {
        List<ClassLoader> list;
        HashSet<String> hashSet = this.allPluginClasses;
        Class<?> cls = null;
        if (hashSet == null || hashSet.contains(str)) {
            try {
                cls = super.findClass(str);
                e = null;
            } catch (ClassNotFoundException e2) {
                e = e2;
            }
        } else {
            e = null;
        }
        StringBuilder sb = new StringBuilder("loadClass from :\n");
        if (cls == null && (list = this.otherPluginClassLoader) != null) {
            Iterator<ClassLoader> it = list.iterator();
            while (it.hasNext()) {
                try {
                    cls = it.next().loadClass(str);
                } catch (ClassNotFoundException e3) {
                    e = handleException(sb, e, e3);
                }
            }
        }
        if (cls == null) {
            try {
                cls = this.hostClassLoader.loadClass(str);
            } catch (ClassNotFoundException e4) {
                e = handleException(sb, e, e4);
            }
        }
        if (cls != null) {
            return cls;
        }
        if (e != null) {
            throw e;
        }
        throw new ClassNotFoundException(str + " class not found in PluginClassLoader");
    }

    public void setAllPluginClasses(HashSet<String> hashSet) {
        this.allPluginClasses = hashSet;
    }
}
