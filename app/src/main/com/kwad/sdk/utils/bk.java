package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.io.File;

/* loaded from: classes3.dex */
public final class bk {

    /* renamed from: com.kwad.sdk.utils.bk$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ String aLj;
        final /* synthetic */ String aUL;
        final /* synthetic */ Context hB;

        public AnonymousClass1(Context context, String str, String str2) {
            context = context;
            str = str;
            str2 = str2;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            bk.j(context, str, str2);
        }
    }

    public static boolean OH() {
        return ad.m("ksadsdk_pref", "config_data_transfer", false);
    }

    private static void OI() {
        ad.l("ksadsdk_pref", "config_data_transfer", true);
    }

    public static void OJ() {
        ad.l("ksadsdk_pref", "splash_daily_transfer", true);
    }

    public static boolean OK() {
        return ad.m("ksadsdk_pref", "splash_daily_transfer", false);
    }

    public static void OL() {
        ad.l("ksadsdk_pref", "reward_auto_transfer", true);
    }

    public static boolean OM() {
        return ad.m("ksadsdk_pref", "reward_auto_transfer", false);
    }

    public static void ON() {
        ad.l("ksadsdk_pref", "interstitial_aggregate_transfer", true);
    }

    public static boolean OO() {
        return ad.m("ksadsdk_pref", "interstitial_aggregate_transfer", false);
    }

    @Nullable
    @WorkerThread
    public static String av(Context context, String str) {
        if (context == null) {
            return "";
        }
        File file = new File(context.getFilesDir(), str);
        if (!file.exists()) {
            return "";
        }
        try {
            String J = com.kwad.sdk.crash.utils.h.J(file);
            return TextUtils.isEmpty(J) ? "" : J;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void i(Context context, String str, String str2) {
        h.execute(new bd() { // from class: com.kwad.sdk.utils.bk.1
            final /* synthetic */ String aLj;
            final /* synthetic */ String aUL;
            final /* synthetic */ Context hB;

            public AnonymousClass1(Context context2, String str3, String str22) {
                context = context2;
                str = str3;
                str2 = str22;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                bk.j(context, str, str2);
            }
        });
    }

    public static void j(Context context, String str, String str2) {
        if (context != null) {
            com.kwad.sdk.crash.utils.h.k(new File(context.getFilesDir(), str).getAbsolutePath(), str2, false);
            OI();
        }
    }
}
