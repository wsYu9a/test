package com.cdo.oaps.ad;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import java.util.List;

/* loaded from: classes.dex */
class t {
    public static String a(long j2, String str, boolean z, String str2, String str3, int i2, String str4) {
        return Uri.encode("out_pid=" + j2 + "&out_package_name=" + str + "&out_start_download=" + z + "&out_intent_from=" + i2 + "&enter_id=" + str2 + "&out_operator=" + str3 + "&out_match_type=" + str4);
    }

    public static String a(Context context, long j2, String str, boolean z, boolean z2, String str2, String str3, int i2, String str4) {
        return "softmarket://market_appdetail?params=" + a(j2, str, z, str2, str3, i2, str4) + "&" + y.f6599f + "=" + (z2 ? 1 : 0);
    }

    public static String a(Context context, String str, String str2, boolean z) {
        return "softmarket://market_mainmenu?params=" + a(str, str2) + "&" + y.f6599f + "=" + (z ? 1 : 0);
    }

    public static String a(Context context, String str, String str2, boolean z, boolean z2, String str3, String str4, String str5, int i2) {
        return "softmarket://market_search_result?params=" + a(str, str2, z, str3, str4, i2, str5) + "&" + y.f6599f + "=" + (z2 ? 1 : 0);
    }

    public static String a(Context context, String str, boolean z, String str2, String str3, int i2, String str4) {
        return "softmarket://market_latestact?params=" + a(str, str2, str3, i2, str4) + "&" + y.f6599f + "=" + (z ? 1 : 0);
    }

    private static String a(String str, String str2) {
        return Uri.encode("enter_id=" + str + "&out_operator=" + str2);
    }

    public static String a(String str, String str2, String str3, int i2, String str4) {
        return Uri.encode("url=" + str + "&out_intent_from=" + i2 + "&enter_id=" + str2 + "&out_operator=" + str3 + "&out_match_type=" + str4);
    }

    private static String a(String str, String str2, boolean z, String str3, String str4, int i2, String str5) {
        return Uri.encode("out_package_name=" + str2 + "&out_app_name=" + str + "&out_operator=" + str4 + "&out_start_download=" + z + "&out_intent_from=" + i2 + "&enter_id=" + str3 + "&out_operator=" + str4 + "&out_match_type=" + str5);
    }

    public static boolean a(Context context, long j2, String str, String str2, int i2, String str3, String str4, String str5) {
        Intent intent = new Intent();
        intent.setAction(str5);
        intent.setPackage(af.b(context));
        intent.putExtra("out_pid", j2);
        intent.putExtra("out_package_name", str);
        intent.putExtra("out_operator", str2);
        intent.putExtra("out_match_type", str4);
        intent.putExtra("out_intent_from", i2);
        intent.putExtra("enter_id", str3);
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 32);
        if (queryIntentServices == null || queryIntentServices.size() <= 0) {
            return false;
        }
        context.startService(intent);
        return true;
    }
}
