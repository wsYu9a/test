package com.kuaishou.weapon.p0;

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
/* loaded from: classes.dex */
public class dn {

    static final class a {
        private a() {
        }

        public static void b(ClassLoader classLoader, File file) {
            Object obj = dp.a(classLoader, "pathList").get(classLoader);
            Field a2 = dp.a(obj, "nativeLibraryDirectories");
            File[] fileArr = (File[]) a2.get(obj);
            ArrayList arrayList = new ArrayList();
            for (File file2 : fileArr) {
                if (!file.equals(file2)) {
                    arrayList.add(file2);
                }
            }
            arrayList.add(file);
            a2.set(obj, arrayList.toArray(new File[0]));
        }
    }

    static final class b {
        private b() {
        }

        public static void b(ClassLoader classLoader, File file) {
            Object obj = dp.a(classLoader, "pathList").get(classLoader);
            Field a2 = dp.a(obj, "nativeLibraryDirectories");
            Collection collection = (List) a2.get(obj);
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
            a2.set(obj, arrayList);
            if (a2.get(obj) != arrayList) {
                dp.b(obj, "nativeLibraryDirectories").set(obj, arrayList);
            }
            List list = (List) dp.a(obj, "systemNativeLibraryDirectories").get(obj);
            if (list == null) {
                list = new ArrayList(2);
            }
            ArrayList arrayList2 = new ArrayList(arrayList.size() + list.size() + 1);
            arrayList2.addAll(arrayList);
            arrayList2.addAll(list);
            Object obj2 = (Object[]) dp.a(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList2, null, new ArrayList());
            Field a3 = dp.a(obj, "nativeLibraryPathElements");
            a3.set(obj, obj2);
            if (a3.get(obj) != obj2) {
                dp.b(obj, "nativeLibraryPathElements").set(obj, obj2);
            }
        }
    }

    static final class c {
        private c() {
        }

        public static void b(ClassLoader classLoader, File file) {
            Object obj = dp.a(classLoader, "pathList").get(classLoader);
            List list = (List) dp.a(obj, "nativeLibraryDirectories").get(obj);
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
            List list2 = (List) dp.a(obj, "systemNativeLibraryDirectories").get(obj);
            if (list2 == null) {
                list2 = new ArrayList(2);
            }
            ArrayList arrayList = new ArrayList(list.size() + list2.size() + 1);
            arrayList.addAll(list);
            arrayList.addAll(list2);
            dp.a(obj, "nativeLibraryPathElements").set(obj, (Object[]) dp.a(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList, null, new ArrayList()));
        }
    }

    static final class d {
        private d() {
        }

        public static void b(ClassLoader classLoader, File file) {
            Object obj = dp.a(classLoader, "pathList").get(classLoader);
            List list = (List) dp.a(obj, "nativeLibraryDirectories").get(obj);
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
            List list2 = (List) dp.a(obj, "systemNativeLibraryDirectories").get(obj);
            if (list2 == null) {
                list2 = new ArrayList(2);
            }
            ArrayList arrayList = new ArrayList(list.size() + list2.size() + 1);
            arrayList.addAll(list);
            arrayList.addAll(list2);
            dp.a(obj, "nativeLibraryPathElements").set(obj, (Object[]) dp.a(obj, "makePathElements", List.class).invoke(obj, arrayList));
        }
    }

    static final class e {
        private e() {
        }

        public static void b(ClassLoader classLoader, File file) {
            String str;
            String path = file.getPath();
            Field a2 = dp.a(classLoader, "libPath");
            String valueOf = String.valueOf(a2.get(classLoader));
            if (TextUtils.isEmpty(valueOf)) {
                str = path;
            } else {
                str = valueOf + ":" + path;
            }
            a2.set(classLoader, str);
            Field a3 = dp.a(classLoader, "libraryPathElements");
            List list = (List) a3.get(classLoader);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (path.equals((String) it.next())) {
                    return;
                }
            }
            list.add(path);
            a3.set(classLoader, list);
        }
    }

    public static synchronized void a(ClassLoader classLoader, File file) {
        synchronized (dn.class) {
            if (file != null) {
                if (file.exists()) {
                    int i2 = Build.VERSION.SDK_INT;
                    if ((i2 == 25 && Build.VERSION.PREVIEW_SDK_INT != 0) || i2 > 25) {
                        try {
                            d.b(classLoader, file);
                            return;
                        } catch (Throwable unused) {
                            b.b(classLoader, file);
                            return;
                        }
                    } else {
                        if (i2 != 24) {
                            if (i2 >= 23) {
                                try {
                                    b.b(classLoader, file);
                                    return;
                                } finally {
                                }
                            } else {
                                if (i2 >= 14) {
                                    a.b(classLoader, file);
                                    return;
                                }
                                e.b(classLoader, file);
                            }
                            return;
                        }
                        try {
                            c.b(classLoader, file);
                            return;
                        } finally {
                        }
                    }
                }
            }
        }
    }
}
