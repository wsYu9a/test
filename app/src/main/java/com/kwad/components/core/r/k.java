package com.kwad.components.core.r;

import android.os.SystemClock;
import android.text.TextUtils;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.kwad.sdk.core.config.item.o;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class k {
    private static final String PX = "com.kwad.components.core.r.k";
    private static volatile k PY = null;
    public static final String TAG = "k";
    private boolean PZ = false;
    private o.a Qa;

    private k() {
    }

    private static boolean a(List<String> list, Class cls) {
        int i2 = 0;
        while (cls != null && !TextUtils.equals(cls.getName(), "java.lang.Object")) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (cls.getName().contains(it.next())) {
                    return true;
                }
            }
            cls = cls.getSuperclass();
            i2++;
            if (i2 >= 4) {
                break;
            }
        }
        return false;
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
            com.kwad.sdk.core.d.b.d(TAG, "checkBySuper begin:" + elapsedRealtime);
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                String className = stackTraceElement.getClassName();
                if (className != null && aB(className) && aC(className)) {
                    try {
                        if (a(list, Class.forName(className).getSuperclass())) {
                            x(elapsedRealtime);
                            return true;
                        }
                    } catch (Throwable unused) {
                    }
                    try {
                        if (className.contains("$") && a(list, Class.forName(className.substring(0, className.lastIndexOf("$"))).getSuperclass())) {
                            x(elapsedRealtime);
                            return true;
                        }
                    } catch (Throwable unused2) {
                        continue;
                    }
                }
            }
            x(elapsedRealtime);
        }
        return false;
    }

    private static boolean aB(String str) {
        return (str.startsWith(BaseWrapper.BASE_PKG_SYSTEM) || str.startsWith("java") || str.startsWith("dalvik") || str.startsWith("com.android") || str.contains(PX) || !str.startsWith("androidx")) ? false : true;
    }

    private static boolean aC(String str) {
        return !str.startsWith("com.kwad");
    }

    private static boolean aD(String str) {
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

    public static k pP() {
        if (PY == null) {
            synchronized (k.class) {
                if (PY == null) {
                    PY = new k();
                }
            }
        }
        return PY;
    }

    private void pR() {
        o.a aVar = this.Qa;
        if (aVar == null) {
            return;
        }
        if (!this.PZ && aVar.aef.size() > 0) {
            Iterator<String> it = this.Qa.aef.iterator();
            while (it.hasNext()) {
                boolean aD = aD(it.next());
                this.PZ = aD;
                if (aD) {
                    break;
                }
            }
        }
        if (this.PZ) {
            ArrayList arrayList = new ArrayList();
            if (this.Qa.aec.size() > 0) {
                for (Map.Entry<Integer, String> entry : this.Qa.aec.entrySet()) {
                    if (aD(entry.getValue())) {
                        arrayList.add(entry.getKey());
                    }
                }
            }
            o.a aVar2 = this.Qa;
            com.kwad.components.core.m.a.pb().a(a(aVar2.aed, aVar2.aee), arrayList);
        }
    }

    private static void x(long j2) {
        com.kwad.sdk.core.d.b.d(TAG, "checkBySuper end:" + (SystemClock.elapsedRealtime() - j2));
    }

    public final boolean a(SceneImpl sceneImpl, String str) {
        boolean z;
        if (this.PZ) {
            o.a aVar = this.Qa;
            z = a(aVar.aed, aVar.aee);
        } else {
            z = false;
        }
        com.kwad.components.core.m.a.pb().a(sceneImpl, z, str);
        return z;
    }

    public final void init() {
        o.a aVar = (o.a) com.kwad.sdk.core.config.d.b(com.kwad.sdk.core.config.c.acm);
        this.Qa = aVar;
        if (aVar != null) {
            pR();
        }
    }

    public final int pQ() {
        o.a aVar = this.Qa;
        if (aVar != null) {
            return aVar.aeg;
        }
        return 0;
    }
}
