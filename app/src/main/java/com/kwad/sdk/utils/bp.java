package com.kwad.sdk.utils;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class bp {
    private static boolean aBG = false;
    private static final List<a> aBH = new ArrayList();

    public static class a implements com.kwad.sdk.core.b {
        public String aBI;
        public String aBJ;
        public int level;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            t.putValue(jSONObject, "level", this.level);
            t.putValue(jSONObject, "ssid", this.aBI);
            t.putValue(jSONObject, "bssid", this.aBJ);
            return jSONObject;
        }
    }

    public static boolean dd(Context context) {
        return (context.getApplicationInfo().targetSdkVersion < 29 || Build.VERSION.SDK_INT < 29) ? Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f9322g) == -1 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f9323h) == -1 : ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f9322g) == -1;
    }

    public static List<a> m(Context context, int i2) {
        WifiManager wifiManager;
        if (at.Ee()) {
            return new ArrayList();
        }
        if (!aBG && ServiceProvider.CB().canReadNearbyWifiList()) {
            List<a> list = aBH;
            if (list.isEmpty() && context != null) {
                if (((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).E(32L)) {
                    return list;
                }
                try {
                } catch (Exception e2) {
                    aBG = true;
                    com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
                }
                if (dd(context) || (wifiManager = (WifiManager) context.getApplicationContext().getSystemService(com.alipay.mobilesecuritysdk.constant.a.I)) == null) {
                    return list;
                }
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                List<ScanResult> scanResults = wifiManager.getScanResults();
                if (scanResults != null) {
                    for (ScanResult scanResult : scanResults) {
                        a aVar = new a();
                        aVar.aBI = scanResult.SSID;
                        aVar.aBJ = scanResult.BSSID;
                        aVar.level = scanResult.level;
                        if (connectionInfo.getBSSID() == null || scanResult.BSSID == null || !TextUtils.equals(connectionInfo.getBSSID().replace("\"", ""), scanResult.BSSID.replace("\"", "")) || connectionInfo.getSSID() == null || scanResult.SSID == null || !TextUtils.equals(connectionInfo.getSSID().replace("\"", ""), scanResult.SSID.replace("\"", ""))) {
                            aBH.add(aVar);
                        } else {
                            aBH.add(0, aVar);
                        }
                        List<a> list2 = aBH;
                        if (list2.size() >= i2) {
                            return list2;
                        }
                    }
                }
                return aBH;
            }
        }
        return aBH;
    }
}
