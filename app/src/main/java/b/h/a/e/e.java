package b.h.a.e;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f4975a = {"MemTotal:", "MemFree:", "Buffers:", "Cached:", "Active:", "Inactive:", "Dirty:"};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f4976b = {"VmLck:", "VmRSS:", "VmSize:", "VmExe:", "VmStk:", "VmLib", "Threads:"};

    public static Map<String, Long> a() {
        HashMap hashMap = new HashMap();
        try {
            Method method = Class.forName("android.os.Process").getMethod("readProcLines", String.class, String[].class, long[].class);
            if (method == null) {
                return hashMap;
            }
            String[] strArr = f4975a;
            int length = strArr.length;
            long[] jArr = new long[length];
            jArr[0] = 30;
            jArr[1] = -30;
            method.invoke(null, new String("/proc/meminfo"), strArr, jArr);
            for (int i2 = 0; i2 < length; i2++) {
                hashMap.put(f4975a[i2], Long.valueOf(jArr[i2]));
            }
            return hashMap;
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException unused) {
            return null;
        }
    }
}
