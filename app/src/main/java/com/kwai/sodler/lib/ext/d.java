package com.kwai.sodler.lib.ext;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"LongLogTag"})
/* loaded from: classes2.dex */
public final class d {

    static final class a {
        public static void d(ClassLoader classLoader, File file) {
            Object obj = com.kwai.sodler.lib.ext.e.g(classLoader, "pathList").get(classLoader);
            Field g2 = com.kwai.sodler.lib.ext.e.g(obj, "nativeLibraryDirectories");
            File[] fileArr = (File[]) g2.get(obj);
            ArrayList arrayList = new ArrayList();
            for (File file2 : fileArr) {
                if (!file.equals(file2)) {
                    arrayList.add(file2);
                }
            }
            arrayList.add(file);
            g2.set(obj, arrayList.toArray(new File[0]));
        }
    }

    static final class b {
        public static void d(ClassLoader classLoader, File file) {
            Object obj = com.kwai.sodler.lib.ext.e.g(classLoader, "pathList").get(classLoader);
            Field g2 = com.kwai.sodler.lib.ext.e.g(obj, "nativeLibraryDirectories");
            Collection collection = (List) g2.get(obj);
            if (collection == null) {
                collection = new ArrayList(2);
            }
            ArrayList arrayList = new ArrayList(collection);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (file.equals((File) it.next())) {
                    return;
                }
            }
            arrayList.add(file);
            g2.set(obj, arrayList);
            if (g2.get(obj) != arrayList) {
                com.kwai.sodler.lib.ext.e.h(obj, "nativeLibraryDirectories").set(obj, arrayList);
            }
            List list = (List) com.kwai.sodler.lib.ext.e.g(obj, "systemNativeLibraryDirectories").get(obj);
            if (list == null) {
                list = new ArrayList(2);
            }
            ArrayList arrayList2 = new ArrayList(arrayList.size() + list.size() + 1);
            arrayList2.addAll(arrayList);
            arrayList2.addAll(list);
            Object obj2 = (Object[]) com.kwai.sodler.lib.ext.e.b(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList2, null, new ArrayList());
            Field g3 = com.kwai.sodler.lib.ext.e.g(obj, "nativeLibraryPathElements");
            g3.set(obj, obj2);
            if (g3.get(obj) != obj2) {
                com.kwai.sodler.lib.ext.e.h(obj, "nativeLibraryPathElements").set(obj, obj2);
            }
        }
    }

    static final class c {
        public static void d(ClassLoader classLoader, File file) {
            Object obj = com.kwai.sodler.lib.ext.e.g(classLoader, "pathList").get(classLoader);
            List list = (List) com.kwai.sodler.lib.ext.e.g(obj, "nativeLibraryDirectories").get(obj);
            if (list == null) {
                list = new ArrayList(2);
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (file.equals((File) it.next())) {
                    return;
                }
            }
            list.add(file);
            List list2 = (List) com.kwai.sodler.lib.ext.e.g(obj, "systemNativeLibraryDirectories").get(obj);
            if (list2 == null) {
                list2 = new ArrayList(2);
            }
            ArrayList arrayList = new ArrayList(list.size() + list2.size() + 1);
            arrayList.addAll(list);
            arrayList.addAll(list2);
            com.kwai.sodler.lib.ext.e.g(obj, "nativeLibraryPathElements").set(obj, (Object[]) com.kwai.sodler.lib.ext.e.b(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList, null, new ArrayList()));
        }
    }

    /* renamed from: com.kwai.sodler.lib.ext.d$d */
    static final class C0249d {
        public static void d(ClassLoader classLoader, File file) {
            Object obj = com.kwai.sodler.lib.ext.e.g(classLoader, "pathList").get(classLoader);
            List list = (List) com.kwai.sodler.lib.ext.e.g(obj, "nativeLibraryDirectories").get(obj);
            if (list == null) {
                list = new ArrayList(2);
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (file.equals((File) it.next())) {
                    return;
                }
            }
            list.add(file);
            List list2 = (List) com.kwai.sodler.lib.ext.e.g(obj, "systemNativeLibraryDirectories").get(obj);
            if (list2 == null) {
                list2 = new ArrayList(2);
            }
            ArrayList arrayList = new ArrayList(list.size() + list2.size() + 1);
            arrayList.addAll(list);
            arrayList.addAll(list2);
            com.kwai.sodler.lib.ext.e.g(obj, "nativeLibraryPathElements").set(obj, (Object[]) com.kwai.sodler.lib.ext.e.b(obj, "makePathElements", List.class).invoke(obj, arrayList));
        }
    }

    static final class e {
        public static void d(ClassLoader classLoader, File file) {
            String str;
            String path = file.getPath();
            Field g2 = com.kwai.sodler.lib.ext.e.g(classLoader, "libPath");
            String valueOf = String.valueOf(g2.get(classLoader));
            if (TextUtils.isEmpty(valueOf)) {
                str = path;
            } else {
                str = valueOf + ":" + path;
            }
            g2.set(classLoader, str);
            Field g3 = com.kwai.sodler.lib.ext.e.g(classLoader, "libraryPathElements");
            List list = (List) g3.get(classLoader);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (path.equals((String) it.next())) {
                    return;
                }
            }
            list.add(path);
            g3.set(classLoader, list);
        }
    }

    public static synchronized void c(ClassLoader classLoader, File file) {
        synchronized (d.class) {
            if (file != null) {
                if (file.exists()) {
                    int i2 = Build.VERSION.SDK_INT;
                    if ((i2 == 25 && Build.VERSION.PREVIEW_SDK_INT != 0) || i2 > 25) {
                        try {
                            C0249d.d(classLoader, file);
                            return;
                        } catch (Throwable th) {
                            com.kwai.sodler.lib.a.e("Sodler.ShareLibraryLoader", String.format("installNativeLibraryPath, v25 fail, sdk: %d, error: %s, try to fallback to V23", Integer.valueOf(Build.VERSION.SDK_INT), th.getMessage()));
                            b.d(classLoader, file);
                            return;
                        }
                    }
                    if (i2 != 24) {
                        if (i2 >= 23) {
                            try {
                                b.d(classLoader, file);
                                return;
                            } finally {
                                a.d(classLoader, file);
                            }
                        } else {
                            if (i2 >= 14) {
                                a.d(classLoader, file);
                                return;
                            }
                            e.d(classLoader, file);
                        }
                        return;
                    }
                    try {
                        c.d(classLoader, file);
                        return;
                    } finally {
                        a.d(classLoader, file);
                    }
                }
            }
            com.kwai.sodler.lib.a.e("Sodler.ShareLibraryLoader", String.format("installNativeLibraryPath, folder %s is illegal", file));
        }
    }
}
