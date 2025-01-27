package com.kwad.sdk.crash.utils;

import java.io.PrintWriter;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* loaded from: classes3.dex */
public final class f {

    public static abstract class a {
        private a() {
        }

        public abstract Object JT();

        public abstract void println(Object obj);

        public /* synthetic */ a(byte b10) {
            this();
        }
    }

    public static class b extends a {
        private final PrintWriter aMo;

        public b(PrintWriter printWriter) {
            super((byte) 0);
            this.aMo = printWriter;
        }

        @Override // com.kwad.sdk.crash.utils.f.a
        public final Object JT() {
            return this.aMo;
        }

        @Override // com.kwad.sdk.crash.utils.f.a
        public final void println(Object obj) {
            this.aMo.println(obj);
        }
    }

    public static void a(Throwable th2, PrintWriter printWriter) {
        a(th2, new b(printWriter));
    }

    private static void a(Throwable th2, a aVar) {
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        newSetFromMap.add(th2);
        synchronized (aVar.JT()) {
            try {
                aVar.println(th2);
                for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
                    aVar.println("\tat " + stackTraceElement);
                }
                for (Throwable th3 : th2.getSuppressed()) {
                    a(th3, aVar, "Suppressed: ", "\t", newSetFromMap);
                }
                Throwable cause = th2.getCause();
                if (cause != null) {
                    a(cause, aVar, "Caused by: ", "", newSetFromMap);
                }
            } catch (Throwable th4) {
                throw th4;
            }
        }
    }

    private static void a(Throwable th2, a aVar, String str, String str2, Set<Throwable> set) {
        while (!set.contains(th2)) {
            set.add(th2);
            StackTraceElement[] stackTrace = th2.getStackTrace();
            aVar.println(str2 + str + th2);
            for (StackTraceElement stackTraceElement : stackTrace) {
                aVar.println(str2 + "\tat " + stackTraceElement);
            }
            for (Throwable th3 : th2.getSuppressed()) {
                a(th3, aVar, "Suppressed: ", str2 + "\t", set);
            }
            th2 = th2.getCause();
            if (th2 == null) {
                return;
            } else {
                str = "Caused by: ";
            }
        }
        aVar.println("\t[CIRCULAR REFERENCE:" + th2 + "]");
    }
}
