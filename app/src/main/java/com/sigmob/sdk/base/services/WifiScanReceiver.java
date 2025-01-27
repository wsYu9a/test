package com.sigmob.sdk.base.services;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.czhj.sdk.common.utils.DeviceUtils;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntityAntiSpan;
import com.sigmob.sdk.base.mta.PointType;
import java.util.List;

/* loaded from: classes4.dex */
public class WifiScanReceiver extends BroadcastReceiver {

    /* renamed from: a */
    public List<ScanResult> f18344a;

    /* renamed from: b */
    public long f18345b = 0;

    @SuppressLint({"MissingPermission"})
    public void a(Context context) {
        try {
            WifiManager wifiManager = DeviceUtils.getWifiManager(context);
            if (wifiManager != null && wifiManager.getWifiState() == 3 && com.sigmob.sdk.base.l.w().k().up_wifi_list_interval.intValue() >= 60) {
                SigmobLog.d("private :use_wifi ");
                SigmobLog.i("scanResult " + wifiManager.startScan());
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0046 A[Catch: all -> 0x002d, TryCatch #0 {all -> 0x002d, blocks: (B:3:0x0002, B:7:0x0009, B:17:0x0041, B:19:0x0046, B:21:0x005c, B:23:0x006a, B:25:0x0070, B:27:0x007b, B:29:0x0083, B:31:0x00bf, B:33:0x00dd, B:36:0x00e0, B:41:0x0023, B:44:0x0030), top: B:2:0x0002 }] */
    @Override // android.content.BroadcastReceiver
    @android.annotation.SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onReceive(android.content.Context r9, android.content.Intent r10) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.services.WifiScanReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }

    public final void a(String str, String str2) {
        PointEntityAntiSpan pointEntityAntiSpan = new PointEntityAntiSpan();
        pointEntityAntiSpan.setCategory(PointCategory.WIFI_LIST);
        pointEntityAntiSpan.setAc_type(PointType.ANTI_SPAM);
        pointEntityAntiSpan.setWifi_id_list(str);
        pointEntityAntiSpan.setWifi_mac_list(str2);
        pointEntityAntiSpan.commit();
    }
}
