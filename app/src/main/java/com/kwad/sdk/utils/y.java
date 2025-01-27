package com.kwad.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Map;

/* loaded from: classes2.dex */
public final class y {
    private static String sAppTag = "";

    /* renamed from: com.kwad.sdk.utils.y$1 */
    static class AnonymousClass1 extends aw {
        final /* synthetic */ String azQ;

        AnonymousClass1(String str) {
            str = str;
        }

        @Override // com.kwad.sdk.utils.aw
        public final void doTask() {
            y.aa(ServiceProvider.getContext(), str);
        }
    }

    public static void DA() {
        b("ksadsdk_perf", "image_load_total", c("ksadsdk_perf", "image_load_total", 0) + 1);
    }

    public static void DB() {
        b("ksadsdk_perf", "image_load_suc", c("ksadsdk_perf", "image_load_suc", 0) + 1);
    }

    public static void DC() {
        b("ksadsdk_perf", "image_load_failed", c("ksadsdk_perf", "image_load_failed", 0) + 1);
    }

    public static double DD() {
        int c2 = c("ksadsdk_perf", "image_load_complete_count", 0);
        long b2 = b("ksadsdk_perf", "image_load_complete_total", 0L);
        b("ksadsdk_perf", "image_load_complete_count", 0);
        a("ksadsdk_perf", "image_load_complete_total", 0L);
        if (c2 == 0) {
            return 0.0d;
        }
        double d2 = b2;
        double d3 = c2;
        Double.isNaN(d2);
        Double.isNaN(d3);
        return d2 / d3;
    }

    public static int DE() {
        int c2 = c("ksadsdk_perf", "image_load_total", 0);
        com.kwad.sdk.core.d.b.d("Ks_UnionUtils", "imageLoadTotal:" + c2);
        b("ksadsdk_perf", "image_load_total", 0);
        return c2;
    }

    public static int DF() {
        int c2 = c("ksadsdk_perf", "image_load_suc", 0);
        com.kwad.sdk.core.d.b.d("Ks_UnionUtils", "imageLoadSuccess:" + c2);
        b("ksadsdk_perf", "image_load_suc", 0);
        return c2;
    }

    public static int DG() {
        int c2 = c("ksadsdk_perf", "image_load_failed", 0);
        com.kwad.sdk.core.d.b.d("Ks_UnionUtils", "imageLoadFailed:" + c2);
        b("ksadsdk_perf", "image_load_failed", 0);
        return c2;
    }

    public static String Dp() {
        Context context = getContext();
        return context == null ? "" : b(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_DAILY_SHOW_COUNT", "");
    }

    public static String Dq() {
        Context context = getContext();
        if (context == null) {
            return "";
        }
        return b(context, az.Ez() ? "ksadsdk_interstitial_daily_show_count" : "ksadsdk_interstitial_aggregate_daily_show_count", "KEY_INTERSTITIAL_AGGREGATE_DAILY_SHOW_COUNT", "");
    }

    public static String Dr() {
        Context context = getContext();
        return context == null ? "" : b(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_FULL_AD_JUMP_DIRECT", "");
    }

    public static String Ds() {
        Context context = getContext();
        if (context == null) {
            return "";
        }
        return b(context, az.Ev() ? "ksadsdk_splash_local_ad_force_active" : "ksadsdk_splash_daily_show_count", "KEY_SPLASH_DAILY_SHOW_COUNT", "");
    }

    public static String Dt() {
        Context context = getContext();
        return context == null ? "" : az.Ex() ? h("ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AUTO_CALL_APP_CARD_SHOW_COUNT", "") : b(context, "ksadsdk_reward_auto_call_app_card_show_count", "KEY_REWARD_AUTO_CALL_APP_CARD_SHOW_COUNT", "");
    }

    public static String Du() {
        return h("ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_AUTO_CALL_APP_CARD_SHOW_COUNT", "");
    }

    public static String Dv() {
        if (!TextUtils.isEmpty(sAppTag)) {
            return sAppTag;
        }
        Context context = getContext();
        return context == null ? "" : b(context, "ksadsdk_pref", "appTag", "");
    }

    public static String Dw() {
        Context context = getContext();
        return context == null ? "" : bP(context);
    }

    public static long Dx() {
        return b("ksadsdk_push_ad_common", "key_push_last_show_time", -1L);
    }

    public static String Dy() {
        return h("ksadsdk_splash_local_ad_force_active", "key_splash_end_card_info", (String) null);
    }

    public static String Dz() {
        return getContext() == null ? "" : h("ksadsdk_install_tips_show_count", "init_install_tips_show_count", "");
    }

    public static long M(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        return b(context, "ksadsdk_pref", str, 0L);
    }

    public static long N(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        return b(context, "ksadsdk_download_package_length", str, 0L);
    }

    public static String O(Context context, String str) {
        return context == null ? "" : b(context, "ksadsdk_download_package_md5", str, "");
    }

    public static void P(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_egid", "KEY_SDK_EGID", str);
    }

    public static void Q(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a("ksadsdk_model", "KEY_SDK_MODEL", str, true);
    }

    public static void R(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_DAILY_SHOW_COUNT", str);
    }

    public static void S(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_AGGREGATE_DAILY_SHOW_COUNT", str);
        az.Ey();
    }

    public static void T(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_INTERACT_AD_SHOW_INFO", str);
    }

    public static void U(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_FULL_AD_JUMP_DIRECT", str);
    }

    public static void V(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_splash_local_ad_force_active", "KEY_SPLASH_DAILY_SHOW_COUNT", str);
        az.Eu();
    }

    public static void W(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AUTO_CALL_APP_CARD_SHOW_COUNT", str);
        az.Ew();
    }

    public static void X(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_AUTO_CALL_APP_CARD_SHOW_COUNT", str);
    }

    public static void Y(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_device_sig", "KEY_SDK_DEVICE_SIG", str);
    }

    public static void Z(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        g.execute(new aw() { // from class: com.kwad.sdk.utils.y.1
            final /* synthetic */ String azQ;

            AnonymousClass1(String str2) {
                str = str2;
            }

            @Override // com.kwad.sdk.utils.aw
            public final void doTask() {
                y.aa(ServiceProvider.getContext(), str);
            }
        });
    }

    private static void a(Context context, String str, String str2, int i2) {
        if (context == null) {
            return;
        }
        if (x.Di()) {
            ba.b(str, str2, i2);
        } else {
            com.kwad.sdk.utils.kwai.e.aq(context, str).putInt(str2, i2);
        }
    }

    private static void a(Context context, String str, String str2, long j2) {
        if (context == null) {
            return;
        }
        if (x.Di()) {
            ba.a(str, str2, j2);
        } else {
            com.kwad.sdk.utils.kwai.e.aq(context, str).putLong(str2, j2);
        }
    }

    public static void a(Context context, @NonNull String str, @NonNull String str2, String str3) {
        if (context == null) {
            return;
        }
        if (x.Di()) {
            ba.g(str, str2, str3);
            if (com.kwad.b.kwai.a.bI.booleanValue()) {
                com.kwad.sdk.core.d.b.d("Ks_UnionUtils", "putString Sp key:" + str2 + " value:" + str3);
                return;
            }
            return;
        }
        com.kwad.sdk.utils.kwai.e.aq(context, str).putString(str2, str3);
        if (com.kwad.b.kwai.a.bI.booleanValue()) {
            com.kwad.sdk.core.d.b.d("Ks_UnionUtils", "putString key:" + str2 + " value:" + str3);
        }
        x.ac(str2, str3);
    }

    private static void a(Context context, @NonNull String str, @NonNull String str2, String str3, boolean z) {
        if (context == null) {
            return;
        }
        if (x.Di()) {
            ba.a(str, str2, str3, z);
            if (com.kwad.b.kwai.a.bI.booleanValue()) {
                com.kwad.sdk.core.d.b.d("Ks_UnionUtils", "putString Sp key:" + str2 + " value:" + str3);
                return;
            }
            return;
        }
        com.kwad.sdk.utils.kwai.e.aq(context, str).putString(str2, str3);
        if (com.kwad.b.kwai.a.bI.booleanValue()) {
            com.kwad.sdk.core.d.b.d("Ks_UnionUtils", "putString key:" + str2 + " value:" + str3);
        }
        x.ac(str2, str3);
    }

    public static void a(String str, String str2, long j2) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, j2);
    }

    public static void a(String str, String str2, String str3, boolean z) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, str3, true);
    }

    public static void aa(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_pref", "appTag", str);
    }

    public static void ab(Context context, String str) {
        if (context == null) {
            return;
        }
        a("ksadsdk_pref", "webview_ua", str, true);
    }

    @WorkerThread
    public static void ac(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        az.k(context.getApplicationContext(), "ksadsdk_sdk_config_data", str);
    }

    public static void ad(Context context, String str) {
        if (context == null) {
            return;
        }
        g("ksadsdk_splash_local_ad_force_active", "key_splash_end_card_info", str);
    }

    public static void ae(Context context, String str) {
        if (context == null) {
            return;
        }
        g("ksadsdk_install_tips_show_count", "init_install_tips_show_count", str);
    }

    public static void ae(String str, String str2) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        i(context, str, str2);
    }

    public static Map<String, ?> af(Context context, String str) {
        if (context == null) {
            return null;
        }
        if (!x.Di()) {
            return com.kwad.sdk.utils.kwai.e.aq(context, str).getAll();
        }
        SharedPreferences eN = ba.eN(str);
        if (eN != null) {
            return eN.getAll();
        }
        return null;
    }

    public static void ag(long j2) {
        a("ksadsdk_push_ad_common", "key_push_last_show_time", j2);
    }

    public static void ah(long j2) {
        b("ksadsdk_perf", "image_load_complete_count", c("ksadsdk_perf", "image_load_complete_count", 0) + 1);
        a("ksadsdk_perf", "image_load_complete_total", b("ksadsdk_perf", "image_load_complete_total", 0L) + j2);
    }

    private static int b(Context context, String str, String str2, int i2) {
        return context == null ? i2 : x.Di() ? ba.c(str, str2, i2) : com.kwad.sdk.utils.kwai.e.aq(context, str).getInt(str2, i2);
    }

    private static long b(Context context, String str, String str2, long j2) {
        return context == null ? j2 : x.Di() ? ba.b(str, str2, j2) : com.kwad.sdk.utils.kwai.e.aq(context, str).getLong(str2, j2);
    }

    public static long b(String str, String str2, long j2) {
        Context context = getContext();
        return context == null ? j2 : b(context, str, str2, j2);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b(android.content.Context r3, java.lang.String r4, java.lang.String r5, java.lang.String r6) {
        /*
            if (r3 != 0) goto L3
            return r6
        L3:
            boolean r0 = com.kwad.sdk.utils.x.Di()
            java.lang.String r1 = " value:"
            java.lang.String r2 = "Ks_UnionUtils"
            if (r0 == 0) goto L31
            java.lang.String r3 = com.kwad.sdk.utils.ba.h(r4, r5, r6)
            java.lang.Boolean r4 = com.kwad.b.kwai.a.bI
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L4f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r6 = "getString From Sp key:"
            r4.<init>(r6)
        L20:
            r4.append(r5)
            r4.append(r1)
            r4.append(r3)
            java.lang.String r4 = r4.toString()
            com.kwad.sdk.core.d.b.d(r2, r4)
            goto L4f
        L31:
            com.kwad.sdk.utils.kwai.e.aq(r3, r4)
            com.kwad.sdk.utils.kwai.c r3 = com.kwad.sdk.utils.kwai.e.aq(r3, r4)
            java.lang.String r3 = r3.getString(r5, r6)
            com.kwad.sdk.utils.x.ad(r5, r3)
            java.lang.Boolean r4 = com.kwad.b.kwai.a.bI
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L4f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r6 = "getString key:"
            r4.<init>(r6)
            goto L20
        L4f:
            boolean r4 = com.kwad.sdk.core.kwai.c.bY(r3)
            if (r4 == 0) goto L59
            java.lang.String r3 = com.kwad.sdk.core.kwai.c.bX(r3)
        L59:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.y.b(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public static void b(Context context, String str, String str2, boolean z) {
        if (context == null) {
            return;
        }
        h("ksadsdk_solder", "solder_is_success_loaded_" + str + str2, z);
    }

    public static void b(String str, String str2, int i2) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, i2);
    }

    public static String bP(@NonNull Context context) {
        return context == null ? "" : b(context, "ksadsdk_egid", "KEY_SDK_EGID", "");
    }

    public static long bQ(@NonNull Context context) {
        if (context == null) {
            return 0L;
        }
        return b(context, "ksadsdk_gidExpireTimeMs", "KEY_SDK_EGID", 0L);
    }

    public static int bR(@NonNull Context context) {
        if (context == null) {
            return 0;
        }
        return b(context, "ksadsdk_config_request", "KEY_CONFIG_REQUEST_FAIL", 0);
    }

    public static String bS(@NonNull Context context) {
        if (context == null) {
            return "";
        }
        String b2 = b(context, "ksadsdk_model", "KEY_SDK_MODEL", "");
        ba.i(b2, "ksadsdk_model", "KEY_SDK_MODEL");
        return b2;
    }

    public static int bT(@NonNull Context context) {
        if (context == null) {
            return 0;
        }
        return b(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AD_SHOW_INTERACT_INTERVAL_SHOW_COUNT", 0);
    }

    public static String bU(@NonNull Context context) {
        return context == null ? "" : b(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_INTERACT_AD_SHOW_INFO", "");
    }

    public static String bV(@NonNull Context context) {
        return context == null ? "" : b(context, "ksadsdk_device_sig", "KEY_SDK_DEVICE_SIG", "");
    }

    public static String bW(Context context) {
        if (context == null) {
            return "";
        }
        String h2 = h("ksadsdk_pref", "webview_ua", "");
        ba.i(h2, "ksadsdk_pref", "webview_ua");
        return h2;
    }

    @WorkerThread
    public static String bX(Context context) {
        if (az.Es()) {
            return az.ap(context.getApplicationContext(), "ksadsdk_sdk_config_data");
        }
        String h2 = ba.h("ksadsdk_sdk_config_data", "config_str", "");
        az.j(context.getApplicationContext(), "ksadsdk_sdk_config_data", h2);
        return h2;
    }

    public static int c(String str, String str2, int i2) {
        Context context = getContext();
        if (context == null) {
            return 0;
        }
        return b(context, str, str2, 0);
    }

    private static void c(Context context, String str, String str2, boolean z) {
        if (context == null) {
            return;
        }
        if (x.Di()) {
            ba.h(str, str2, z);
        } else {
            com.kwad.sdk.utils.kwai.e.aq(context, str).putBoolean(str2, z);
        }
    }

    private static boolean d(Context context, String str, String str2, boolean z) {
        return context == null ? z : x.Di() ? ba.i(str, str2, z) : com.kwad.sdk.utils.kwai.e.aq(context, str).getBoolean(str2, z);
    }

    public static void e(Context context, String str, long j2) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_pref", str, j2);
    }

    public static void f(@NonNull Context context, long j2) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_gidExpireTimeMs", "KEY_SDK_EGID", j2);
    }

    public static void f(Context context, String str, long j2) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_download_package_length", str, j2);
    }

    public static void g(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_download_package_md5", str, str2);
    }

    private static void g(String str, String str2, String str3) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, str3);
    }

    @Nullable
    public static Context getContext() {
        return ServiceProvider.CA();
    }

    public static String h(String str, String str2, String str3) {
        Context context = getContext();
        return context == null ? str3 : b(context, str, str2, str3);
    }

    public static void h(String str, String str2, boolean z) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        c(context, str, str2, z);
    }

    public static boolean h(Context context, String str, String str2) {
        if (context == null) {
            return false;
        }
        return i("ksadsdk_solder", "solder_is_success_loaded_" + str + str2, false);
    }

    public static void i(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        if (x.Di()) {
            ba.ae(str, str2);
        } else {
            com.kwad.sdk.utils.kwai.e.aq(context, str).remove(str2);
            x.ac(str2, "");
        }
    }

    public static void i(String str, String str2, String str3) {
        if (x.Di()) {
            ba.i(str, str2, str3);
        }
    }

    public static boolean i(String str, String str2, boolean z) {
        Context context = getContext();
        if (context == null) {
            return false;
        }
        return d(context, str, str2, false);
    }

    public static void j(@NonNull Context context, int i2) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_config_request", "KEY_CONFIG_REQUEST_FAIL", i2);
    }

    public static void k(@NonNull Context context, int i2) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AD_SHOW_INTERACT_INTERVAL_SHOW_COUNT", i2);
    }
}
