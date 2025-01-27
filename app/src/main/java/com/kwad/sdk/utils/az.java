package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.io.File;

/* loaded from: classes2.dex */
public final class az {

    /* renamed from: com.kwad.sdk.utils.az$1 */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ String aAB;
        final /* synthetic */ String asa;
        final /* synthetic */ Context jN;

        AnonymousClass1(Context context, String str, String str2) {
            context = context;
            str = str;
            str2 = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            az.k(context, str, str2);
        }
    }

    public static boolean Es() {
        return y.i("ksadsdk_pref", "config_data_transfer", false);
    }

    private static void Et() {
        y.h("ksadsdk_pref", "config_data_transfer", true);
    }

    public static void Eu() {
        y.h("ksadsdk_pref", "splash_daily_transfer", true);
    }

    public static boolean Ev() {
        return y.i("ksadsdk_pref", "splash_daily_transfer", false);
    }

    public static void Ew() {
        y.h("ksadsdk_pref", "reward_auto_transfer", true);
    }

    public static boolean Ex() {
        return y.i("ksadsdk_pref", "reward_auto_transfer", false);
    }

    public static void Ey() {
        y.h("ksadsdk_pref", "interstitial_aggregate_transfer", true);
    }

    public static boolean Ez() {
        return y.i("ksadsdk_pref", "interstitial_aggregate_transfer", false);
    }

    @Nullable
    @WorkerThread
    public static String ap(Context context, String str) {
        File file = new File(context.getFilesDir(), str);
        if (!file.exists()) {
            return "";
        }
        try {
            String D = com.kwad.sdk.crash.utils.h.D(file);
            return TextUtils.isEmpty(D) ? "" : D;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void j(Context context, String str, String str2) {
        g.execute(new Runnable() { // from class: com.kwad.sdk.utils.az.1
            final /* synthetic */ String aAB;
            final /* synthetic */ String asa;
            final /* synthetic */ Context jN;

            AnonymousClass1(Context context2, String str3, String str22) {
                context = context2;
                str = str3;
                str2 = str22;
            }

            @Override // java.lang.Runnable
            public final void run() {
                az.k(context, str, str2);
            }
        });
    }

    public static void k(Context context, String str, String str2) {
        com.kwad.sdk.crash.utils.h.g(new File(context.getFilesDir(), str).getAbsolutePath(), str2, false);
        Et();
    }
}
