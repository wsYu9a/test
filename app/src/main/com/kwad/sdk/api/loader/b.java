package com.kwad.sdk.api.loader;

import android.annotation.SuppressLint;
import android.content.Context;
import com.kwad.sdk.api.SdkConfig;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: com.kwad.sdk.api.loader.b$1 */
    public class AnonymousClass1 extends com.kwad.sdk.api.a.b {
        final /* synthetic */ SdkConfig apL;
        final /* synthetic */ Context hB;

        public AnonymousClass1(Context context, SdkConfig sdkConfig) {
            context = context;
            sdkConfig = sdkConfig;
        }

        @Override // com.kwad.sdk.api.a.b
        public final void doTask() {
            b.c(context, "sdkconfig", sdkConfig.toJson());
        }
    }

    public static void a(Context context, SdkConfig sdkConfig) {
        com.kwad.sdk.api.a.a.a(new com.kwad.sdk.api.a.b() { // from class: com.kwad.sdk.api.loader.b.1
            final /* synthetic */ SdkConfig apL;
            final /* synthetic */ Context hB;

            public AnonymousClass1(Context context2, SdkConfig sdkConfig2) {
                context = context2;
                sdkConfig = sdkConfig2;
            }

            @Override // com.kwad.sdk.api.a.b
            public final void doTask() {
                b.c(context, "sdkconfig", sdkConfig.toJson());
            }
        });
    }

    public static String b(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences("kssdk_api_pref", 0).getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    @SuppressLint({"ApplySharedPref"})
    public static void c(Context context, String str, String str2) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putString(str, str2).commit();
        } catch (Throwable unused) {
        }
    }

    public static String getString(Context context, String str) {
        return b(context, str, "");
    }

    public static long n(Context context, String str) {
        return b(context, str, 0L);
    }

    @SuppressLint({"ApplySharedPref"})
    public static void a(Context context, String str, boolean z10) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putBoolean(str, z10).commit();
        } catch (Throwable unused) {
        }
    }

    public static boolean b(Context context, String str, boolean z10) {
        try {
            return context.getSharedPreferences("kssdk_api_pref", 0).getBoolean(str, false);
        } catch (Throwable unused) {
            return false;
        }
    }

    @SuppressLint({"ApplySharedPref"})
    public static void a(Context context, String str, long j10) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putLong(str, j10).commit();
        } catch (Throwable unused) {
        }
    }

    private static long b(Context context, String str, long j10) {
        try {
            return context.getSharedPreferences("kssdk_api_pref", 0).getLong(str, 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }
}
