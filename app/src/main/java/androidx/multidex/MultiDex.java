package androidx.multidex;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.util.Log;
import com.cdo.oaps.ad.OapsWrapper;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.zip.ZipFile;

/* loaded from: classes.dex */
public final class MultiDex {

    /* renamed from: a */
    static final String f2888a = "MultiDex";

    /* renamed from: b */
    private static final String f2889b = "secondary-dexes";

    /* renamed from: c */
    private static final String f2890c = "code_cache";

    /* renamed from: d */
    private static final String f2891d = "secondary-dexes";

    /* renamed from: e */
    private static final int f2892e = 20;

    /* renamed from: f */
    private static final int f2893f = 4;

    /* renamed from: g */
    private static final int f2894g = 2;

    /* renamed from: h */
    private static final int f2895h = 1;

    /* renamed from: i */
    private static final String f2896i = "";

    /* renamed from: j */
    private static final Set<File> f2897j = new HashSet();
    private static final boolean k = m(System.getProperty("java.vm.version"));

    private static final class V14 {

        /* renamed from: a */
        private static final int f2898a = 4;

        /* renamed from: b */
        private final ElementConstructor f2899b;

        private interface ElementConstructor {
            Object newInstance(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException;
        }

        private static class ICSElementConstructor implements ElementConstructor {

            /* renamed from: a */
            private final Constructor<?> f2900a;

            ICSElementConstructor(Class<?> cls) throws SecurityException, NoSuchMethodException {
                Constructor<?> constructor = cls.getConstructor(File.class, ZipFile.class, DexFile.class);
                this.f2900a = constructor;
                constructor.setAccessible(true);
            }

            @Override // androidx.multidex.MultiDex.V14.ElementConstructor
            public Object newInstance(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException {
                return this.f2900a.newInstance(file, new ZipFile(file), dexFile);
            }
        }

        private static class JBMR11ElementConstructor implements ElementConstructor {

            /* renamed from: a */
            private final Constructor<?> f2901a;

            JBMR11ElementConstructor(Class<?> cls) throws SecurityException, NoSuchMethodException {
                Constructor<?> constructor = cls.getConstructor(File.class, File.class, DexFile.class);
                this.f2901a = constructor;
                constructor.setAccessible(true);
            }

            @Override // androidx.multidex.MultiDex.V14.ElementConstructor
            public Object newInstance(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
                return this.f2901a.newInstance(file, file, dexFile);
            }
        }

        private static class JBMR2ElementConstructor implements ElementConstructor {

            /* renamed from: a */
            private final Constructor<?> f2902a;

            JBMR2ElementConstructor(Class<?> cls) throws SecurityException, NoSuchMethodException {
                Constructor<?> constructor = cls.getConstructor(File.class, Boolean.TYPE, File.class, DexFile.class);
                this.f2902a = constructor;
                constructor.setAccessible(true);
            }

            @Override // androidx.multidex.MultiDex.V14.ElementConstructor
            public Object newInstance(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
                return this.f2902a.newInstance(file, Boolean.FALSE, file, dexFile);
            }
        }

        private V14() throws ClassNotFoundException, SecurityException, NoSuchMethodException {
            ElementConstructor jBMR2ElementConstructor;
            Class<?> cls = Class.forName("dalvik.system.DexPathList$Element");
            try {
                try {
                    jBMR2ElementConstructor = new ICSElementConstructor(cls);
                } catch (NoSuchMethodException unused) {
                    jBMR2ElementConstructor = new JBMR2ElementConstructor(cls);
                }
            } catch (NoSuchMethodException unused2) {
                jBMR2ElementConstructor = new JBMR11ElementConstructor(cls);
            }
            this.f2899b = jBMR2ElementConstructor;
        }

        static void a(ClassLoader classLoader, List<? extends File> list) throws IOException, SecurityException, IllegalArgumentException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
            Object obj = MultiDex.g(classLoader, "pathList").get(classLoader);
            Object[] b2 = new V14().b(list);
            try {
                MultiDex.f(obj, "dexElements", b2);
            } catch (NoSuchFieldException e2) {
                Log.w(MultiDex.f2888a, "Failed find field 'dexElements' attempting 'pathElements'", e2);
                MultiDex.f(obj, "pathElements", b2);
            }
        }

        private Object[] b(List<? extends File> list) throws IOException, SecurityException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
            int size = list.size();
            Object[] objArr = new Object[size];
            for (int i2 = 0; i2 < size; i2++) {
                File file = list.get(i2);
                objArr[i2] = this.f2899b.newInstance(file, DexFile.loadDex(file.getPath(), c(file), 0));
            }
            return objArr;
        }

        private static String c(File file) {
            File parentFile = file.getParentFile();
            String name = file.getName();
            return new File(parentFile, name.substring(0, name.length() - f2898a) + ".dex").getPath();
        }
    }

    private static final class V19 {
        private V19() {
        }

        static void a(ClassLoader classLoader, List<? extends File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
            IOException[] iOExceptionArr;
            Object obj = MultiDex.g(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            MultiDex.f(obj, "dexElements", b(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Log.w(MultiDex.f2888a, "Exception in makeDexElement", (IOException) it.next());
                }
                Field g2 = MultiDex.g(obj, "dexElementsSuppressedExceptions");
                IOException[] iOExceptionArr2 = (IOException[]) g2.get(obj);
                if (iOExceptionArr2 == null) {
                    iOExceptionArr = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                } else {
                    IOException[] iOExceptionArr3 = new IOException[arrayList.size() + iOExceptionArr2.length];
                    arrayList.toArray(iOExceptionArr3);
                    System.arraycopy(iOExceptionArr2, 0, iOExceptionArr3, arrayList.size(), iOExceptionArr2.length);
                    iOExceptionArr = iOExceptionArr3;
                }
                g2.set(obj, iOExceptionArr);
                IOException iOException = new IOException("I/O exception during makeDexElement");
                iOException.initCause((Throwable) arrayList.get(0));
                throw iOException;
            }
        }

        private static Object[] b(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            return (Object[]) MultiDex.h(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class).invoke(obj, arrayList, file, arrayList2);
        }
    }

    private static final class V4 {
        private V4() {
        }

        static void a(ClassLoader classLoader, List<? extends File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException {
            int size = list.size();
            Field g2 = MultiDex.g(classLoader, OapsWrapper.KEY_PATH);
            StringBuilder sb = new StringBuilder((String) g2.get(classLoader));
            String[] strArr = new String[size];
            File[] fileArr = new File[size];
            ZipFile[] zipFileArr = new ZipFile[size];
            DexFile[] dexFileArr = new DexFile[size];
            ListIterator<? extends File> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                File next = listIterator.next();
                String absolutePath = next.getAbsolutePath();
                sb.append(':');
                sb.append(absolutePath);
                int previousIndex = listIterator.previousIndex();
                strArr[previousIndex] = absolutePath;
                fileArr[previousIndex] = next;
                zipFileArr[previousIndex] = new ZipFile(next);
                dexFileArr[previousIndex] = DexFile.loadDex(absolutePath, absolutePath + ".dex", 0);
            }
            g2.set(classLoader, sb.toString());
            MultiDex.f(classLoader, "mPaths", strArr);
            MultiDex.f(classLoader, "mFiles", fileArr);
            MultiDex.f(classLoader, "mZips", zipFileArr);
            MultiDex.f(classLoader, "mDexs", dexFileArr);
        }
    }

    private MultiDex() {
    }

    private static void d(Context context) throws Exception {
        File file = new File(context.getFilesDir(), "secondary-dexes");
        if (file.isDirectory()) {
            Log.i(f2888a, "Clearing old secondary dex dir (" + file.getPath() + ").");
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                Log.w(f2888a, "Failed to list secondary dex dir content (" + file.getPath() + ").");
                return;
            }
            for (File file2 : listFiles) {
                Log.i(f2888a, "Trying to delete old file " + file2.getPath() + " of size " + file2.length());
                if (file2.delete()) {
                    Log.i(f2888a, "Deleted old file " + file2.getPath());
                } else {
                    Log.w(f2888a, "Failed to delete old file " + file2.getPath());
                }
            }
            if (file.delete()) {
                Log.i(f2888a, "Deleted old secondary dex dir " + file.getPath());
                return;
            }
            Log.w(f2888a, "Failed to delete secondary dex dir " + file.getPath());
        }
    }

    private static void e(Context context, File file, File file2, String str, String str2, boolean z) throws IOException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException {
        Set<File> set = f2897j;
        synchronized (set) {
            if (set.contains(file)) {
                return;
            }
            set.add(file);
            int i2 = Build.VERSION.SDK_INT;
            if (i2 > 20) {
                Log.w(f2888a, "MultiDex is not guaranteed to work in SDK version " + i2 + ": SDK version higher than 20 should be backed by runtime with built-in multidex capabilty but it's not the case here: java.vm.version=\"" + System.getProperty("java.vm.version") + "\"");
            }
            ClassLoader j2 = j(context);
            if (j2 == null) {
                return;
            }
            try {
                d(context);
            } catch (Throwable th) {
                Log.w(f2888a, "Something went wrong when trying to clear old MultiDex extraction, continuing without cleaning.", th);
            }
            File k2 = k(context, file2, str);
            MultiDexExtractor multiDexExtractor = new MultiDexExtractor(file, k2);
            IOException e2 = null;
            try {
                try {
                    l(j2, k2, multiDexExtractor.h(context, str2, false));
                } catch (IOException e3) {
                    if (!z) {
                        throw e3;
                    }
                    Log.w(f2888a, "Failed to install extracted secondary dex files, retrying with forced extraction", e3);
                    l(j2, k2, multiDexExtractor.h(context, str2, true));
                }
                try {
                } catch (IOException e4) {
                    e2 = e4;
                }
                if (e2 != null) {
                    throw e2;
                }
            } finally {
                try {
                    multiDexExtractor.close();
                } catch (IOException unused) {
                }
            }
        }
    }

    public static void f(Object obj, String str, Object[] objArr) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field g2 = g(obj, str);
        Object[] objArr2 = (Object[]) g2.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        g2.set(obj, objArr3);
    }

    public static Field g(Object obj, String str) throws NoSuchFieldException {
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
    }

    public static Method h(Object obj, String str, Class<?>... clsArr) throws NoSuchMethodException {
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
    }

    private static ApplicationInfo i(Context context) {
        try {
            return context.getApplicationInfo();
        } catch (RuntimeException e2) {
            Log.w(f2888a, "Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", e2);
            return null;
        }
    }

    public static void install(Context context) {
        Log.i(f2888a, "Installing application");
        if (k) {
            Log.i(f2888a, "VM has multidex support, MultiDex support library is disabled.");
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 4) {
            throw new RuntimeException("MultiDex installation failed. SDK " + i2 + " is unsupported. Min SDK version is 4.");
        }
        try {
            ApplicationInfo i3 = i(context);
            if (i3 == null) {
                Log.i(f2888a, "No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
            } else {
                e(context, new File(i3.sourceDir), new File(i3.dataDir), "secondary-dexes", "", true);
                Log.i(f2888a, "install done");
            }
        } catch (Exception e2) {
            Log.e(f2888a, "MultiDex installation failure", e2);
            throw new RuntimeException("MultiDex installation failed (" + e2.getMessage() + ").");
        }
    }

    public static void installInstrumentation(Context context, Context context2) {
        Log.i(f2888a, "Installing instrumentation");
        if (k) {
            Log.i(f2888a, "VM has multidex support, MultiDex support library is disabled.");
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 4) {
            throw new RuntimeException("MultiDex installation failed. SDK " + i2 + " is unsupported. Min SDK version is 4.");
        }
        try {
            ApplicationInfo i3 = i(context);
            if (i3 == null) {
                Log.i(f2888a, "No ApplicationInfo available for instrumentation, i.e. running on a test Context: MultiDex support library is disabled.");
                return;
            }
            ApplicationInfo i4 = i(context2);
            if (i4 == null) {
                Log.i(f2888a, "No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
                return;
            }
            String str = context.getPackageName() + ".";
            File file = new File(i4.dataDir);
            e(context2, new File(i3.sourceDir), file, str + "secondary-dexes", str, false);
            e(context2, new File(i4.sourceDir), file, "secondary-dexes", "", false);
            Log.i(f2888a, "Installation done");
        } catch (Exception e2) {
            Log.e(f2888a, "MultiDex installation failure", e2);
            throw new RuntimeException("MultiDex installation failed (" + e2.getMessage() + ").");
        }
    }

    private static ClassLoader j(Context context) {
        try {
            ClassLoader classLoader = context.getClassLoader();
            if (Build.VERSION.SDK_INT >= 14) {
                if (classLoader instanceof BaseDexClassLoader) {
                    return classLoader;
                }
            } else if ((classLoader instanceof DexClassLoader) || (classLoader instanceof PathClassLoader)) {
                return classLoader;
            }
            Log.e(f2888a, "Context class loader is null or not dex-capable. Must be running in test mode. Skip patching.");
            return null;
        } catch (RuntimeException e2) {
            Log.w(f2888a, "Failure while trying to obtain Context class loader. Must be running in test mode. Skip patching.", e2);
            return null;
        }
    }

    private static File k(Context context, File file, String str) throws IOException {
        File file2 = new File(file, f2890c);
        try {
            n(file2);
        } catch (IOException unused) {
            file2 = new File(context.getFilesDir(), f2890c);
            n(file2);
        }
        File file3 = new File(file2, str);
        n(file3);
        return file3;
    }

    private static void l(ClassLoader classLoader, File file, List<? extends File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException, SecurityException, ClassNotFoundException, InstantiationException {
        if (list.isEmpty()) {
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            V19.a(classLoader, list, file);
        } else if (i2 >= 14) {
            V14.a(classLoader, list);
        } else {
            V4.a(classLoader, list);
        }
    }

    static boolean m(String str) {
        boolean z = false;
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
            String nextToken = stringTokenizer.hasMoreTokens() ? stringTokenizer.nextToken() : null;
            String nextToken2 = stringTokenizer.hasMoreTokens() ? stringTokenizer.nextToken() : null;
            if (nextToken != null && nextToken2 != null) {
                try {
                    int parseInt = Integer.parseInt(nextToken);
                    int parseInt2 = Integer.parseInt(nextToken2);
                    if (parseInt > 2 || (parseInt == 2 && parseInt2 >= 1)) {
                        z = true;
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("VM with version ");
        sb.append(str);
        sb.append(z ? " has multidex support" : " does not have multidex support");
        Log.i(f2888a, sb.toString());
        return z;
    }

    private static void n(File file) throws IOException {
        file.mkdir();
        if (file.isDirectory()) {
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            Log.e(f2888a, "Failed to create dir " + file.getPath() + ". Parent file is null.");
        } else {
            Log.e(f2888a, "Failed to create dir " + file.getPath() + ". parent file is a dir " + parentFile.isDirectory() + ", a file " + parentFile.isFile() + ", exists " + parentFile.exists() + ", readable " + parentFile.canRead() + ", writable " + parentFile.canWrite());
        }
        throw new IOException("Failed to create directory " + file.getPath());
    }
}
