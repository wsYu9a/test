package mj;

import com.anythink.core.api.ATSDK;
import com.baidu.mobads.sdk.api.AdSettings;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.kwad.sdk.api.KsAdSDK;
import com.martian.ads.ad.AdConfig;
import com.qq.e.comm.managers.status.SDKStatus;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class a {
    public static JSONObject a() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6 = "";
        JSONObject jSONObject = new JSONObject();
        try {
            str = TTAdSdk.getAdManager().getSDKVersion();
        } catch (Throwable unused) {
            str = "";
        }
        jSONObject.put(AdConfig.UnionType.CSJ, str);
        try {
            str2 = (String) TTAdManager.class.getMethod("getPluginVersion", null).invoke(Class.forName("com.bytedance.sdk.openadsdk.TTAdSdk").getMethod("getAdManager", null).invoke(null, null), null);
        } catch (Exception e10) {
            if (yk.b.a()) {
                e10.printStackTrace();
            }
            str2 = "";
        }
        jSONObject.put("CSJ_PLUGIN", str2);
        try {
            str3 = SDKStatus.getSDKVersion();
        } catch (Throwable unused2) {
            str3 = "";
        }
        jSONObject.put("YLH", str3);
        try {
            str4 = KsAdSDK.getSDKVersion();
        } catch (Throwable unused3) {
            str4 = "";
        }
        jSONObject.put("KUAISHOU", str4);
        try {
            str5 = ATSDK.getSDKVersionName();
        } catch (Throwable unused4) {
            str5 = "";
        }
        jSONObject.put("TOPON", str5);
        try {
            str6 = AdSettings.getSDKVersion();
        } catch (Throwable unused5) {
        }
        jSONObject.put(AdConfig.UnionType.BQT, str6);
        return jSONObject;
    }
}
