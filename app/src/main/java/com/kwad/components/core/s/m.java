package com.kwad.components.core.s;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.sdk.core.config.item.q;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class m {
    public static final String TAG = "m";
    private static final String VW = "com.kwad.components.core.s.m";
    private static volatile m VX;
    private boolean VY = false;
    private q.a VZ;

    private m() {
    }

    private static void J(long j10) {
        com.kwad.sdk.core.d.c.d(TAG, "checkBySuper end:" + (SystemClock.elapsedRealtime() - j10));
    }

    private static boolean aD(String str) {
        return (str.startsWith("android") || str.startsWith("java") || str.startsWith("dalvik") || str.startsWith("com.android") || str.contains(VW) || !str.startsWith("androidx")) ? false : true;
    }

    private static boolean aE(String str) {
        return !str.startsWith("com.kwad");
    }

    private static boolean aF(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static m si() {
        if (VX == null) {
            synchronized (m.class) {
                try {
                    if (VX == null) {
                        VX = new m();
                    }
                } finally {
                }
            }
        }
        return VX;
    }

    private void sk() {
        q.a aVar = this.VZ;
        if (aVar == null) {
            return;
        }
        if (!this.VY && aVar.axt.size() > 0) {
            Iterator<String> it = this.VZ.axt.iterator();
            while (it.hasNext()) {
                boolean aF = aF(it.next());
                this.VY = aF;
                if (aF) {
                    break;
                }
            }
        }
        if (this.VY) {
            ArrayList arrayList = new ArrayList();
            if (this.VZ.axq.size() > 0) {
                for (Map.Entry<Integer, String> entry : this.VZ.axq.entrySet()) {
                    if (aF(entry.getValue())) {
                        arrayList.add(entry.getKey());
                    }
                }
            }
            q.a aVar2 = this.VZ;
            com.kwad.components.core.o.a.ri().a(a(aVar2.axr, aVar2.axs), arrayList);
        }
    }

    public final boolean a(SceneImpl sceneImpl, String str) {
        boolean z10;
        if (this.VY) {
            q.a aVar = this.VZ;
            z10 = a(aVar.axr, aVar.axs);
        } else {
            z10 = false;
        }
        com.kwad.components.core.o.a.ri().a(sceneImpl, z10, str);
        return z10;
    }

    public final void init() {
        q.a aVar = (q.a) com.kwad.sdk.core.config.d.b(com.kwad.sdk.core.config.c.auQ);
        this.VZ = aVar;
        if (aVar != null) {
            sk();
        }
    }

    public final int sj() {
        q.a aVar = this.VZ;
        if (aVar != null) {
            return aVar.axu;
        }
        return 0;
    }

    private boolean a(List<String> list, List<String> list2) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            if (className != null) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    if (className.contains(it.next())) {
                        return true;
                    }
                }
            }
        }
        return a(list2, stackTrace);
    }

    private boolean a(List<String> list, StackTraceElement[] stackTraceElementArr) {
        if (list != null && !list.isEmpty()) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            com.kwad.sdk.core.d.c.d(TAG, "checkBySuper begin:" + elapsedRealtime);
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                String className = stackTraceElement.getClassName();
                if (className != null && aD(className) && aE(className)) {
                    try {
                        if (a(list, Class.forName(className).getSuperclass())) {
                            J(elapsedRealtime);
                            return true;
                        }
                    } catch (Throwable unused) {
                    }
                    try {
                        if (className.contains("$") && a(list, Class.forName(className.substring(0, className.lastIndexOf("$"))).getSuperclass())) {
                            J(elapsedRealtime);
                            return true;
                        }
                    } catch (Throwable unused2) {
                        continue;
                    }
                }
            }
            J(elapsedRealtime);
        }
        return false;
    }

    private static boolean a(List<String> list, Class cls) {
        int i10 = 0;
        while (cls != null && !TextUtils.equals(cls.getName(), "java.lang.Object")) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (cls.getName().contains(it.next())) {
                    return true;
                }
            }
            cls = cls.getSuperclass();
            i10++;
            if (i10 >= 4) {
                break;
            }
        }
        return false;
    }
}
