package com.kwad.sdk.api;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.IKsAdSDK;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public final class c {
    private static List<Throwable> LD;
    private static IKsAdSDK app;

    /* renamed from: com.kwad.sdk.api.c$1 */
    public class AnonymousClass1 extends com.kwad.sdk.api.a.b {
        @Override // com.kwad.sdk.api.a.b
        public final void doTask() {
            try {
                if (c.LD == null) {
                    return;
                }
                for (Throwable th2 : c.LD) {
                    if (c.app != null && KsAdSDK.haseInit()) {
                        c.app.re(th2);
                    }
                }
                c.LD.clear();
                c.s(null);
            } catch (Throwable unused) {
            }
        }
    }

    public static IKsAdSDK Bp() {
        return app;
    }

    public static boolean Bq() {
        Boolean bool = (Boolean) f("enableDynamic", new Object[0]);
        return (bool == null || bool.booleanValue()) ? false : true;
    }

    public static int Br() {
        Integer num = (Integer) f("getAutoRevertTime", new Object[0]);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public static void a(IKsAdSDK iKsAdSDK) {
        app = iKsAdSDK;
    }

    private static void b(Throwable th2) {
        try {
            if (LD == null) {
                LD = new CopyOnWriteArrayList();
            }
            LD.add(th2);
        } catch (Throwable unused) {
        }
    }

    public static String ch(String str) {
        return (String) f("TRANSFORM_API_HOST", str);
    }

    @Nullable
    public static <T> T f(String str, Object... objArr) {
        try {
            T t10 = (T) app.dM(str, objArr);
            if (t10 != null) {
                return t10;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void m(Throwable th2) {
        try {
            if (app == null || !KsAdSDK.haseInit()) {
                b(th2);
            } else {
                app.re(th2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void nF() {
        try {
            com.kwad.sdk.api.a.a.a(new com.kwad.sdk.api.a.b() { // from class: com.kwad.sdk.api.c.1
                @Override // com.kwad.sdk.api.a.b
                public final void doTask() {
                    try {
                        if (c.LD == null) {
                            return;
                        }
                        for (Throwable th2 : c.LD) {
                            if (c.app != null && KsAdSDK.haseInit()) {
                                c.app.re(th2);
                            }
                        }
                        c.LD.clear();
                        c.s(null);
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static /* synthetic */ List s(List list) {
        LD = null;
        return null;
    }
}
