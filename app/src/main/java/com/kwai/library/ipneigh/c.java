package com.kwai.library.ipneigh;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.TextUtils;

/* loaded from: classes3.dex */
public final class c {
    private static d b(Context context, boolean z10, boolean z11) {
        String str;
        try {
            if (!b.isWifiConnected(context)) {
                return new d("", false, "");
            }
            String ez = b.ez(((WifiManager) context.getApplicationContext().getSystemService("wifi")).getDhcpInfo().gateway);
            if (z10) {
                str = "";
            } else {
                str = a.hC("timeout 5 ip neigh show " + ez);
            }
            if (z10 || TextUtils.isEmpty(str)) {
                str = KwaiIpNeigh.i(ez, false);
            }
            return new d(b.hE(str), !TextUtils.isEmpty(r3), str);
        } catch (Throwable th2) {
            return new d("", false, th2.getMessage());
        }
    }

    public static d dQ(Context context) {
        return y(context, false);
    }

    private static d y(Context context, boolean z10) {
        return b(context, false, false);
    }
}
