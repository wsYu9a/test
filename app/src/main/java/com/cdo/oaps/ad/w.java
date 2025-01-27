package com.cdo.oaps.ad;

import android.content.Context;
import android.text.TextUtils;
import com.opos.acs.st.utils.ErrorContants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* loaded from: classes.dex */
public class w {

    /* renamed from: a */
    private static final String f6566a = "utf-8";

    /* renamed from: b */
    private static final String f6567b = "?&scheme=gamecenter";

    /* renamed from: c */
    private static final String f6568c = "&jump_from_where=from_gc_sdk_start_up";

    /* renamed from: d */
    private static final String f6569d = "&params=";

    /* renamed from: e */
    private static final String f6570e = "&detailId=";

    /* renamed from: f */
    private static final String f6571f = "&url=";

    /* renamed from: g */
    private static final String f6572g = "&host=goto_maintab_page";

    /* renamed from: h */
    private static final String f6573h = "&host=goto_gamedetail";

    /* renamed from: i */
    private static final String f6574i = "&host=goto_special";

    /* renamed from: j */
    private static final String f6575j = "&host=goto_strategy";
    private static final String k = "&host=goto_gift_detail";
    private static final String l = "&host=goto_gift_detail_without_related_game";
    private static final String m = "&host=goto_active_detail";
    private static final String n = "&host=goto_active_detail_without_related_game";
    private static final String o = "&host=goto_earn_nbean";
    private static final String p = "&host=goto_duiba";

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = ErrorContants.NET_ERROR;
        }
        try {
            return URLEncoder.encode("&jump_from_where=" + str, f6566a);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static String a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = ErrorContants.NET_ERROR;
        }
        try {
            return URLEncoder.encode("&jump_from_where=" + str2 + str, f6566a);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean a(Context context) {
        return y.a(context.getPackageManager(), f6567b);
    }

    public static boolean a(Context context, long j2, String str) {
        String a2 = a(f6570e + String.valueOf(j2), str);
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        return y.a(context, f6567b + f6573h + f6569d + a2);
    }

    public static boolean a(Context context, String str) {
        String a2 = a(str);
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        return y.a(context, f6567b + f6572g + f6569d + a2);
    }

    public static boolean a(Context context, String str, long j2, String str2) {
        String a2 = a(f6570e + String.valueOf(j2) + f6571f + str, str2);
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        return y.a(context, f6567b + k + f6569d + a2);
    }

    public static boolean a(Context context, String str, String str2) {
        String a2 = a(f6571f + str, str2);
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        return y.a(context, f6567b + l + f6569d + a2);
    }

    public static float b(Context context) {
        return y.b(context.getPackageManager(), f6567b);
    }

    public static boolean b(Context context, long j2, String str) {
        String a2 = a(f6570e + String.valueOf(j2), str);
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        return y.a(context, f6567b + f6574i + f6569d + a2);
    }

    public static boolean b(Context context, String str) {
        String a2 = a(str);
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        return y.a(context, f6567b + o + f6569d + a2);
    }

    public static boolean b(Context context, String str, long j2, String str2) {
        String a2 = a(f6570e + String.valueOf(j2) + f6571f + str, str2);
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        return y.a(context, f6567b + m + f6569d + a2);
    }

    public static boolean b(Context context, String str, String str2) {
        String a2 = a(f6571f + str, str2);
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        return y.a(context, f6567b + n + f6569d + a2);
    }

    public static boolean c(Context context, long j2, String str) {
        String a2 = a(f6570e + String.valueOf(j2), str);
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        return y.a(context, f6567b + f6575j + f6569d + a2);
    }

    public static boolean c(Context context, String str) {
        String a2 = a(str);
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        return y.a(context, f6567b + p + f6569d + a2);
    }
}
