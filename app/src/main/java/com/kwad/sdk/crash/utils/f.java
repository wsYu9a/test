package com.kwad.sdk.crash.utils;

import android.os.Build;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* loaded from: classes2.dex */
public final class f {

    static abstract class a {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        abstract Object Aj();

        abstract void println(Object obj);
    }

    static class b extends a {
        private final PrintWriter atc;

        b(PrintWriter printWriter) {
            super((byte) 0);
            this.atc = printWriter;
        }

        @Override // com.kwad.sdk.crash.utils.f.a
        final Object Aj() {
            return this.atc;
        }

        @Override // com.kwad.sdk.crash.utils.f.a
        final void println(Object obj) {
            this.atc.println(obj);
        }
    }

    private static void a(Throwable th, a aVar) {
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        newSetFromMap.add(th);
        synchronized (aVar.Aj()) {
            aVar.println(th);
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                aVar.println("\tat " + stackTraceElement);
            }
            if (Build.VERSION.SDK_INT >= 19) {
                for (Throwable th2 : new Throwable[0]) {
                    a(th2, aVar, "Suppressed: ", "\t", newSetFromMap);
                }
            }
            Throwable cause = th.getCause();
            if (cause != null) {
                a(cause, aVar, "Caused by: ", "", newSetFromMap);
            }
        }
    }

    private static void a(Throwable th, a aVar, String str, String str2, Set<Throwable> set) {
        while (!set.contains(th)) {
            set.add(th);
            StackTraceElement[] stackTrace = th.getStackTrace();
            aVar.println(str2 + str + th);
            for (StackTraceElement stackTraceElement : stackTrace) {
                aVar.println(str2 + "\tat " + stackTraceElement);
            }
            if (Build.VERSION.SDK_INT >= 19) {
                for (Throwable th2 : new Throwable[0]) {
                    a(th2, aVar, "Suppressed: ", str2 + "\t", set);
                }
            }
            th = th.getCause();
            if (th == null) {
                return;
            } else {
                str = "Caused by: ";
            }
        }
        aVar.println("\t[CIRCULAR REFERENCE:" + th + "]");
    }

    public static void a(Throwable th, PrintWriter printWriter) {
        a(th, new b(printWriter));
    }
}
