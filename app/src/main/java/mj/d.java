package mj;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.meituan.android.walle.WalleChannelReader;
import com.sntech.ads.SNAdConfig;
import com.umeng.analytics.AnalyticsConfig;
import org.json.JSONException;
import org.json.JSONObject;
import p002continue.f;

/* loaded from: classes4.dex */
public final class d {
    public static String a(Context context, String str) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null) {
                return null;
            }
            return (String) bundle.get(str);
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static JSONObject b(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            SNAdConfig sNAdConfig = f.b.f25213a.f25209d;
            String str = null;
            jSONObject.put("channel", sNAdConfig == null ? null : sNAdConfig.getChannel());
            String a10 = a(context, "UMENG_CHANNEL");
            if (TextUtils.isEmpty(a10)) {
                try {
                    Class.forName("com.umeng.analytics.AnalyticsConfig");
                    a10 = AnalyticsConfig.getChannel(context);
                } catch (ClassNotFoundException unused) {
                }
            }
            jSONObject.put("umeng", a10);
            jSONObject.put("talkingData", a(context, "TD_CHANNEL_ID"));
            try {
                Class.forName("com.meituan.android.walle.WalleChannelReader");
                str = WalleChannelReader.getChannel(context, "");
            } catch (ClassNotFoundException unused2) {
            }
            jSONObject.put("walle", str);
        } catch (JSONException unused3) {
        }
        return jSONObject;
    }
}
