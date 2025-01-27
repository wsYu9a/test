package com.cdo.oaps.ad;

import android.content.Context;
import android.net.Uri;

/* loaded from: classes.dex */
class z {
    private static String a(long j2, String str, int i2, String str2, String str3, String str4, int i3) {
        String str5;
        StringBuilder sb = new StringBuilder();
        sb.append("out_operator#");
        sb.append(str3);
        if (ab.a(str4)) {
            str5 = "";
        } else {
            str5 = "^out_match_type#" + str4;
        }
        sb.append(str5);
        return Uri.encode("out_package_name=" + str + "&out_pid=" + j2 + "&out_operator_type=" + i2 + "&out_intent_from=" + i3 + "&enter_id=" + str2 + "&enter_params=" + sb.toString());
    }

    private static String a(long j2, String str, boolean z, String str2, String str3, String str4, int i2, String str5) {
        String str6;
        String str7 = "Ext-Module#" + str5;
        StringBuilder sb = new StringBuilder();
        sb.append("out_operator#");
        sb.append(str3);
        if (ab.a(str4)) {
            str6 = "";
        } else {
            str6 = "^out_match_type#" + str4;
        }
        sb.append(str6);
        return Uri.encode("out_pid=" + j2 + "&out_package_name=" + str + "&out_start_download=" + z + "&out_intent_from=" + i2 + "&enter_id=" + str2 + "&enter_params=" + sb.toString() + "&cpd_params=" + str7);
    }

    public static String a(Context context, long j2, String str, int i2, String str2, String str3, String str4, int i3) {
        return "softmarket://market_pre_download?params=" + a(j2, str, i2, str2, str3, str4, i3);
    }

    public static String a(Context context, long j2, String str, boolean z, boolean z2, String str2, String str3, String str4, int i2, String str5) {
        return "softmarket://market_appdetail?params=" + a(j2, str, z, str2, str3, str4, i2, str5) + "&" + y.f6599f + "=" + (z2 ? 1 : 0);
    }

    public static String a(Context context, String str, String str2, boolean z) {
        return "softmarket://market_mainmenu?params=" + a(str, str2) + "&" + y.f6599f + "=" + (z ? 1 : 0);
    }

    public static String a(Context context, String str, String str2, boolean z, boolean z2, String str3, String str4, String str5, int i2) {
        return "softmarket://market_search_result?params=" + a(str, str2, z, str3, str4, str5, i2) + "&" + y.f6599f + "=" + (z2 ? 1 : 0);
    }

    public static String a(Context context, String str, boolean z, String str2, String str3, String str4, int i2, String str5) {
        return "softmarket://market_latestact?params=" + a(str, str2, str3, str4, i2, str4) + "&" + y.f6599f + "=" + (z ? 1 : 0);
    }

    private static String a(String str, String str2) {
        return Uri.encode("enter_id=" + str + "&enter_params=" + ("out_operator#" + str2));
    }

    public static String a(String str, String str2, String str3, String str4, int i2, String str5) {
        String str6;
        String str7 = "Ext-Module#" + str5;
        StringBuilder sb = new StringBuilder();
        sb.append("out_operator#");
        sb.append(str3);
        if (ab.a(str4)) {
            str6 = "";
        } else {
            str6 = "^out_match_type#" + str4;
        }
        sb.append(str6);
        return Uri.encode("url=" + str + "&out_intent_from=" + i2 + "&enter_id=" + str2 + "&enter_params=" + sb.toString() + "&cpd_params=" + str7);
    }

    private static String a(String str, String str2, boolean z, String str3, String str4, String str5, int i2) {
        String str6;
        StringBuilder sb = new StringBuilder();
        sb.append("out_operator#");
        sb.append(str4);
        if (ab.a(str5)) {
            str6 = "";
        } else {
            str6 = "^out_match_type#" + str5;
        }
        sb.append(str6);
        return Uri.encode("out_package_name=" + str2 + "&out_app_name=" + str + "&out_operator=" + str4 + "&out_start_download=" + z + "&out_intent_from=" + i2 + "&enter_id=" + str3 + "&enter_params=" + sb.toString());
    }
}
