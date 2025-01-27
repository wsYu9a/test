package com.kwad.sdk.crash.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.library.solder.lib.i;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.crash.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public final class a {
    private static Set<String> aKm;

    static {
        HashSet hashSet = new HashSet();
        aKm = hashSet;
        hashSet.add("commonHT");
        aKm.add("reportHT");
        aKm.add("IpDirectHelper");
        aKm.add("filedownloader serial thread");
        aKm.add("RemitHandoverToDB");
        aKm.add("source-status-callback");
        aKm.add("ObiwanMMAPTracer");
        aKm.add("FrameSequence decoding thread");
    }

    private static boolean E(@NonNull List<StackTraceElement[]> list) {
        Iterator<StackTraceElement[]> it = list.iterator();
        while (it.hasNext()) {
            if (a(it.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0) {
            return false;
        }
        String[] Jl = e.Jk().Jl();
        if (Jl == null || Jl.length == 0) {
            return true;
        }
        boolean z10 = false;
        for (String str : Jl) {
            z10 = a(stackTraceElementArr, str);
            if (z10) {
                break;
            }
        }
        if (z10) {
            for (String str2 : e.Jk().Jm()) {
                if (b(stackTraceElementArr, str2)) {
                    return false;
                }
            }
        }
        return z10;
    }

    private static boolean b(StackTraceElement[] stackTraceElementArr, String str) {
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            String className = stackTraceElement.getClassName();
            if (!TextUtils.isEmpty(className) && className.contains(str)) {
                c.d("AnrAndNativeAdExceptionCollector", "CrashFilter excludeTags element className=" + className + " exclude tag=" + str);
                return true;
            }
        }
        return false;
    }

    private static boolean fD(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return fE(str) || str.startsWith("ksad-") || str.startsWith("filedownloader serial thread");
    }

    private static boolean fE(String str) {
        if (TextUtils.isEmpty(str) || !str.contains("kwad.kwadsdk")) {
            return false;
        }
        c.d("CrashFilter", "needReportByThreadStr:" + str);
        return true;
    }

    public static boolean fF(String str) {
        if (fD(str) || i.bM(str)) {
            return true;
        }
        Set<String> set = aKm;
        if (set == null || !set.contains(str)) {
            return false;
        }
        c.d("CrashFilter", "needReportByThreadName:" + str);
        return true;
    }

    public static boolean fG(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] Jl = e.Jk().Jl();
        if (Jl == null || Jl.length == 0) {
            return true;
        }
        boolean z10 = false;
        for (String str2 : Jl) {
            z10 = str.contains(str2);
            if (z10) {
                break;
            }
        }
        if (z10) {
            for (String str3 : e.Jk().Jm()) {
                if (str.contains(str3)) {
                    return false;
                }
            }
        }
        return z10;
    }

    public static boolean o(@NonNull Throwable th2) {
        ArrayList arrayList = new ArrayList(5);
        for (int i10 = 0; i10 < 5; i10++) {
            arrayList.add(th2.getStackTrace());
            th2 = th2.getCause();
            if (th2 == null) {
                break;
            }
        }
        return E(arrayList);
    }

    private static boolean a(@NonNull StackTraceElement[] stackTraceElementArr, String str) {
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            String className = stackTraceElement.getClassName();
            if (!TextUtils.isEmpty(className) && className.contains(str)) {
                c.d("AnrAndNativeAdExceptionCollector", "CrashFilter filterTags element className=" + className + " filter tag=" + str);
                return true;
            }
        }
        return false;
    }
}
