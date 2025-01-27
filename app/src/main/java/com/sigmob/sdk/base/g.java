package com.sigmob.sdk.base;

import com.czhj.sdk.common.ClientMetadata;

/* loaded from: classes4.dex */
public class g {

    /* renamed from: a */
    public static final String f18128a = "sig_ad";

    /* renamed from: b */
    public static final String f18129b = "sig_close";

    /* renamed from: c */
    public static final String f18130c = "sig_back";

    /* renamed from: d */
    public static final String f18131d = "sig_skip_args_1";

    /* renamed from: e */
    public static final String f18132e = "sig_skip_args_2";

    /* renamed from: f */
    public static final String f18133f = "sig_skip_ad_args";

    /* renamed from: g */
    public static final String f18134g = "sig_close_args";

    /* renamed from: h */
    public static final String f18135h = "sig_close_ad_title";

    /* renamed from: i */
    public static final String f18136i = "sig_close_ad_message";

    /* renamed from: j */
    public static final String f18137j = "sig_close_ad_cancel";

    /* renamed from: k */
    public static final String f18138k = "sig_close_ad_ok";

    /* renamed from: l */
    public static final String f18139l = "sig_custom_dialog";

    /* renamed from: m */
    public static final String f18140m = "sig_dialog_window_anim";

    /* renamed from: n */
    public static final String f18141n = "sig_transparent_style";

    /* renamed from: o */
    public static final String f18142o = "sig_base_theme";

    /* renamed from: p */
    public static final String f18143p = "sig_land_theme";

    /* renamed from: q */
    public static final String f18144q = "sig_transparent_lang";

    /* renamed from: r */
    public static final String f18145r = "sig_custom_fullscreen_dialog";

    public static String a() {
        return ClientMetadata.getInstance().getStringResources(f18137j, "继续观看");
    }

    public static String b() {
        return ClientMetadata.getInstance().getStringResources(f18136i, "仅需再浏览 _SEC_ 秒广告，即可领取奖励");
    }

    public static String c() {
        return ClientMetadata.getInstance().getStringResources(f18138k, "关闭广告");
    }

    public static String d() {
        return ClientMetadata.getInstance().getStringResources(f18135h, "要放弃领取奖励吗?");
    }

    public static String e() {
        return ClientMetadata.getInstance().getStringResources(f18128a, "广告");
    }

    public static String f() {
        return ClientMetadata.getInstance().getStringResources(f18130c, "返回");
    }

    public static String g() {
        return ClientMetadata.getInstance().getStringResources(f18129b, "跳过");
    }

    public static int h() {
        return ClientMetadata.getInstance().getStyleResources(f18142o);
    }

    public static int i() {
        return ClientMetadata.getInstance().getStyleResources(f18139l);
    }

    public static int j() {
        return ClientMetadata.getInstance().getStyleResources(ClientMetadata.getInstance().getDisplayMetrics().widthPixels > ClientMetadata.getInstance().getDisplayMetrics().heightPixels ? f18145r : f18139l);
    }

    public static int k() {
        return ClientMetadata.getInstance().getStyleResources(f18140m);
    }

    public static int l() {
        return ClientMetadata.getInstance().getStyleResources(f18143p);
    }

    public static int m() {
        return ClientMetadata.getInstance().getStyleResources(f18144q);
    }

    public static int n() {
        return ClientMetadata.getInstance().getStyleResources(f18141n);
    }

    public static String a(Object... objArr) {
        return ClientMetadata.getInstance().getStringResources(f18134g, "%s 跳过", objArr);
    }

    public static String b(Object... objArr) {
        return ClientMetadata.getInstance().getStringResources(f18133f, "跳过广告 %d", objArr);
    }

    public static String c(Object... objArr) {
        return ClientMetadata.getInstance().getStringResources(f18131d, "跳过 %d", objArr);
    }

    public static String d(Object... objArr) {
        return ClientMetadata.getInstance().getStringResources(f18132e, "%d 跳过", objArr);
    }
}
