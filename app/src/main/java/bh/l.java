package bh;

import dalvik.system.DexClassLoader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public final class l extends DexClassLoader {

    /* renamed from: a, reason: collision with root package name */
    public final ClassLoader f1631a;

    /* renamed from: b, reason: collision with root package name */
    public List<ClassLoader> f1632b;

    /* renamed from: c, reason: collision with root package name */
    public HashSet<String> f1633c;

    public l(String str, String str2, String str3) {
        super(str, str2, str3, ClassLoader.getSystemClassLoader().getParent());
        this.f1631a = l.class.getClassLoader();
    }

    public final ClassNotFoundException a(StringBuilder sb2, ClassNotFoundException classNotFoundException, ClassNotFoundException classNotFoundException2) {
        if (classNotFoundException == null) {
            return classNotFoundException2;
        }
        classNotFoundException.addSuppressed(classNotFoundException2);
        return classNotFoundException;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public final Class<?> findClass(String str) {
        List<ClassLoader> list;
        HashSet<String> hashSet = this.f1633c;
        if (hashSet != null && hashSet.contains(str)) {
            return this.f1631a.loadClass(str);
        }
        Class<?> cls = null;
        try {
            e = null;
            cls = super.findClass(str);
        } catch (ClassNotFoundException e10) {
            e = e10;
        }
        StringBuilder sb2 = new StringBuilder("loadClass from :\n");
        if (cls == null && (list = this.f1632b) != null) {
            Iterator<ClassLoader> it = list.iterator();
            while (it.hasNext()) {
                try {
                    cls = it.next().loadClass(str);
                } catch (ClassNotFoundException e11) {
                    e = a(sb2, e, e11);
                }
            }
        }
        if (cls == null) {
            try {
                cls = this.f1631a.loadClass(str);
            } catch (ClassNotFoundException e12) {
                e = a(sb2, e, e12);
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
}
