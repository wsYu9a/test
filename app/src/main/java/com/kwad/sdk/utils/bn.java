package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class bn {

    /* renamed from: com.kwad.sdk.utils.bn$1 */
    public class AnonymousClass1 extends com.kwad.sdk.f.b<String, String> {
        private static String hf(String str) {
            return str;
        }

        @Override // com.kwad.sdk.f.b
        public final /* synthetic */ String apply(String str) {
            return hf(str);
        }
    }

    /* renamed from: com.kwad.sdk.utils.bn$2 */
    public class AnonymousClass2 extends com.kwad.sdk.f.b<String, Integer> {
        private static Integer hg(String str) {
            return Integer.valueOf(Integer.parseInt(str));
        }

        @Override // com.kwad.sdk.f.b
        public final /* synthetic */ Integer apply(String str) {
            return hg(str);
        }
    }

    /* renamed from: com.kwad.sdk.utils.bn$3 */
    public class AnonymousClass3 extends com.kwad.sdk.f.b<String, Long> {
        private static Long hh(String str) {
            return Long.valueOf(Long.parseLong(str));
        }

        @Override // com.kwad.sdk.f.b
        public final /* synthetic */ Long apply(String str) {
            return hh(str);
        }
    }

    /* renamed from: com.kwad.sdk.utils.bn$4 */
    public class AnonymousClass4 extends com.kwad.sdk.f.b<String, Boolean> {
        private static Boolean hi(String str) {
            return Boolean.valueOf(Boolean.parseBoolean(str));
        }

        @Override // com.kwad.sdk.f.b
        public final /* synthetic */ Boolean apply(String str) {
            return hi(str);
        }
    }

    private static <T> T a(String str, T t10, com.kwad.sdk.f.b<String, T> bVar) {
        String he2 = he(str);
        if (he2 == null) {
            return t10;
        }
        try {
            return bVar.apply(he2);
        } catch (Throwable unused) {
            return t10;
        }
    }

    @SuppressLint({"PrivateApi"})
    private static Object b(String str, Class[] clsArr, Object... objArr) {
        try {
            return w.a("android.os.SystemProperties", str, clsArr, objArr);
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTrace(th2);
            return null;
        }
    }

    public static String get(String str) {
        Object b10 = b(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}, str);
        return b10 instanceof String ? (String) b10 : he(str);
    }

    public static boolean getBoolean(String str, boolean z10) {
        Object b10 = b("getBoolean", new Class[]{String.class, Boolean.TYPE}, str, Boolean.valueOf(z10));
        return b10 instanceof Boolean ? ((Boolean) b10).booleanValue() : ((Boolean) a(str, Boolean.valueOf(z10), new com.kwad.sdk.f.b<String, Boolean>() { // from class: com.kwad.sdk.utils.bn.4
            private static Boolean hi(String str2) {
                return Boolean.valueOf(Boolean.parseBoolean(str2));
            }

            @Override // com.kwad.sdk.f.b
            public final /* synthetic */ Boolean apply(String str2) {
                return hi(str2);
            }
        })).booleanValue();
    }

    public static int getInt(String str, int i10) {
        Object b10 = b("getInt", new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i10));
        return b10 instanceof Integer ? ((Integer) b10).intValue() : ((Integer) a(str, Integer.valueOf(i10), new com.kwad.sdk.f.b<String, Integer>() { // from class: com.kwad.sdk.utils.bn.2
            private static Integer hg(String str2) {
                return Integer.valueOf(Integer.parseInt(str2));
            }

            @Override // com.kwad.sdk.f.b
            public final /* synthetic */ Integer apply(String str2) {
                return hg(str2);
            }
        })).intValue();
    }

    public static long getLong(String str, long j10) {
        Object b10 = b("getLong", new Class[]{String.class, Long.TYPE}, str, Long.valueOf(j10));
        return b10 instanceof Long ? ((Long) b10).longValue() : ((Long) a(str, Long.valueOf(j10), new com.kwad.sdk.f.b<String, Long>() { // from class: com.kwad.sdk.utils.bn.3
            private static Long hh(String str2) {
                return Long.valueOf(Long.parseLong(str2));
            }

            @Override // com.kwad.sdk.f.b
            public final /* synthetic */ Long apply(String str2) {
                return hh(str2);
            }
        })).longValue();
    }

    private static String he(String str) {
        try {
            return com.kwad.sdk.crash.utils.h.c(Runtime.getRuntime().exec("getprop " + str).getInputStream());
        } catch (IOException e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
            return null;
        }
    }

    public static String get(String str, String str2) {
        Object b10 = b(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}, str, str2);
        if (b10 instanceof String) {
            return (String) b10;
        }
        return (String) a(str, str2, new com.kwad.sdk.f.b<String, String>() { // from class: com.kwad.sdk.utils.bn.1
            private static String hf(String str3) {
                return str3;
            }

            @Override // com.kwad.sdk.f.b
            public final /* synthetic */ String apply(String str3) {
                return hf(str3);
            }
        });
    }
}
