package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes3.dex */
public final class ad {
    private static String sAppTag = "";

    /* renamed from: com.kwad.sdk.utils.ad$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ String aTL;

        public AnonymousClass1(String str) {
            str = str;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            ad.ai(ServiceProvider.getContext(), str);
        }
    }

    public static String NA() {
        Context context = getContext();
        return context == null ? "" : cq(context);
    }

    public static long NB() {
        return b("ksadsdk_push_ad_common", "key_push_last_show_time", -1L);
    }

    public static String NC() {
        return getContext() == null ? "" : h("ksadsdk_install_tips_show_count", "init_install_tips_show_count", "");
    }

    public static void ND() {
        a("ksadsdk_perf", "image_load_total", b("ksadsdk_perf", "image_load_total", 0) + 1);
    }

    public static void NE() {
        a("ksadsdk_perf", "image_load_suc", b("ksadsdk_perf", "image_load_suc", 0) + 1);
    }

    public static void NF() {
        a("ksadsdk_perf", "image_load_failed", b("ksadsdk_perf", "image_load_failed", 0) + 1);
    }

    public static double NG() {
        int b10 = b("ksadsdk_perf", "image_load_complete_count", 0);
        long b11 = b("ksadsdk_perf", "image_load_complete_total", 0L);
        a("ksadsdk_perf", "image_load_complete_count", 0);
        a("ksadsdk_perf", "image_load_complete_total", 0L);
        return b10 == 0 ? l5.c.f27899e : b11 / b10;
    }

    public static int NH() {
        int b10 = b("ksadsdk_perf", "image_load_total", 0);
        com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "imageLoadTotal:" + b10);
        a("ksadsdk_perf", "image_load_total", 0);
        return b10;
    }

    public static int NI() {
        int b10 = b("ksadsdk_perf", "image_load_suc", 0);
        com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "imageLoadSuccess:" + b10);
        a("ksadsdk_perf", "image_load_suc", 0);
        return b10;
    }

    public static int NJ() {
        int b10 = b("ksadsdk_perf", "image_load_failed", 0);
        com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "imageLoadFailed:" + b10);
        a("ksadsdk_perf", "image_load_failed", 0);
        return b10;
    }

    public static String Nt() {
        Context context = getContext();
        return context == null ? "" : b(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_DAILY_SHOW_COUNT", "");
    }

    public static String Nu() {
        Context context = getContext();
        return context == null ? "" : bk.OO() ? b(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_AGGREGATE_DAILY_SHOW_COUNT", "") : b(context, "ksadsdk_interstitial_aggregate_daily_show_count", "KEY_INTERSTITIAL_AGGREGATE_DAILY_SHOW_COUNT", "");
    }

    public static String Nv() {
        Context context = getContext();
        return context == null ? "" : b(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_FULL_AD_JUMP_DIRECT", "");
    }

    public static String Nw() {
        Context context = getContext();
        return context == null ? "" : bk.OK() ? b(context, "ksadsdk_splash_local_ad_force_active", "KEY_SPLASH_DAILY_SHOW_COUNT", "") : b(context, "ksadsdk_splash_daily_show_count", "KEY_SPLASH_DAILY_SHOW_COUNT", "");
    }

    public static String Nx() {
        Context context = getContext();
        return context == null ? "" : bk.OM() ? h("ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AUTO_CALL_APP_CARD_SHOW_COUNT", "") : b(context, "ksadsdk_reward_auto_call_app_card_show_count", "KEY_REWARD_AUTO_CALL_APP_CARD_SHOW_COUNT", "");
    }

    public static String Ny() {
        return h("ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_AUTO_CALL_APP_CARD_SHOW_COUNT", "");
    }

    public static String Nz() {
        if (!TextUtils.isEmpty(sAppTag)) {
            return sAppTag;
        }
        Context context = getContext();
        return context == null ? "" : b(context, "ksadsdk_pref", "appTag", "");
    }

    public static long U(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        return b(context, "ksadsdk_pref", str, 0L);
    }

    public static long V(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        return b(context, "ksadsdk_download_package_length", str, 0L);
    }

    public static String W(Context context, String str) {
        return context == null ? "" : b(context, "ksadsdk_download_package_md5", str, "");
    }

    public static void X(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_egid", "KEY_SDK_EGID", str);
    }

    public static void Y(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a("ksadsdk_model", "KEY_SDK_MODEL", str, true);
    }

    public static void Z(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_DAILY_SHOW_COUNT", str);
    }

    public static void a(String str, String str2, String str3, boolean z10) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, str3, true);
    }

    public static void aO(long j10) {
        a("ksadsdk_push_ad_common", "key_push_last_show_time", j10);
    }

    public static void aP(long j10) {
        a("ksadsdk_perf", "image_load_complete_count", b("ksadsdk_perf", "image_load_complete_count", 0) + 1);
        a("ksadsdk_perf", "image_load_complete_total", b("ksadsdk_perf", "image_load_complete_total", 0L) + j10);
    }

    public static void aa(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_AGGREGATE_DAILY_SHOW_COUNT", str);
        bk.ON();
    }

    public static void ab(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_INTERACT_AD_SHOW_INFO", str);
    }

    public static void ac(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_FULL_AD_JUMP_DIRECT", str);
    }

    public static void ad(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_splash_local_ad_force_active", "KEY_SPLASH_DAILY_SHOW_COUNT", str);
        bk.OJ();
    }

    public static void ae(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AUTO_CALL_APP_CARD_SHOW_COUNT", str);
        bk.OL();
    }

    public static void af(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_AUTO_CALL_APP_CARD_SHOW_COUNT", str);
    }

    public static void ag(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_device_sig", "KEY_SDK_DEVICE_SIG", str);
    }

    public static void ah(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        h.execute(new bd() { // from class: com.kwad.sdk.utils.ad.1
            final /* synthetic */ String aTL;

            public AnonymousClass1(String str2) {
                str = str2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                ad.ai(ServiceProvider.getContext(), str);
            }
        });
    }

    public static void ai(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_pref", "appTag", str);
    }

    public static void aj(Context context, String str) {
        if (context == null) {
            return;
        }
        a("ksadsdk_pref", "webview_ua", str, true);
    }

    @WorkerThread
    public static void ak(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        bk.j(context.getApplicationContext(), "ksadsdk_sdk_config_data", str);
    }

    public static void al(Context context, String str) {
        if (context == null) {
            return;
        }
        g("ksadsdk_install_tips_show_count", "init_install_tips_show_count", str);
    }

    private static long b(String str, String str2, long j10) {
        Context context = getContext();
        return context == null ? j10 : b(context, str, str2, j10);
    }

    private static boolean c(Context context, String str, String str2, boolean z10) {
        return context == null ? z10 : ac.Nm() ? bl.m(str, str2, z10) : com.kwad.sdk.utils.a.e.aw(context, str).getBoolean(str2, z10);
    }

    public static String cq(@NonNull Context context) {
        return context == null ? "" : b(context, "ksadsdk_egid", "KEY_SDK_EGID", "");
    }

    public static long cr(@NonNull Context context) {
        if (context == null) {
            return 0L;
        }
        return b(context, "ksadsdk_gidExpireTimeMs", "KEY_SDK_EGID", 0L);
    }

    public static int cs(@NonNull Context context) {
        if (context == null) {
            return 0;
        }
        return b(context, "ksadsdk_config_request", "KEY_CONFIG_REQUEST_FAIL", 0);
    }

    public static String ct(@NonNull Context context) {
        if (context == null) {
            return "";
        }
        String b10 = b(context, "ksadsdk_model", "KEY_SDK_MODEL", "");
        bl.i(b10, "ksadsdk_model", "KEY_SDK_MODEL");
        return b10;
    }

    public static int cu(@NonNull Context context) {
        if (context == null) {
            return 0;
        }
        return b(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AD_SHOW_INTERACT_INTERVAL_SHOW_COUNT", 0);
    }

    public static String cv(@NonNull Context context) {
        return context == null ? "" : b(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_INTERACT_AD_SHOW_INFO", "");
    }

    public static String cw(@NonNull Context context) {
        return context == null ? "" : b(context, "ksadsdk_device_sig", "KEY_SDK_DEVICE_SIG", "");
    }

    public static String cx(Context context) {
        if (context == null) {
            return "";
        }
        String h10 = h("ksadsdk_pref", "webview_ua", "");
        bl.i(h10, "ksadsdk_pref", "webview_ua");
        return h10;
    }

    @WorkerThread
    public static String cy(Context context) {
        if (bk.OH()) {
            return bk.av(context.getApplicationContext(), "ksadsdk_sdk_config_data");
        }
        String h10 = bl.h("ksadsdk_sdk_config_data", "config_str", "");
        bk.i(context.getApplicationContext(), "ksadsdk_sdk_config_data", h10);
        return h10;
    }

    public static void d(@NonNull Context context, long j10) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_gidExpireTimeMs", "KEY_SDK_EGID", j10);
    }

    public static void e(Context context, String str, long j10) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_pref", str, j10);
    }

    public static void f(Context context, String str, long j10) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_download_package_length", str, j10);
    }

    public static void g(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_download_package_md5", str, str2);
    }

    @Nullable
    public static Context getContext() {
        return ServiceProvider.MA();
    }

    public static String h(String str, String str2, String str3) {
        Context context = getContext();
        return context == null ? str3 : b(context, str, str2, str3);
    }

    public static void i(String str, String str2, String str3) {
        if (ac.Nm()) {
            bl.i(str, str2, str3);
        }
    }

    public static void l(@NonNull Context context, int i10) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_config_request", "KEY_CONFIG_REQUEST_FAIL", i10);
    }

    public static void m(@NonNull Context context, int i10) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AD_SHOW_INTERACT_INTERVAL_SHOW_COUNT", i10);
    }

    public static void g(String str, String str2, String str3) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, str3);
    }

    public static void l(String str, String str2, boolean z10) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        b(context, str, str2, z10);
    }

    public static boolean m(String str, String str2, boolean z10) {
        Context context = getContext();
        return context == null ? z10 : c(context, str, str2, z10);
    }

    private static void a(String str, String str2, long j10) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, j10);
    }

    public static int b(String str, String str2, int i10) {
        Context context = getContext();
        if (context == null) {
            return 0;
        }
        return b(context, str, str2, 0);
    }

    public static void h(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        if (ac.Nm()) {
            bl.aw(str, str2);
        } else {
            com.kwad.sdk.utils.a.e.aw(context, str).remove(str2);
            ac.ar(str2, "");
        }
    }

    public static void a(String str, String str2, int i10) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, i10);
    }

    public static String b(Context context, String str, String str2, String str3) {
        String string;
        if (context == null) {
            return str3;
        }
        if (ac.Nm()) {
            string = bl.h(str, str2, str3);
            if (com.kwad.framework.a.a.ns.booleanValue()) {
                com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "getString From Sp key:" + str2 + " value:" + string);
            }
        } else {
            com.kwad.sdk.utils.a.e.aw(context, str);
            string = com.kwad.sdk.utils.a.e.aw(context, str).getString(str2, str3);
            ac.as(str2, string);
            if (com.kwad.framework.a.a.ns.booleanValue()) {
                com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "getString key:" + str2 + " value:" + string);
            }
        }
        return com.kwad.sdk.core.a.c.dV(string) ? com.kwad.sdk.core.a.c.dU(string) : string;
    }

    public static void a(Context context, @NonNull String str, @NonNull String str2, String str3) {
        if (context == null) {
            return;
        }
        if (ac.Nm()) {
            bl.g(str, str2, str3);
            if (com.kwad.framework.a.a.ns.booleanValue()) {
                com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "putString Sp key:" + str2 + " value:" + str3);
                return;
            }
            return;
        }
        com.kwad.sdk.utils.a.e.aw(context, str).putString(str2, str3);
        if (com.kwad.framework.a.a.ns.booleanValue()) {
            com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "putString key:" + str2 + " value:" + str3);
        }
        ac.ar(str2, str3);
    }

    private static void a(Context context, @NonNull String str, @NonNull String str2, String str3, boolean z10) {
        if (context == null) {
            return;
        }
        if (ac.Nm()) {
            bl.a(str, str2, str3, z10);
            if (com.kwad.framework.a.a.ns.booleanValue()) {
                com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "putString Sp key:" + str2 + " value:" + str3);
                return;
            }
            return;
        }
        com.kwad.sdk.utils.a.e.aw(context, str).putString(str2, str3);
        if (com.kwad.framework.a.a.ns.booleanValue()) {
            com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "putString key:" + str2 + " value:" + str3);
        }
        ac.ar(str2, str3);
    }

    private static long b(Context context, String str, String str2, long j10) {
        if (context == null) {
            return j10;
        }
        if (ac.Nm()) {
            return bl.b(str, str2, j10);
        }
        return com.kwad.sdk.utils.a.e.aw(context, str).getLong(str2, j10);
    }

    private static int b(Context context, String str, String str2, int i10) {
        if (context == null) {
            return i10;
        }
        if (ac.Nm()) {
            return bl.b(str, str2, i10);
        }
        return com.kwad.sdk.utils.a.e.aw(context, str).getInt(str2, i10);
    }

    private static void b(Context context, String str, String str2, boolean z10) {
        if (context == null) {
            return;
        }
        if (ac.Nm()) {
            bl.l(str, str2, z10);
        } else {
            com.kwad.sdk.utils.a.e.aw(context, str).putBoolean(str2, z10);
        }
    }

    private static void a(Context context, String str, String str2, long j10) {
        if (context == null) {
            return;
        }
        if (ac.Nm()) {
            bl.a(str, str2, j10);
        } else {
            com.kwad.sdk.utils.a.e.aw(context, str).putLong(str2, j10);
        }
    }

    private static void a(Context context, String str, String str2, int i10) {
        if (context == null) {
            return;
        }
        if (ac.Nm()) {
            bl.a(str, str2, i10);
        } else {
            com.kwad.sdk.utils.a.e.aw(context, str).putInt(str2, i10);
        }
    }
}
