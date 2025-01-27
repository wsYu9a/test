package com.kwad.sdk.crash.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class a {
    private static boolean a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0) {
            return false;
        }
        String[] zz = e.zy().zz();
        if (zz == null || zz.length == 0) {
            return true;
        }
        boolean z = false;
        for (String str : zz) {
            z = a(stackTraceElementArr, str);
            if (z) {
                break;
            }
        }
        if (z) {
            for (String str2 : e.zy().zA()) {
                if (b(stackTraceElementArr, str2)) {
                    return false;
                }
            }
        }
        return z;
    }

    private static boolean a(@NonNull StackTraceElement[] stackTraceElementArr, String str) {
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            String className = stackTraceElement.getClassName();
            if (!TextUtils.isEmpty(className) && className.contains(str)) {
                com.kwad.sdk.core.d.b.d("ExceptionCollector", "CrashFilter filterTags element className=" + className + " filter tag=" + str);
                return true;
            }
        }
        return false;
    }

    private static boolean b(StackTraceElement[] stackTraceElementArr, String str) {
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            String className = stackTraceElement.getClassName();
            if (!TextUtils.isEmpty(className) && className.contains(str)) {
                com.kwad.sdk.core.d.b.d("ExceptionCollector", "CrashFilter excludeTags element className=" + className + " exclude tag=" + str);
                return true;
            }
        }
        return false;
    }

    public static boolean h(@NonNull Throwable th) {
        ArrayList arrayList = new ArrayList(5);
        for (int i2 = 0; i2 < 5; i2++) {
            arrayList.add(th.getStackTrace());
            th = th.getCause();
            if (th == null) {
                break;
            }
        }
        return v(arrayList);
    }

    private static boolean v(@NonNull List<StackTraceElement[]> list) {
        Iterator<StackTraceElement[]> it = list.iterator();
        while (it.hasNext()) {
            if (a(it.next())) {
                return true;
            }
        }
        return false;
    }
}
