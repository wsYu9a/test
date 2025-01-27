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
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ca {
    private static boolean aVQ = false;
    private static final List<a> aVR = new CopyOnWriteArrayList();

    public static class a implements com.kwad.sdk.core.b {
        public String aVS;
        public String aVT;
        public int level;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            x.putValue(jSONObject, "level", this.level);
            x.putValue(jSONObject, "ssid", this.aVS);
            x.putValue(jSONObject, "bssid", this.aVT);
            return jSONObject;
        }
    }

    public static boolean dD(Context context) {
        return (context.getApplicationInfo().targetSdkVersion < 29 || Build.VERSION.SDK_INT < 29) ? Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f11106g) == -1 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f11107h) == -1 : ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f11106g) == -1;
    }

    public static List<a> o(Context context, int i10) {
        if (az.Ok()) {
            return new ArrayList();
        }
        if (!aVQ && ServiceProvider.MB().canReadNearbyWifiList()) {
            List<a> list = aVR;
            if (list.isEmpty() && context != null) {
                if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ac(32L)) {
                    return list;
                }
                try {
                } catch (Exception e10) {
                    aVQ = true;
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
                }
                if (dD(context)) {
                    return list;
                }
                WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
                if (wifiManager == null) {
                    return list;
                }
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                List<ScanResult> scanResults = wifiManager.getScanResults();
                if (scanResults != null) {
                    for (ScanResult scanResult : scanResults) {
                        a aVar = new a();
                        aVar.aVS = scanResult.SSID;
                        aVar.aVT = scanResult.BSSID;
                        aVar.level = scanResult.level;
                        if (connectionInfo.getBSSID() == null || scanResult.BSSID == null || !TextUtils.equals(connectionInfo.getBSSID().replace("\"", ""), scanResult.BSSID.replace("\"", "")) || connectionInfo.getSSID() == null || scanResult.SSID == null || !TextUtils.equals(connectionInfo.getSSID().replace("\"", ""), scanResult.SSID.replace("\"", ""))) {
                            aVR.add(aVar);
                        } else {
                            aVR.add(0, aVar);
                        }
                        List<a> list2 = aVR;
                        if (list2.size() >= i10) {
                            return list2;
                        }
                    }
                }
                return aVR;
            }
        }
        return aVR;
    }
}
